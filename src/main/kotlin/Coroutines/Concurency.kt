package Coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

suspend fun massiveRun(action: suspend () -> Unit) {
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


// Løsning ved brug af thread-confinement fine-grained
// Her har vi en enkelt tråd der står for at counte og resten kalder denne.
// Bliver mest brugt til UI (ca. 250 ms)

//Dette virker dor langsomt, da der kun er en tråd der står for at "counte"



val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

fun main() = runBlocking {
  withContext(Dispatchers.Default) {
    massiveRun {
      // confine each increment to a single-threaded context
      withContext(counterContext) {
        counter++
      }
    }
  }
  println("Counter = $counter")
}


/*
// Thread confinement Coarse-Grained
// Her pakker vi vores coroutiner ind i vores singlethreadcontext fra start af.
// Meget hurtigere (ca 17 ms)



val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

fun main() = runBlocking {
  // confine everything to a single-threaded context
  withContext(counterContext) {
    massiveRun {
      counter++
    }
  }
  println("Counter = $counter")
}
*/
