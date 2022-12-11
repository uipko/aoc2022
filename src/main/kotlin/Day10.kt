
fun main() {
    val signal = signalStrength("Day10.txt")
    println("Signal strength: $signal")

   renderText("Day10.txt").map { line -> line.map { pixel -> print(pixel) }; print("\n")}
}

fun signalStrength(fileName: String): Int {
    var cycles = 0
    var registerX = 1
    val addOpcode = "addx"
    val strength = readInput(fileName).fold(0) { acc, line ->
        var currVal = 0
        val currOpcode = line.substringBefore(" ")
        when (currOpcode) {
            addOpcode -> {
                cycles += 2
                currVal = line.split(" ").last().toInt()
                registerX += currVal
            }

            else -> cycles++
        }
        when(cycles) {
            in listOf(20, 60, 100, 140, 180, 220) -> {
                acc + cycles * (registerX-currVal)
            }
            in listOf(21, 61, 101, 141, 181, 221) -> {
                if (currOpcode == addOpcode) {
                    acc + (cycles-1) * (registerX - currVal)
                }
                else
                    acc
            }
            else -> acc
        }
    }
    return strength
}

fun renderText(fileName: String): List<List<Char>> {
    var cycles = 0
    var registerX = 1
    val addOpcode = "addx"

    return readInput(fileName).fold(mutableListOf<MutableList<Char>>(mutableListOf())) {
            acc, line ->

        fun addToScreen(cycle: Int){
            var pixel = if ((cycle-1)%40 in registerX-1..registerX+1) '#' else '.'
            when {
                cycle > 40 && cycle%40 == 1 -> acc.add((mutableListOf(pixel)))
                else -> acc.last().add(pixel)
            }
        }

        var currVal = 0
        val currOpcode = line.substringBefore(" ")

        cycles++
        addToScreen(cycles)
        if (currOpcode == addOpcode) {
            cycles++
            addToScreen(cycles)
            currVal = line.split(" ").last().toInt()
            registerX += currVal
        }
        acc
    }
}
