package com.example.firstappkotlin

fun main(){
    var num = 10
    val astring = "Hi this is a number: $num"
    println(astring)

    val keyValueMap = mapOf("key1" to 123, "key2" to 987, Pair("key3", 456))
    println(keyValueMap["key1"])

    for(value in 1 .. 10){
        println(value)
    }
    val valueToCheck = "hello"
    val out = when(valueToCheck){
        "hello" -> "world"
        "world" -> "hello"
        else -> "nothing"
    }
    println(out)

    val nullableString: Int? = null

    if(nullableString != null) {
        println(nullableString.times(5))
    }

    highOrderFunction(inputFunction = ::printerFunction)
    highOrderFunction{
        first, second -> println("Wow $first $second")
    }
}

fun printerFunction(first: String, second: Int) = println("$first $second")

fun nullSafeOperation(num:Int) {
    println(num.times(5))
}

fun highOrderFunction(inputFunction : (String, Int) -> Unit) {
    inputFunction("Hello", 5)
}
