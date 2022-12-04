package hr.tstrelar.advent_of_code_2022.application.port.`in`

interface CalculateRpsScoreUseCase {
    fun calculateScore(input: String): String
}