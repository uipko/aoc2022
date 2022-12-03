
fun main() {
    val score = scores1("Day02.txt").sum()
    println("Your total score [1] is $score")

    val score2 = scores2("Day02.txt").sum()
    println("Your total score [2] is $score2")
}

fun scores1(fileName: String): List<Int> {
    val rounds = mutableListOf<Int>()

    readInput(fileName).forEach {
        val they = it.first().code - offset_A
        val you = it.last().code - offset_X
        rounds.add(
            if ((!(they == 1 && you == 3) && (they < you)) || (they == 3 && you == 1) ) {
                you + 6
            } else if (they == you) {
                you + 3
            }  else {
                you
            }
        )
    }

    return rounds
}

fun scores2(fileName: String): List<Int> {
    val rounds = mutableListOf<Int>()

    readInput(fileName).forEach {
        val they = it.first().code - offset_A
        val score = when (it.last().code - offset_X) {
            1 -> 0 + if (they > 1) they - 1 else 3
            2 -> 3 + they
            else -> 6 + if (they < 3) they + 1 else 1
        }
        rounds.add(score)
    }

    return rounds
}
