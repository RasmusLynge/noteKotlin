package Coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

// Problemet med concurrency er når vi har et shared mutable state, som skal blive ændret i på samme tid.
// Her prøver 100 coroutiner at tælle en counter op 1000 gang hver. (spoiler, det går galt)



suspend fun massiveRunz(action: suspend () -> Unit) {
    val n = 100  // Antal coroutines der bliver startet
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}

/*
// Her går det galt.
var count = 0

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRunz {
      count++
    }
  }
  println("Counter = $count")
}
*/


/*
// Løsning ved brug af atomic datastruktur (synchronized, linearizable). Dette virker dog kun for counters :(
var count = AtomicInteger()

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRun {
      count.incrementAndGet()
    }
  }
  println("Count = $count")
}
*/
