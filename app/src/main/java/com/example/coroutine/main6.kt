package com.example.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    runBlocking {
        //调用withContext函数后会立马将外部协程挂起
        //当代码执行完或，会把最后一行代码的执行结果最为返回值返回·1
        val result= withContext(Dispatchers.Default){
            5+5
        }
        //相当于: val result = async{5+5}.await()
        //不同点在于withContext函数强制要求我们指定一个线程参数
        println(result)
    }
}