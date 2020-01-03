package Mutability

// Muligheden for at udvide en klasse med ny funktionalitet
// Du kan extende klasser som du normalt ikke har mulighed for at modifisere

// Her laver vi en swap funktion til MutableList


fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main() {
    val list = mutableListOf(1, "to", 3)
    println(list)
    list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
    println(list)

}
