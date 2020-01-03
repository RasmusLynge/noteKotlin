package propertiesClasses

// Sealed classes i kotlin er en slags extension af en enum class.
//

sealed class Operation {
    class Add(val value: Int) : Operation()
    class Substract(val value: Int) : Operation()
    class Multiply(val value: Int) : Operation()
    class Divide(val value: Int) : Operation()
    class Mod(val value: Int) : Operation()
    object Increment : Operation()
    object Decrement : Operation()
}

fun execute(x: Int, op: Operation) = when (op) {
    is Operation.Add -> x + op.value
    is Operation.Substract -> x - op.value
    is Operation.Multiply -> x * op.value
    is Operation.Divide -> x / op.value
    is Operation.Mod -> x % op.value

    Operation.Increment -> x + 1
    Operation.Decrement -> x - 1
}

fun main() {
    var x = 8
    val test = execute(x, Operation.Divide(4))
    println(test)



    println(x)
    x = execute(x,Operation.Increment)
    println(x)

}