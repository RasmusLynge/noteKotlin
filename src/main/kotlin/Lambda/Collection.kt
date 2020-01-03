package Lambda

var nums = listOf<Int>(1, 2, 3, 4, 5, 6, 65, 87, 7, 68, 7)

fun main() {
    println(nums.map{it * 2})
}