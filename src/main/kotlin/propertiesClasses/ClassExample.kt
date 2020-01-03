package propertiesClasses

/* Java eksempel:

public class Person {
private String name;
private int age;

public String getName() {
return this.name;
}

 public void setName(String name) {
 this.name = name;
 }

 public int getAge() {
 return this.age;
 }

}

 */

class Person(var name: String, val age: Int)

data class PersonData(val name: String, var age: Int)

fun main() {
    val person = Person("Rasmus", 10)
    println(person)

    val personData = PersonData("Rasmus", 10)
    println(personData)

    val personData2 = personData.copy(name = "Rasmus2")
    println(personData2)

    val (name, age) = personData
    println("$name is $age years old")

}