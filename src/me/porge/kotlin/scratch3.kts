package me.porge.kotlin

// ================================================================================================

//
// Kotlin: Introduction - DxDroid
// Felipe Porge Xavier
//

// ================================================================================================

class Dog
@JvmOverloads
constructor (
    val name: String = "", // These are properties
    var age: Int = 10,
    val photoUrl: String? = null
) : Animal {

    var grow: String = ""
        set(value) {
            field = "$name($age): $value"
        }

    // This is a field
    val firstLetter: String
        get() = name.first().toString()

//    override fun grow() {
//        println(grow)
//    }

    companion object {
        @JvmStatic
        fun newDog(name: String, age: Int) = Dog(name, age)
    }
}

Dog(age = 15)

// ================================================================================================

object Table {
    var length = 3f
    const val width = 1.5f
}

println("${Table.length} x ${Table.width}m")

// ================================================================================================

interface Animal {
    fun grow(): Unit {
        println("Arrrwwnn...")
    }

    fun error(): Nothing {
        throw Exception()
    }
}

val dog = Dog.newDog("Bob", 5).apply { grow = "AUUUUUUU!!!" }
dog.grow()

// ================================================================================================

class Person<ANIMAL: Animal>(
    val animal: ANIMAL
)

println(Person(dog).animal.name)
