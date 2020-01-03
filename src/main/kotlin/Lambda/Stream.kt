package Lambda

// Sequence vs. collection lazy vs. eager

fun main() {
    val result = listOf(1, 2, 3, 4, 5).asSequence()
        .map { n -> n * n }
        .filter { n -> n < 10 }
        .map{println(it)}
        .first()

    println(result)
}