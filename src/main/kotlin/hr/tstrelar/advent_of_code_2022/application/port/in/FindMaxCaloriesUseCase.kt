package hr.tstrelar.advent_of_code_2022.application.port.`in`

import java.math.BigInteger

interface FindMaxCaloriesUseCase {
    fun getMaxCalories(input: String): BigInteger
}