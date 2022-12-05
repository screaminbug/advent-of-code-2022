package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.MoveCrates9001UseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.MoveCratesUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DayFiveService
import org.junit.jupiter.api.Test

internal class Day5Test {
    private val dayFiveService = DayFiveService()
    private val moveCratesUseCase: MoveCratesUseCase = dayFiveService
    private val moveCrates9001UseCase: MoveCrates9001UseCase = dayFiveService

    @Test
    fun moveCratesTest() = runTestFor(
        day = 5,
        part = 1,
        moveCratesUseCase::rearrange,
        "CMZ"
    )

    @Test
    fun moveCrates9001Test() = runTestFor(
        day = 5,
        part = 2,
        moveCrates9001UseCase::rearrange9001,
        "MCD"
    )
}