package com.example.sulymka_l7_threads

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicLong

fun main() {
    val count: AtomicLong = AtomicLong(0)
    val executor: ExecutorService = Executors.newFixedThreadPool(5)

    val output = Runnable {
        repeat(12) {
            Thread.sleep(1000)
            println(count)
        }
    }

    val magnification = Runnable {
        repeat(1200) {
            Thread.sleep(10)
            count.incrementAndGet()
        }
    }


    repeat(4) {
        executor.execute(magnification)
    }

    executor.execute(output)
    executor.shutdown()
}