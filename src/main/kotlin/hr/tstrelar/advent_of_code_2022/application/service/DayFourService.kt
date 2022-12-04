package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.FullyOverlappingAssignmentsUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.OverlappingAssignmentsUseCase

class DayFourService : FullyOverlappingAssignmentsUseCase, OverlappingAssignmentsUseCase {
    override fun howManyFullyOverlap(input: String) = input.split(NL).map {
        val a = extractAssignments(it)
        if ((a.elf1Start <= a.elf2Start && a.elf1End >= a.elf2End) || (a.elf1Start >= a.elf2Start && a.elf1End <= a.elf2End))
            1 else 0
    }.sum().toString()
    override fun howManyOverlap(input: String) = input.split(NL).map {
        val a = extractAssignments(it)
        val elf1 = (a.elf1Start .. a.elf1End)
        val elf2 = (a.elf2Start .. a.elf2End)
        if (elf1.intersect(elf2).isNotEmpty()) 1 else 0
    }.sum().toString()
    private fun extractAssignments(input: String): Assignments {
        val assignments = input.split(",")
        val firstAssignmentSections = assignments[0].split("-")
        val secondAssignmentSections = assignments[1].split("-")
        return Assignments(
            elf1Start = firstAssignmentSections[0].toInt(),
            elf1End = firstAssignmentSections[1].toInt(),
            elf2Start = secondAssignmentSections[0].toInt(),
            elf2End = secondAssignmentSections[1].toInt()
        )
    }
    data class Assignments(
        val elf1Start: Int,
        val elf1End: Int,
        val elf2Start: Int,
        val elf2End: Int
    )
}