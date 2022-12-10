package hr.tstrelar.advent_of_code_2022.application.port.`in`

interface FindDirsOfSizeUseCase {
    fun sumDirsOfSizeAtMost100000(input: String): String
}