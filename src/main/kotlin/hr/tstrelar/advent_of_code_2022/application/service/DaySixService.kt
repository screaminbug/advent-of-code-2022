package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.advent_of_code_2022.application.port.`in`.StartOfMessageUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.StartOfPacketUseCase

class DaySixService : StartOfPacketUseCase, StartOfMessageUseCase {
    override fun findStartOfPacket(input: String) = findStartOf(input, 4)
    override fun findStartOfMessage(input: String) = findStartOf(input, 14)

    private fun findStartOf(input: String, distinctCharCount: Int) = input.windowed(distinctCharCount, 1)
        .firstOrNull {
            it.fold(setOf<Char>()) { acc, s -> acc + s }.size == distinctCharCount
        }?.let {
            "${input.indexOf(it) + it.length}"
        }
}