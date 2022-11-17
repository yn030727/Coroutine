import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        //在协程的作用域下创建子协程
        //子协程特点：外层作用域结束后，该作用域下的所有子协程也会一同结束
        //线程没有顶层一说，永远都是顶层的
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")
        }
        launch {
            println("launch2")
            delay(1000)
            println("launch2 finished")
        }
    }
}