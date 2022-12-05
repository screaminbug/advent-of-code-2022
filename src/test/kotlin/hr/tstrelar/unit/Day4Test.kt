package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.FullyOverlappingAssignmentsUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.OverlappingAssignmentsUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayFourService
import org.junit.jupiter.api.Test

internal class Day4Test {
    private val dayFourService = DayFourService()
    private val fullyOverlappingAssignmentsUseCase: FullyOverlappingAssignmentsUseCase = dayFourService
    private val overlappingAssignmentsUseCase: OverlappingAssignmentsUseCase = dayFourService

    @Test
    fun findFullyOverlappingAssignments() = runTestFor(
        day = 4,
        part = 1,
        fullyOverlappingAssignmentsUseCase::howManyFullyOverlap,
        "2"
    )

    @Test
    fun findOverlappingAssignments() = runTestFor(
        day = 4,
        part = 2,
        overlappingAssignmentsUseCase::howManyOverlap,
        expected = "4"
    )
}