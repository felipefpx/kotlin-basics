// ================================================================================================

//
// Kotlin: Introduction - DxDroid
// Felipe Porge Xavier
//

// ================================================================================================

//fun main(args: Array<String>) {
    println("Hello world! :)")
//}

// ================================================================================================

println("Variables")

val something1 = "Hello world"
val something2: String? = null
var something3: Int = 5

// ================================================================================================

println("Primitive Types and Strings")

val something4: String = "Hello world"
var something5: Int = 5
var something6: Long = 5L
val something7: Double = 0.0
var something8: Float = 5.0f
var something9: Boolean = true


// ================================================================================================

println("Null-safety")

val something10: String? = "First is not null o/"
val somethingNull: String? = null

println(something10 ?: "First Is null :/")
println(somethingNull ?: "Second Is null :/")

println(something10?.replace("i", "i!i") ?: "Null!")
println(somethingNull?.replace("i", "i!i") ?: "Null!")

// ================================================================================================

println("If/Else")

val somethingBoolean = something5 > something3

if (somethingBoolean) {
    println("True!")
} else {
    println("False!")
}

// If is an expression!
fun somethingWithIf(boolean: Boolean): Int {
    return if(boolean) 10 else 20
}

println(if(somethingBoolean) "TRUE" else "FALSE")



// ================================================================================================

println("When")

val unknown: Any = "string content"

when (unknown) {
    is String -> { println(unknown.capitalize()) }
    is Int -> { println("LoL ${unknown + 5}")}
    else -> { println("Not possible! :O") }
}

when {
    (something5 > something3) -> println("UhuLL!")
    else -> println(":B")
}

// When is an expression!

fun something(value: String): Int {
    return when (value) {
        "One" -> 1
        "Two" -> 2
        "Three" -> 3
        "Four" -> 4
        else -> -1
    }
}

val value: Any = 10.0f

println(
    when (value) {
        "One" -> 1
        "Two" -> 2
        "Three" -> 3
        "Four" -> 4
        is Boolean -> value.not() // Smart casting
        !is Float -> 500
        else -> -1
    }
)


// ================================================================================================

println("Arrays, Lists and Maps")

val strings = arrayOf("Hello", "World")

val anyItems: List<Any> = listOf(
    1,
    2L,
    3.0f,
    "Something"
)

val integers = listOf(1, 2)
//integers.add(1) // <<< It is not possible :/

val listOfIntegers = mutableListOf<Int>()
listOfIntegers.add(1)

val simpleMap = mapOf(
    Pair("Zero", 0),
    "One" to 1,
    "Two" to 2
)

("One" to 1).let { (key, value) ->
    println("$key $value")
}

// ================================================================================================

println("While")

var counter = 0
do {
    println("While! $counter")
    counter++
} while(something5 > something3 || counter >= 5)

// ================================================================================================

println("For")

for (i in 0..3) {
    println("For $i")
}

val somethingList = listOf(
    "Hi" to "Bah", // This is a pair! Pair<String, String>
    "Bye" to "GNight"
)

for ((greeting, word) in somethingList) {
    println("$greeting -> $word")
}

// ================================================================================================
