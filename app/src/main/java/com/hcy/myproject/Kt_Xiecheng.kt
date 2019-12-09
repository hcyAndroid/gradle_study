package com.hcy.myproject

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

/**
 *@创建人：hcy
 *@创建时间：2019-11-29
 *@作用描述：Function
 *@email:384317693@qq.com
 **/
fun main() {
    // fun2()
    // fun3()
    //fun4()

    //fun10()
    //fun11()


//    runBlocking {
//        launch {
//            fun13()
//        }
//        delay(5000)
//    }
    // fun15()
   // fun16()
    fun17()
    println("主线程下运行")

}


fun fun1() {
    GlobalScope.launch {
        delay(1000L)
        println("World!!!")
    }
    println("Hello,")
    Thread.sleep(2000L)
}

fun fun2() {
    GlobalScope.launch {
        delay(1000)
        println("hcy2019")
    }
    println("hello！！")
    runBlocking {
        delay(2000)
    }
}

fun fun3() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("hcy2019")
    }
    println("hello！！")
    delay(2000)
}

fun fun4() = runBlocking {
    val a = GlobalScope.launch {
        delay(1000)
        println("hcy2019")
    }
    println("hello！！")
    a.join()    //让主线程等待直到协程执行结束
}


fun fun5() = runBlocking {
    launch {
        //delay(1000)
        println("World,")
    }
    launch {
        //delay(1000)
        println("Worldsss,")
    }
    println("Hello.ddd")
}

fun fun6() = runBlocking {
    println("阻塞了当前线程")
    delay(10000)
}

fun fun7() = runBlocking {
    launch {
        delay(100)
        println("runBlocking->launch")
    }
    coroutineScope {
        launch {
            delay(200)
            fun8()
            println("coroutineScope->launch")
        }
        delay(300)
        println("coroutineScope->end")
    }
    println("runBlocking->end")
}

//定义协程内方法
suspend fun fun8() {
    println("fun8->执行")
}

suspend fun fun10() {
    var i = 1
    val job = coroutineScope {
        launch {
            repeat(30) {
                delay(1000)
                if (i == 10) {
                    this.cancel()
                }
                println(i++)
            }
        }
    }
    println("=======${i}====")
    job.join()
}

fun fun9() = runBlocking {
    var i = 1
    val job = launch {
        repeat(30) {
            delay(1000)
            if (i == 10) {
                this.cancel()
            }
            println(i++)
        }
    }
    println("=======${i}====")
//    if (i==20){
//        job.cancel()
//    }
    job.join()
}


fun fun11() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var next = startTime
        var i = 0
        while (i < 5) {
            if (i == 3) {
                this.cancel()
            }
            if (System.currentTimeMillis() > next) {
                println("=====${i++}")
                next += 500
            }
        }
    }
    delay(1300)
    println("准备取消子协程")
    job.cancelAndJoin()
    println("子协程已经取消")
}


fun fun12() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextTime = startTime
        var i = 0
        while (isActive) {
            if (System.currentTimeMillis() >= nextTime) {
                println("job:=====${i++}===")
                nextTime += 500
            }
        }


    }
    delay(1300)
    println("主线程===准备取消协程")
    job.cancelAndJoin()
    println("主线程===协程已经取消了")
}

suspend fun fun13() {
    withContext(Dispatchers.IO) {
        println("当前线程===${Thread.currentThread().name}")
    }
    println("当前线程222===${Thread.currentThread().name}")
}


suspend fun fun14() {
    delay(1000)
}

//通道
fun fun15() = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (x in 1..5) {
            println("发送通道数据${x}")
            channel.send(x)
        }
    }
    repeat(5) {
        println("打印通道的数据${channel.receive()}")
    }
    println("通道打印完毕")
}


fun fun16() = runBlocking {
    val ca = Channel<Int>()
    launch {
        for (x in 1..5) {
            if (!ca.isClosedForSend) {
                println("通过通道发送数据$x")
                ca.send(x)
            }
            delay(2000)
            //把通道关闭
            ca.close()
        }
    }
    for (x in ca) {
        println("循环打印通道里额数据$x")
    }
}

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) {
        println("通过通道发送数据$x")
        send(x)
    }
}

fun fun17() = runBlocking {
    //遍历通道
    produceSquares().consumeEach {
        println("遍历打印通道里额数据$it")
    }
}