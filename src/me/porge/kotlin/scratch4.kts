package me.porge.kotlin

import com.sun.javaws.exceptions.InvalidArgumentException
import java.util.*

// ================================================================================================

//
// Kotlin: Introduction - DxDroid
// Felipe Porge Xavier
//

// ================================================================================================

println("Functional Programming and Kotlin")

"""
    - Easier to Baby steps + TDD
    - Avoid mutability and side effects = More testable
    - Mutability makes multithreading more complex to implement and maintain
    - Kotlin enables immutable variables with val.
    - Final modifier only avoid instance changing, but does not protect items in a list, for example.
""".trimIndent()


//fun something(calendar: Calendar = Calendar.getInstance()) {
//
//}

// ================================================================================================

println("POO is Imperative, FP is declarative")

// Imperative (ignoring number <= 0)
fun imperativeFactorial(number: Int): Long {
    if (number == 1)
        return 1


    var factorial = 1L
    for (i in 1..number)
        factorial *= number

    return factorial
}


// Declarative (ignoring number <= 0)
//
// Mathematical notation:
//              {  1              if x = 0
// f(x) = x! =  {
//              {  n * (n - 1)!   if x > 0
fun declarativeFactorial(number: Int): Long {
    return when (number) {
        1 -> 1
        else -> number * declarativeFactorial(number - 1)
    }
}

// ================================================================================================

println("Lazy evaluation")

val somethingLazy by lazy {
    mapOf("Lazy" to "initialize the map only after the first use!")
}


// ================================================================================================

println("High-order functions make code cleaner and more concise")


// OLD TIMES: =========

class ExampleButton {
    var listener: OnClickListener? = null
}

interface OnClickListener {
    fun onClick(button: ExampleButton)
}

ExampleButton().listener = object : OnClickListener {
    override fun onClick(button: ExampleButton) {
        println("Button was clicked! :(")
    }
}


// NOW, REAL KOTLIN! =========

class HighOrderFunctionButton(
    val id: Int = 10,
    var listener: ((HighOrderFunctionButton) -> Unit)? = null
)


HighOrderFunctionButton().listener = { button ->
    println("Button was clicked! ${button.id}")
}

HighOrderFunctionButton {
    println("Button was clicked! :D")
}

val funNotNullable = { string: String ->
    println(string)
}

funNotNullable("oi")

val funNullable: ((String) -> Unit)? = { string: String ->
    println(string)
}

funNullable?.let { it("oi") }

// ================================================================================================

println("List Combiners / Operators")

listOf(1, 2, 3, 4, 5)
    .asSequence() // Does the operations without using a temporary list and evaluates the values lazily
    .filter { it % 2 == 0 }
    .sortedBy { it }
    .map { "($it)" }
    .reduce { item, accumulator -> "$item, $accumulator" }
    .let(::println)


// ForEach operator avoids the need of mutable variables.
listOf(1, 2, 3, 4, 5)
    .forEachIndexed { index, value ->
        println("$index: $value")
    }


listOf(1, 2, 3, 4, 5)
    .groupBy { it % 2 == 0 }
    .forEach { (isOdd, numbers) ->
        println(
            "${if (isOdd) "Odd numbers are:" else "Not odd numbers are:"} ${numbers.itemsAsString()}"
        )
    }


// It is an extension! A method that will be available for all List<Int> instances in this context.
fun List<Int>.itemsAsString(): String {
    return map { "$it" }
        .reduceRight { item, acc -> "$item, $acc" }
}


// ================================================================================================

println("Copy to avoid mutability")

data class Dog(val name: String, val age: Int)

Dog("Bob", 20)


// It is an extension! A method that will be available for all Dog instances in this context.
fun Dog.makeOlder(): Dog {
    return copy(age = age + 1)
}


// ================================================================================================

println("Kotlin: Some interesting functions that receive high-order functions")

class Example {
    fun method1() = println("1")

    fun method2() = println("2")

    fun method3() = println("3")

    fun method4(value: Int) = println("$value")

    fun method5() = println("5")

    fun method6(block: () -> Unit) {
        block()
    }
}

val exampleAlso: Example = Example().also {
    it.method2()
    it.method3()

    30 + 40 // Does nothing
}

val exampleApply: Example = Example().apply {
    method3()
    method5()

    20 + 30 // Does nothing
}

val exampleWith = Example()

val withResult = with(exampleWith) {
    method1()
    method4(10)
    method5()
    20 + 40
}

val exampleLet: Example? = Example()

val letResult = exampleLet?.let {
    it.method1()
    it.method2()
    10 + 30
}

val example = Example()
// example.method6({ println("oi") })
example.method6 {
    println("oi")
}

// ================================================================================================

println("Inline Functions!")

// This is an inline function
inline fun <T> lazySize(crossinline listBuilder: () -> List<T>): Int {
    return listBuilder().size
}