package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.MoveCratesUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayFiveService
import org.junit.jupiter.api.Test

internal class Day5Test {
    private val dayFiveService = DayFiveService()
    private val moveCratesUseCase: MoveCratesUseCase = dayFiveService

    @Test
    fun sumOfPriorities() = runTestFor(
        day = 5,
        part = 1,
        moveCratesUseCase::rearrange,
        "CMZ"
    )

//    @Test
//    fun sumOfBadgePriorities() = runTestFor(
//        day = 5,
//        part = 2,
//        overlappingAssignmentsUseCase::howManyOverlap,
//        expected = "4"
//    )
}