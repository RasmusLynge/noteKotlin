package Lambda

// Eksempel på en lambda
// val lambdaName : Type = { argumentList -> codeBody }
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }


// Normale funktioner og deres lambda udgave.
fun square(x: Int): Int {
    return x * x
}
val sqrt = {x: Int -> x*x}

// Lambda med type definition
fun compare(a: String, b: String): Boolean{
    return a.length < b.length
}
val comp:(String, String) -> Boolean = { a, b -> a.length < b.length }

fun main() {
    println(compare("Hej", "Hejsa"))
    println(comp("Hej", "hejsa"))

    println(square(3))
    println(sqrt(3))

    val nums = listOf(1, 2, 3, 4, 5)
    println(nums.map{it * 2})

}