package Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

// Channels er en god måde at sende værdier imellem coroutiner.
// Channels sender en stream af values ved hjælp af coroutiner.
// Channels suspender send og recieve operationer.





fun main2() = runBlocking {
    val channel = Channel<Int>()
    launch {
        for (x in 1..5) channel.send(x * x)
        channel.close() // we're done sending
    }
// here we print received values using `for` loop (until the channel is closed)
    for (y in channel) println(y)
    println("Done!")
}






// I dette eksempel er er to coroutiner "ping" og "pong", som ændre i den samme "ball" objekt, som er delt igennem table channel
// Her kan vi se hvordan first-in first-out virker
// Ping bliver oprettet først og er derfor den første der får bolden. Pong er i queue derefter.
data class Ball(var hits: Int)

fun main() = runBlocking {
    val table = Channel<Ball>() // a shared table
    launch { player("ping", table) }
    launch { player("pong", table) }
    table.send(Ball(0)) // serve the ball
    delay(1000) // delay 1 second
    coroutineContext.cancelChildren() // game over, cancel them
}

suspend fun player(name: String, table: Channel<Ball>) {
    for (ball in table) { // receive the ball in a loop
        ball.hits++
        println("$name $ball")
        delay(300) // wait a bit
        table.send(ball) // send the ball back
    }
}