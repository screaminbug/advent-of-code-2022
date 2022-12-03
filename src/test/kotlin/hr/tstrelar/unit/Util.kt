package hr.tstrelar.unit

import java.lang.IllegalArgumentException

fun readInput(name: String): String {
    val filename = "$name.txt"
    return {}::class.java.classLoader.getResource(filename)?.readText() ?: throw IllegalArgumentException("There is no $filename file in resources")
}