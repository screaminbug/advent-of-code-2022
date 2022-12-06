package hr.tstrelar.advent_of_code_2022.application.port.`in`

interface StartOfPacketUseCase {
    fun findStartOfPacket(input: String): String?
}