package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindMaxCaloriesUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindTopThreeElvesUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayOneService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class DayOneTest {

    private val dayOneService = DayOneService()

    private val findMaxCaloriesUseCase: FindMaxCaloriesUseCase = dayOneService
    private val findTopThreeElvesUseCase: FindTopThreeElvesUseCase = dayOneService

    @Test
    fun mostCalories() {
        val answer = findMaxCaloriesUseCase.getMaxCalories(readInput("day_1_test"))
        assertEquals(BigInteger("24000"), answer)
        println("Answer day 1 part 1: ${findMaxCaloriesUseCase.getMaxCalories(readInput("day_1_input"))}")
    }

    @Test
    fun topThree() {
        val answer = findTopThreeElvesUseCase.findTopThree(readInput("day_1_test"))
        assertEquals(BigInteger("45000"), answer)
        println("Answer day 1 part 2: ${findTopThreeElvesUseCase.findTopThree(readInput("day_1_input"))}")
    }

}