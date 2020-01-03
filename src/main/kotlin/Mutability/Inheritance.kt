package Mutability



open class Shape {
    open val edges: Int? = 0 //
    open fun draw() { TODO() }  // For at andre klasser skal kunne nedarve bruger vi open keywordet
    fun fill() { TODO() }

}

class Circle() : Shape() {
    override fun draw() { TODO() }
    // fun fill() { /*...*/ } // Man vil ikke kunne override fill metoden
}

class Square() : Shape() {
    override val edges: Int = 4
    override fun draw() { TODO() }
}


fun main() {
    /*
    val sqr = Square()
    sqr.fill()
     */



    val person = Person("Rasmus", 10)
    person.age = 10
    println(person.age)
}


// Eksempel på custom getter og setter
class Person(val name: String, age: Int) {
    var age: Int = age+10
        set(value) {
            field += value
            println("Setting age to $field")
        }
}
