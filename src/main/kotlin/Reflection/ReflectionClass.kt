package Reflection

// Kig projekt 1

class ReflectionDemo {
}

fun main()
{
    // Reference lavet ud fra class name
    val abc = ReflectionDemo::class
    println("This is a class reference: $abc")

    // Reference fået fra object
    val obj = ReflectionDemo()
    println("This is a bounded class reference: ${obj::class}")
}