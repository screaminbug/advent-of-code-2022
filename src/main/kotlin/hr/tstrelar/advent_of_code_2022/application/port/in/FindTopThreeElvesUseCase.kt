package hr.tstrelar.advent_of_code_2022.application.port.`in`

import java.math.BigInteger

interface FindTopThreeElvesUseCase {
    fun findTopThree(input: String): BigInteger
}