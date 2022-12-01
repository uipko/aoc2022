import kotlin.math.max

fun main() {
    part1("Day01")
    part2("Day01")
}

fun part1(fileName: String) {
    val maxCalories = inventories(fileName).maxOf { it }
    println("The maximum number of Calories in an Elf's inventory is $maxCalories")
}

fun part2(fileName: String) {
    val topThreeInventories = inventories(fileName).sortedDescending().take(3).sum()
    println("The total Calories of the top three inventories is $topThreeInventories")
}

fun inventories(fileName: String ): List<Int> {
    val inventories = mutableListOf<Int>()
    var sumOfCalories = 0
    for (line in readInput(fileName)) {
        if (line.isEmpty()) {
            inventories.add(sumOfCalories)
            sumOfCalories = 0
        } else {
            sumOfCalories += line.toInt()
        }
    }
    return inventories
}