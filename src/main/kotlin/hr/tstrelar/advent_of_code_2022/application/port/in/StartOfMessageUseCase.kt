package hr.tstrelar.advent_of_code_2022.application.port.`in`

interface StartOfMessageUseCase {
    fun findStartOfMessage(input: String): String?
}