/* ------------------------------------------------------------------
    Start project 2023.01.11. 07:00
 */
fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

/* ------------------------------------------------------------------
    Declaring variables
 */
fun declaringVariables() {
    var mutable: Int = 1
    mutable = 2 // OK: You can reassign a var.
    val immutable: Double = 2.0
    // immutable = 3.0 // Error: You can't reassign a val!
    var greeting = "Hello, world!" // Inferred as String
    var catchphrase: String? = null // Nullable type
    catchphrase = "Hey, what's up, everybody?"
}

/* ------------------------------------------------------------------
    Nullable types
 */
fun nullableTypes() {
    var name: String? = null // Can hold a String or null
    // Safe cast operator ?.
    // length1 contains name's length if name isn't null; null otherwise
    val length1: Int? = name?.length

    // Elvis operator ?:
    // length1 contains name's length if name isn't null; 0 otherwise
    val length2: Int = name?.length ?: 0
    // The Elvis operator can also execute statements in the case of null values.
    val length3 = name?.length ?: return

    // Non-null assertion operator !!
    name = "Francis"
    val length4: Int = name!!.length // Works if name isn't null; crashes otherwise

    // Smart casts and checking for null
    var nonNullableAuthor: String
    var nullableAuthor: String?
    if (name != null) { // Checking for null
        nonNullableAuthor = name // Smart cast to String
    } else {
        nullableAuthor = name // Smart cast to String?
    }
}

/* ------------------------------------------------------------------
    Control Flow: if expression
 */
fun controlFlowIfExpression() {
    // Using if to choose different paths
    var condition = true
    if (condition) {
        // If condition is true, this gets executed
    } else {
        // If condition is false, this gets executed
    }

    // Using if to set a value
    val x = 100
    val y = 1
    val more = if (x > y) x else y // more == 100
    val less = if (x < y) {
        println("x is smaller.")
        x // The last expression is the block’s value
    } else {
        println("y is smaller.")
        y
    }
}

/* ------------------------------------------------------------------
    Control Flow: when expression
 */
fun controlFlowWhenExpression() {
    // Using when to choose different paths
    val year = 2010
    when (year) {
        2010 -> print("Froyo")
        2011 -> print("Ice Cream Sandwich")
        2008, 2009 -> print("The early days")
        in 2012..2015 -> {
            println("Jellybean through Marshmallow,")
            println("when things got interesting.")
        }
        else -> println("Some other era")
    }

    // Using when to set a value
    val androidEra = when (year) {
        2010 -> "Froyo"
        2011 -> "Ice Cream Sandwich"
        2008, 2009 -> "The early days"
        in 2012..2015 -> {
            print("Jellybean through Marshmallow")
            // The last expression is the block’s value
            "When things got interesting"
        }
        else -> "Some other era"
    }

    // Using when with conditionals to set a value
    val catsOwned = 2
    val dogsOwned = 1
    val judgement = when {
        catsOwned == 0 -> "No cats"
        catsOwned < 0 -> {
            print("Call the cat police!")
            // The last expression is the block’s value
            "Owes someone some cats"
        }
        catsOwned == 1 && dogsOwned == 1 -> "Seeking balance"
        catsOwned > 0 && catsOwned < 3 -> "Yay cats!"
        else -> "Cat Nirvana"
    }
}

/* ------------------------------------------------------------------
    Collections: List
 */
fun collectionsList() {
    val immutableList = listOf("Alice", "Bob")
    val valMutableList = mutableListOf("Carol", "Dave")
    var varMutableList = mutableListOf("Eve", "Frank")

    // One way to test membership
    val isBobThere1 = "Bob" in immutableList
    // Another way to test membership
    val isBobThere2 = immutableList.contains("Bob")

    // Access by index
    val name: String = immutableList[0]
    valMutableList[1] = "Bart" // Update item in list

    // Add item at index
    // immutableList[1] = "Bart" // Error: Can't change
    valMutableList.add(2, "Ellen")

    // Delete by index
    val removedPerson = valMutableList.removeAt(1)
    // Delete by value
    val wasRemoved = valMutableList.remove("Bart")

    // You can change the contents of a val mutable collection, but you CAN'T reassign it:
    varMutableList[0] = "Ellen"
    varMutableList = mutableListOf("Gemma", "Harry")
}

/* ------------------------------------------------------------------
    Collections: Map
 */
fun collectionsMap() {
    val immutableMap = mapOf("name" to "Kirk", "rank" to "captain")

    val mutableMap = mutableMapOf("name" to "Picard", "rank" to "captain")

    // Is this key in the map?
    val hasRankKey = immutableMap.containsKey("rank")

    // Is this value in the map?
    val hasKirkValue = immutableMap.containsValue("Kirk")

    // Access by key, returns nullable
    val name: String? = immutableMap["name"]

    // Update value for key
    mutableMap["name"] = "Janeway"

    // Add new key and value
    mutableMap["ship"] = "Voyager"

    // Delete by key
    mutableMap.remove("rank")

    // Delete by key and value
    mutableMap.remove("ship", "Voyager")

    // Won't work, value doesn't match
    mutableMap.remove("name", "Spock")
}

