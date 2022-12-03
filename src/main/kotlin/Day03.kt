val characters = ('a'..'z') + ('A'..'Z')

fun main() {
    val items = doubleItems("Day03.txt").sum()
    println("The total sum of double items is: $items")

    val badges = badges("Day03.txt").sum()
    println("The total sum of double items is: $badges")
}

fun doubleItems(fileName: String): List<Int> {
    return readInput(fileName).map { rucksack ->
        val parts = rucksack.chunked(rucksack.length / 2)
        parts.first().toCharArray().distinct().filter { parts.last().contains(it) }.sumOf { characters.indexOf(it) + 1 }
    }
}

fun badges(fileName: String): List<Int> {
    return readInput(fileName).chunked(3).map { group ->
        group.first().toCharArray().distinct().filter {
            group[1].contains(it) && group[2].contains(it) }.sumOf { characters.indexOf(it) + 1 }
    }
}
