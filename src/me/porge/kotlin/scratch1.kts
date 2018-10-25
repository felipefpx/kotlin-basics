package me.porge.kotlin

// ================================================================================================

//
// Kotlin: Introduction - DxDroid
// Felipe Porge Xavier
//

// ================================================================================================

println(
    """
        About Kotlin:

        - In July 2011, JetBrains unveiled Project Kotlin, a new language for the JVM
        - It had been under development for a year
        - 100% interoperable with Java
        - Influenced by Java, Scala, Groovy, C#, Gosu, JavaScript
        - Google announced official support for Android
        - It is a programming language for JVM, Android, Web (JS) and Native
        - Concise
        -
    """.trimIndent()
)


// ================================================================================================

println(
    """
        Kotlin fixes a series of issues that Java suffers from:

        - Null references are controlled by the type system.
        - No raw types
        - Arrays in Kotlin are invariant
        - Kotlin has proper function types, as opposed to Java's SAM-conversions
        - Use-site variance without wildcards
        - Kotlin does not have checked exceptions
    """.trimIndent()
)


// ================================================================================================

println(
    """
        What Java has that Kotlin does not:

        - Checked exceptions
        - Primitive types that are not classes
        - Static members
        - Non-private fields
        - Wildcard-types: https://kotlinlang.org/docs/reference/generics.html
        - Ternary-operator a ? b : c
    """.trimIndent()
)


// ================================================================================================

println(
    """
        What Kotlin has that Java does not:

        - Type inference for variable and property types
        - Lambda expressions + Inline functions = performant custom control structures
        - Extension functions
        - Default parameters
        - Null-safety
        - Smart casts
        - String templates     "${10 + 20}"
        - Properties
        - Primary constructors
        - First-class delegation
        - Native Singletons
        - Declaration-site variance & Type projections       (in / out)
        - Range expressions        (1..10).map { println(it) }
        - Operator overloading      override fun something() { }
        - Companion objects
        - Data classes
        - Separate interfaces for read-only and mutable collections \o/
        - Coroutines
    """.trimIndent()
)


// ================================================================================================

println(
    """
        Some links:

        https://kotl.in
        https://play.kotl.in
        https://www.slant.co/versus/112/1543/~java_vs_kotlin
        https://kotlinlang.org/docs/reference/comparison-to-java.html
        https://fabiomsr.github.io/from-java-to-kotlin/index.html
        https://kotlinlang.org/docs/reference/generics.html
    """.trimIndent()
)
