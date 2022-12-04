package hr.tstrelar.advent_of_code_2022.application.service

import hr.tstrelar.NL
import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUpdatedUseCase
import hr.tstrelar.advent_of_code_2022.application.port.`in`.CalculateRpsScoreUseCase
import hr.tstrelar.advent_of_code_2022.application.service.Outcome.*

enum class Shape(val score: Int) {
    ROCK( 1),
    PAPER( 2),
    SCISSORS( 3);
    fun wins(): Shape {
        return when(this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }
    }
    fun loses(): Shape {
        return when(this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
    }
    companion object {
        fun fromCode(value: String): Shape {
            return when(value) {
                "A" -> ROCK
                "X" -> ROCK
                "B" -> PAPER
                "Y" -> PAPER
                "C" -> SCISSORS
                "Z" -> SCISSORS
                else -> throw IllegalArgumentException("$value is not a valid shape code")
            }
        }
    }
}

enum class Outcome(val score: Int) {
    LOSE(0),
    DRAW(3),
    WIN(6);
    companion object {
        fun fromCode(value: String): Outcome {
            return when(value) {
                "X" -> LOSE
                "Y" -> DRAW
                "Z" -> WIN
                else -> throw IllegalArgumentException("$value is not a valid strategy code")
            }
        }
    }
}

class Game(firstCode: String, secondCode: String) {
    private val opponentShape = Shape.fromCode(firstCode)
    private val myShape = Shape.fromCode(secondCode)
    private val outcome = Outcome.fromCode(secondCode)

    fun play() = myShape.score + if (isDraw()) { DRAW.score } else if (isWin()) { WIN.score } else { LOSE.score }
    fun playUpdated() = myShape().score + outcome.score

    private fun isDraw() = opponentShape == myShape

    private fun isWin() = myShape.wins() == opponentShape

    private fun myShape() = when (outcome) {
        LOSE -> opponentShape.wins()
        DRAW -> opponentShape
        WIN -> opponentShape.loses()
    }


}

class DayTwoService : CalculateRpsScoreUseCase, CalculateRpsScoreUpdatedUseCase {
    override fun calculateScore(input: String) = getGames(input).sumOf { it.play() }.toString()

    override fun calculateScoreUpdated(input: String) = getGames(input).sumOf { it.playUpdated() }.toString()

    private fun getGames(input: String) = input.split(NL).map {
        val gameInCode = it.split(" ")
        Game(gameInCode[0], gameInCode[1])
    }
}