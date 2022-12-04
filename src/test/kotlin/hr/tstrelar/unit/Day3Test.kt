package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfBadgePrioritiesUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfPrioritiesUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayThreeService
import hr.tstrelar.advent_of_code_2022.application.service.DayThreeServiceAlt
import org.junit.jupiter.api.Test

internal class Day3Test {
    private val dayThreeService = DayThreeServiceAlt()
//    private val dayThreeService = DayThreeService()
    private val sumOfPrioritiesUseCase: SumOfPrioritiesUseCase = dayThreeService
    private val sumOfBadgePrioritiesUseCase: SumOfBadgePrioritiesUseCase = dayThreeService

    @Test
    fun sumOfPriorities() = runTestFor(
        day = 3,
        part = 1,
        useCase = sumOfPrioritiesUseCase::getSum,
        expected = "157"
    )
    @Test
    fun sumOfBadgePriorities() = runTestFor(
        day = 3,
        part = 2,
        useCase = sumOfBadgePrioritiesUseCase::getSumOfBadges,
        expected = "70"
    )
}