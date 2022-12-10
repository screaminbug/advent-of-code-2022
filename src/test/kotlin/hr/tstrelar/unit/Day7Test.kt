package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindDirsOfSizeUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FreeEnoughSpaceUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DaySevenService
import org.junit.jupiter.api.Test

internal class Day7Test {
    private val daySevenService = DaySevenService()
    private val findDirsOfSizeUseCase: FindDirsOfSizeUseCase = daySevenService
    private val freeEnoughSpaceUseCase: FreeEnoughSpaceUseCase = daySevenService

    @Test
    fun findStartOfPacketTest() = runTestFor(
        day = 7,
        part = 1,
        findDirsOfSizeUseCase::sumDirsOfSizeAtMost100000,
        "95437"
    )
    @Test
    fun freeSpaceTest() = runTestFor(
        day = 7,
        part = 2,
        freeEnoughSpaceUseCase::freeSpace,
        "24933642"
    )
}