package Lambda

fun hvis(test: Boolean, block: () -> Unit): Boolean {
    if (test) block()
    return test
}

infix fun Boolean.ellers(block: () -> Unit) {
    if (!this) block()
}

fun main() {
    hvis (5 == 7) {
        println("True")
    } ellers {
        println("FALSE!")
    }
    println("DONE!")
}