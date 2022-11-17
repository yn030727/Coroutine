package com.example.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val start=System.currentTimeMillis()
        val deferred1=async {
            delay(1000)
            5+5
        }
        val deferred2=async {
            delay(1000)
            4+6
        }
        //在需要结果的时候我们才调用await函数进行获取，这样两个async函数就变成了一个并行关系
        println("result is ${deferred1.await()+deferred2.await()}.")
        val end=System.currentTimeMillis()
        println("cost ${end-start} milliseconds.")
    }
}