/* ------------------------------------------------------------------
    Collections: Set
 */
fun collectionsSet() {
    // Sets ignore duplicate items, so immutableSet has 2 items: "chocolate" and “vanilla”
    val immutableSet = setOf<String>("chocolate", "vanilla", "chocolate")
    val mutableSet = mutableSetOf("butterscotch", "strawberry")

    // One way to test membership
    val hasChocolate1 = "chocolate" in immutableSet

    // Another way to test membership
    val hasChocolate2 = immutableSet.contains(" chocolate")

    // Add item
    mutableSet.add("green tea")

    // Delete by value
    val flavorWasRemoved = mutableSet.remove("strawberry")
}

/* ------------------------------------------------------------------
    Control Flow: loops
 */
fun controlFlowLoops() {
    // Iterate Through a Range
    for (i in 0..10) {} // 0 to 10
    for (i in 0 until 10) {} // 0 to 9
    for (i in 1..10 step 2) {} // 1, 3, 5, 7, 9
    for (i in 10 downTo 1) {} // 10 to 1

    // Iterate over map
    val myMap = mapOf("Key1" to "Value1", "Key2" to "Value2", "Key3" to "Value3")
    for ((key, value) in myMap) {
        print("$key -> $value")
    }

    // Iterating Through an Array
    var language1 = arrayOf("English", "France", "Dutch", "Italian")
    for (item in language1) {
        println(item)
    }
    var language2 = arrayOf("Ruby", "Kotlin", "Python", "Java")
    for (item in language2.indices) {
        // printing array elements having even index only
        if (item%2 == 0)
            println(language2[item])
    }

    // Iterating Through a String
    var text= "Kotlin"
    for (letter in text) {
        println(letter)
    }

    // while and do while
    var x = 0
    while (x < 10) {
        x++
        println(x)
    }
    do {
        x--
        println(x)
    } while (x > 0)
}

/* ------------------------------------------------------------------
    Functions
 */
fun functions() {
    fun sayHi() { // A Unit function
        println("Hello")
    }
    // Function with parameters
    fun sayHello(name: String) {
        println("Hello, $name!")
    }
    // Function with default arguments
    fun sayFriendlyHello(name: String = "Friend") {
        print("Hello, $name!")
    }
    // Function with mix of regular and default arguments
    fun createCat(name: String = "Kitty", age: Int, isSpayed: Boolean = false) {
        print("$name / $age / $isSpayed")
    }
    createCat(age = 1) // Using just the non-default argument
    createCat("Fluffy", 2, true) // One way to call a function
    // Calling a function with named arguments
    createCat(age = 2, isSpayed = true, name = "Fluffy")

    // Function with parameters and return value
    fun total(x: Int, y: Int): Int {
        return x + y
    }
    // A function as a single expression
    fun product(x: Int, y: Int) = x * y
    // A function that accepts another function
    fun doMath(mathOperation: (Int, Int) -> Int, a: Int, b: Int): Int {
        return mathOperation(a, b)
    }
    // Calling a function that accepts another function
    val add = doMath(::total, 2, 3)
    val multiply = doMath(::product, 2, 3)
}

/* ------------------------------------------------------------------
    Lambdas
 */
fun lambdas() {
    // Lambda
    val adder: (Int, Int) -> Int = { x, y -> x + y}
    // Lambda with single parameter: it keyword
    val square: (Int) -> Int = { it * it}
    // Passing a lambda to a function
    fun doMath(mathOperation: (Int, Int) -> Int, a: Int, b: Int): Int {
        return mathOperation(a, b)
    }
    val addWithLambda = doMath(adder, 2, 3)
}

/* ------------------------------------------------------------------
    Extensions
 */
fun extensions() {
    // Add the “fizzbuzzQ)” function to the Int class
    fun Int.fizzBuzz(): String {
        return when {
            this % 3 == 0 -> "fizz"
            this % 5 == 0 -> "buzz"
            this % 15 == 0 -> "fizzbuzz"
            else -> this.toString()
        }
    }
    println(6.fizzBuzz()) // Prints "fizz"
    println(8.fizzBuzz()) // Prints "8"

    // Add the "absValue" property to the Int class
    TODO("not working!")
    /*
    val Int.absValue: Int
        get() = abs(this)
    println((-3).absValue) // Prints "3"
     */
}

/* ------------------------------------------------------------------
    Objects
 */
fun objects() {
    TODO("i am here...")
}

/* ------------------------------------------------------------------
    Tempate
 */
fun template() {

}
