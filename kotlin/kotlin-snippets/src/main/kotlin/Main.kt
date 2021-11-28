import kotlin.reflect.KFunction1

fun customRun(f: () -> Unit): Unit {
    println("Calling function")
    f.invoke()
}

fun customRunWithParameter(f: (Int) -> Unit, p: Int): Unit {
    println("Calling function with parameter $p")
    f.invoke(p)
}

fun plainOldFunction(): Unit {
    println("Plain old function")
}

fun plainOldFunctionWithParameter(p: Int): Unit {
    println("Plain old function with parameter: $p")
}

class Foo(s: String) {
    val name: String = s

    fun hello(): Unit {
        println("Hello, $name")
    }

    fun hello(s: String): Unit {
        println("Hello, $s")
    }
}

fun Foo.hi(): Unit {
    println("Hi, $name")
}


fun main(args: Array<String>) {
    run(::plainOldFunction)
    run { println("run { println() }") }
    customRun(::plainOldFunction)
    customRun { println("Lambda expression passed in {}") }
    customRunWithParameter(::plainOldFunctionWithParameter, 42)
    customRunWithParameter({p: Int -> println("Lambda expression with parameter $p")}, 24)


    val foo = Foo("World")
    foo.hello()
    foo.hello("World2 ")
    foo.hi()

}