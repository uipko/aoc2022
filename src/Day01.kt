import kotlin.math.max

fun main() {
    part1("Day01")

}

fun part1(fileName: String) {
    var maxCalories = 0
    var sumOfCalories = 0
    for (line in readInput(fileName)) {
        if (line.isEmpty()) {
            maxCalories = max(maxCalories, sumOfCalories)
            sumOfCalories = 0
        } else {
            sumOfCalories += line.toInt()
        }
    }
    println("The maximum number of Calories in an Elf's inventory is $maxCalories")
}