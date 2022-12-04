package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfBadgePrioritiesUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfPrioritiesUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayThreeServiceAlt
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DayThreeTest {
    private val dayThreeService = DayThreeServiceAlt()
    private val sumOfPrioritiesUseCase: SumOfPrioritiesUseCase = dayThreeService
    private val sumOfBadgePrioritiesUseCase: SumOfBadgePrioritiesUseCase = dayThreeService

    @Test
    fun sumOfPriorities() {
        val answer = sumOfPrioritiesUseCase.getSum(readInput("day_3_test"))
        Assertions.assertEquals(157, answer)
        println("Answer day 3 part 1: ${sumOfPrioritiesUseCase.getSum(readInput("day_3_input"))}")
    }

    @Test
    fun sumOfBadgePriorities() {
        val answer = sumOfBadgePrioritiesUseCase.getSumOfBadges(readInput("day_3_test"))
        Assertions.assertEquals(70, answer)
        println("Answer day 3 part 2: ${sumOfBadgePrioritiesUseCase.getSumOfBadges(readInput("day_3_input"))}")
    }
}