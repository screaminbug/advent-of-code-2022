package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindMaxCaloriesUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FindTopThreeElvesUseCase
import java.math.BigInteger


class DayOneService : FindMaxCaloriesUseCase, FindTopThreeElvesUseCase {

    override fun getMaxCalories(input: String): String {
        val summed = getElvesSummed(input)
        return summed.maxOrNull().toString()
    }

    override fun findTopThree(input: String): String {
        val summed = getElvesSummed(input)
        return summed.sorted().takeLast(3).reduce { acc, e -> acc + e }.toString()
    }

    private fun getElvesSummed(input: String) =
        input.split("$NL$NL").map {
            it.split(NL)
        }.map { elf ->
            elf.map(::BigInteger)
                .reduce { acc, e ->
                    acc + e
                }
        }
}