package hr.tstrelar.unit

import org.junit.jupiter.api.Assertions
import java.lang.IllegalArgumentException

fun readInput(day: Int, isTest: Boolean = false): String {
    val kind = if (isTest) "test" else "input"
    val filename = "day_${day}_${kind}.txt"
    return {}::class.java.classLoader.getResource(filename)?.readText() ?: throw IllegalArgumentException("There is no $filename file in resources")
}

fun runTestFor(day: Int, part: Int, useCase: (String) -> String?, expected: String) {
    val answer = useCase.invoke(readInput(day, isTest = true))
    Assertions.assertEquals(expected, answer)
    println("Answer for day $day part ${part}: ${useCase.invoke(readInput(day))}")
}