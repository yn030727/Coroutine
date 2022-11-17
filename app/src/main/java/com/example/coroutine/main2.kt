package com.example.coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    val start=System.currentTimeMillis();
    runBlocking {
        repeat(100000){
            launch {
                println(".")
            }
        }
    }
    //这里再作用域中创建了10万个协程，虽然只是简单的打印了一个.
    //但他的耗时事件很短，只用了600毫秒
    //如果你开启的是10玩个线程，那么程序应该已经出先OOM异常了
    val end=System.currentTimeMillis()
    println(end-start)
}
suspend fun printDot(){
    println(".")
    //这个时候我们就可以在printDot()函数中调用delay()函数了
    delay(1000)
    //但是suspend关键字中只能将一个函数声明成挂起函数，是无法提供协程作用域的
    //此时你无法在当前函数调用launch函数，因为launch函数必须在协程作用域中才能调用
}

//借助coroutineScope函数来解决
//coroutineScope是一个挂起函数，它可以在任何其他挂起函数中调用
//它的特点是会继承外部协程的作用域并创建一个子协程
suspend fun printDot2()= coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}