package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUpdatedUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayTwoService
import org.junit.jupiter.api.Test

internal class Day2Test {

    private val dayTwoService = DayTwoService()

    private val calculateRpsScoreUseCase: CalculateRpsScoreUseCase = dayTwoService
    private val calculateRpsScoreUpdatedUseCase: CalculateRpsScoreUpdatedUseCase = dayTwoService

    @Test
    fun simulateGame() = runTestFor(
        day = 2,
        part = 1,
        useCase = calculateRpsScoreUseCase::calculateScore,
        expected = "15"
    )
    @Test
    fun simulateGamePartTwo() = runTestFor(
        day = 2,
        part = 2,
        useCase = calculateRpsScoreUpdatedUseCase::calculateScoreUpdated,
        expected = "12"
    )
}