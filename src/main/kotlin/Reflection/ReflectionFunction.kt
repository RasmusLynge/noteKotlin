package Reflection

fun add(a: Int,b: Int) : Int{
    return a+b;
}

fun add(a: String,b: String): String{
    return """$a$b"""
}

fun isDivisibleBy3(a: Int): Boolean{
    return a%3 == 0
}
fun main(){
    // Funktionsrefference fundet ved hjælp af :: operator
    val ref1 = ::isDivisibleBy3
    val array = listOf<Int>(1,2,3,4,5,6,7,8,9)
    println(array.filter(ref1))

    // Function reference ud fra en overloaded funktion ved specifikt at vælge typen
    val ref2: (String,String) -> String = ::add;
    println(ref2)

    // Funktionsrefference fundet implicit
    val x = add(3,5)
    println(x)
}