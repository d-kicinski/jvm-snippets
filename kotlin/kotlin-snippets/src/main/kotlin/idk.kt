import java.util.stream.IntStream
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.streams.asStream
import kotlin.streams.toList

fun forLoop() {
    val items: List<String> = listOf<String>("apple", "banana", "mango")
    val itemsMutable: MutableList<String> = mutableListOf<String>("apple", "banana", "mango")
    itemsMutable.add("avocado")

    val list: List<Int> = ArrayList<Int>()
    for (item: String in items) {
        println(item)
    }

    val map: MutableMap<Int, String> = HashMap<Int, String>()
    map[0] = "Zero";
    map[1] = "One"
    map[2] = "Two"

    for (entry in map) {
        println("key: ${entry.key}, value: ${entry.value}")
    }
}


fun whenExpression(value: Int): String {
    return when (value) {
        8 -> "Eight"
        1 -> "One"
        else -> value.toString()
    }
}

fun iterateOverRanges() {
    for (x in 0..10) {
        print(x)
    }
    println()
    for (x in 10 downTo 0) {
        print(x)
    }
}


fun collections() {
    val fruits = listOf<String>("banana", "avocado", "apple", "mango")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it.last() }
        .map { e: String -> e.uppercase() }
        .forEach(::println)

    val values = IntStream.range(0, 10000000)
        .parallel()
        .mapToDouble { it.toDouble() }
        .map { sqrt(it) }
        .map { sin(2 * PI * it) }
        .map { exp(it) }
        .mapToInt { it.toInt() }
        .filter { it % 2 == 0 }
        .toList()

    val mean = values.sum() / values.size
    println("mean = $mean")
}

class Tweet(content: String) {
    var content: String = content
        get() {
            return if (field == field.uppercase()) {
                field.lowercase()
            } else {
                field.uppercase()
            }
        }
        set(value) {
            field = value.uppercase()
        }
}

fun classProperties() {
    val tweet = Tweet(content = "Hello, world!")
    println(tweet.content)
    tweet.content = "Oh! My!"
    println(tweet.content)
}

class Person(var name: String, var age: Int, var city: String) {

    fun moveTo(newCity: String) {
        city = newCity
    }

    fun incrementAge() {
        age++
    }

    override fun toString(): String {
        return "Person(name = $name, age = $age, city = $city)"
    }
}

fun scopeFunctions() {
    var person = Person("Alice", 20, "Amsterdam")

    // Executing lambda on non-null object
    val res: Boolean = person.let {
        it.moveTo("Warsaw")
        it.incrementAge()
        true
    }
    println(person)

    // Object configuration and returning results
    val res2: Boolean = person.run {
        name = "Bob"
        age = 22
        city = "Moscow"
        false
    }
    println(person)

    // Kind of block of code with possible result
    val res3: String = run {
        val hiddenInRunScope = 69  // hehe
        println("run { hiddenInRunScope = $hiddenInRunScope }")
        "Hello, world :("
    }

    // Grouping function calls on an object
    val res4: List<String> = with(person) {
        name = "Bobby"
        listOf(name, city)
    }

    // Object configuration
    val sadBobby = person.apply { name = "Bobby :(" }

    // Additional effect
    val happyBobby = person.also { it.name = "Bobby :)" }
}


