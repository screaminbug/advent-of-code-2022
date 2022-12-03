package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUpdatedUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayTwoService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayTwoTest {

    private val dayTwoService = DayTwoService()

    private val calculateRpsScoreUseCase: CalculateRpsScoreUseCase = dayTwoService
    private val calculateRpsScoreUpdatedUseCase: CalculateRpsScoreUpdatedUseCase = dayTwoService

    @Test
    fun simulateGame() {
        val answer = calculateRpsScoreUseCase.calculateScore(readInput("day_2_test"))
        assertEquals(15, answer)
        println("Answer day 2 part 1: ${calculateRpsScoreUseCase.calculateScore(readInput("day_2_input"))}")
    }

    @Test
    fun simulateGamePartTwo() {
        val answer = calculateRpsScoreUpdatedUseCase.calculateScoreUpdated(readInput("day_2_test"))
        assertEquals(12, answer)
        println("Answer day 2 part 2: ${calculateRpsScoreUpdatedUseCase.calculateScoreUpdated(readInput("day_2_input"))}")
    }

}