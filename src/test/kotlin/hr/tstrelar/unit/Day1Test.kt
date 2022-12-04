package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindMaxCaloriesUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindTopThreeElvesUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayOneService
import org.junit.jupiter.api.Test

internal class Day1Test {
    private val dayOneService = DayOneService()
    private val findMaxCaloriesUseCase: FindMaxCaloriesUseCase = dayOneService
    private val findTopThreeElvesUseCase: FindTopThreeElvesUseCase = dayOneService

    @Test
    fun mostCalories() = runTestFor(
        day = 1,
        part = 1,
        useCase = findMaxCaloriesUseCase::getMaxCalories,
        expected = "24000"
    )
    @Test
    fun topThree() = runTestFor(
        day = 1,
        part = 2,
        useCase = findTopThreeElvesUseCase::findTopThree,
        expected = "45000"
    )
}