package com.example.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main(){
    val job= Job()
    //这里的CoroutineScope()是个函数
    //可以返回一个CoroutineScope对象(有了这个对象后，我们可以随时调用它的launch函数来创建一个协程）
    //这个函数需要的参数是context
    val scope= CoroutineScope(job)
    //所以之后所有的子协程都会被关联在Job对象的作用域下面，这样只需要调用一次cancel方法后
    //就可以将同一作用域内的所有协程全部取消
    scope.launch {
        //处理具体的逻辑
    }
    job.cancel()
}