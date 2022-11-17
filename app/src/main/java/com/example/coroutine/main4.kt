package com.example.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val result =async {
            //async函数的代码块中进行一个简单的数学运算
            5+5
        }.await()//调用await方法获取运算结果
        println(result)
    }
}