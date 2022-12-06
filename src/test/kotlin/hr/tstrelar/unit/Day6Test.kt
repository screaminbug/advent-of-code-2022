package hr.tstrelar.unit

import hr.tstrelar.advent_of_code_2022.application.port.`in`.StartOfMessageUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.StartOfPacketUseCase
import hr.tstrelar.advent_of_code_2022.application.service.DaySixService
import org.junit.jupiter.api.Test

internal class Day6Test {
    private val daySixService = DaySixService()
    private val findStartOfPacketUseCase: StartOfPacketUseCase = daySixService
    private val findStartOfMessageUseCase: StartOfMessageUseCase = daySixService

    @Test
    fun findStartOfPacketTest() = runTestFor(
        day = 6,
        part = 1,
        findStartOfPacketUseCase::findStartOfPacket,
        "10"
    )

    @Test
    fun findStartOfMessageTest() = runTestFor(
        day = 6,
        part = 2,
        findStartOfMessageUseCase::findStartOfMessage,
        "29"
    )

}