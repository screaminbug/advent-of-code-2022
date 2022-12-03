package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfBadgePrioritiesUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfPrioritiesUseCase
import kotlin.streams.toList

class DayThreeService : SumOfPrioritiesUseCase, SumOfBadgePrioritiesUseCase {
    override fun getSum(input: String) = input.split(NL).map { rucksack ->
            val compartments = rucksack.chunked(rucksack.length / 2)
            compartments[0].chars().filter { first ->
                compartments[1].chars().anyMatch { second ->
                    second == first
                }
            }.map(this::itemCodeToPriority).toList()
        }.sumOf {
            it[0]
        }


    override fun getSumOfBadges(input: String) = input.split(NL).chunked(3).map { compartments ->
        compartments[0].chars().filter { first ->
            compartments[1].chars().anyMatch { second ->
                first == second
            }
        }.filter {
            compartments[2].chars().anyMatch { third ->
                it == third
            }
        }.map(this::itemCodeToPriority).toList()
        }.sumOf {
            it[0]
        }

    private fun itemCodeToPriority(symbol: Int): Int {
        val converted = symbol and 0x1F
        return if (symbol and 0x20 == 0x20) converted else converted + 26
    }
}