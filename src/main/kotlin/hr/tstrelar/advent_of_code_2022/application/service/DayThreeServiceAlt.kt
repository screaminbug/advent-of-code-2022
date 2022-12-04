package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfBadgePrioritiesUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.SumOfPrioritiesUseCase

class DayThreeServiceAlt : SumOfPrioritiesUseCase, SumOfBadgePrioritiesUseCase {
    override fun getSum(input: String) = input.split(NL).map {
        findSameInRucksacks(it.chunked(it.length/2))
    }.sumOf { it[0] }

    override fun getSumOfBadges(input: String) = input.split(NL).chunked(3).map {
        findSameInRucksacks(it)
    }.sumOf { it[0] }

    private fun findSameInRucksacks(rucksacks: List<String>) = rucksacks.map {
        it.toCharArray()
    }.reduce { acc, chars ->
         if (acc.isEmpty()) chars else acc.filter { it in chars }.toCharArray()
    }.toList().map(this::itemCodeToPriority)

    private fun itemCodeToPriority(symbol: Char): Int {
        val value = symbol.code
        val converted = value and 0x1F
        return if (value and 0x20 == 0x20) converted else converted + 26
    }
}