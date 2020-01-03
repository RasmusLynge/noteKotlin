package Mutability


val number = 1

val numbers = mutableListOf<Int>( 1, 2, 3, 4)
var numberz = listOf<Int>( 1, 2, 3, 4)


fun main() {

    //number = 0

    // Man kan ikke lave en add på numberz
    numbers.add(3, 5)
    numberz.get(3)

    // Viser hvordan val var virker
    numberz = numbers
    //numbers = numberz
}


// Funktionel prog
/*
- Sandt hver gang man kalder metoder
 */