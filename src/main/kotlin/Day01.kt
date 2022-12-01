fun main() {

    val topInventory = part1("Day01.txt")
    println("The maximum number of Calories in an Elf's inventory is $topInventory")

    val topThreeInventories = part2("Day01.txt")
    println("The total Calories of the top three inventories is $topThreeInventories")
}

fun part1(fileName: String): Int {
    return inventories(fileName).maxOf { it }
}

fun part2(fileName: String): Int {
    return inventories(fileName).sortedDescending().take(3).sum()
}

fun inventories(fileName: String): List<Int> {
    val inventories = mutableListOf<Int>()
    var nextInventory = true

    for (line in readInput(fileName)) {
        if (line.isNotEmpty()) {
            if (nextInventory) {
                inventories.add(0)
                nextInventory = false
            }
            inventories[inventories.lastIndex] = inventories.last() + line.toInt()
        } else {
            nextInventory = true
        }
    }

   return inventories
}