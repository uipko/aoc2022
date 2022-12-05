
fun main() {
    val pairsContains = contains("Day04.txt")
    println("The total sum of pairs of elf to reconsider is: $pairsContains")

    val pairsOverlap = overlap("Day04.txt")
    println("The total sum of pairs of elf to reconsider is: $pairsOverlap")
}


fun contains(fileName: String): Int {
    val test = readInput(fileName).count { pairs ->
        val elfRange = pairs.split(",").map {
                range -> range.split("-").map { it.toInt() } }
        val elf1 = elfRange.first()
        val elf2 = elfRange.last()
        (elf1.first() >= elf2.first() && elf1.last() <= elf2.last())
                || (elf2.first() >= elf1.first() && elf2.last() <= elf1.last())
    }
    return test
}

fun overlap(fileName: String): Int {
    return readInput(fileName).count { pairs ->
        pairs.split(",").map {
            range -> range.split("-").map { it.toInt() }.toSet()
        }.reduce { acc, next -> acc.intersect(next) }.isNotEmpty()
    }
}

fun overlap1(fileName: String): Int {
    val test = readInput(fileName).count { pairs ->
        val elfRange = pairs.split(",").map {
                range -> range.split("-").map { it.toInt() } }
        val elf1 = elfRange.first()
        val elf2 = elfRange.last()
        ((elf1.first() in elf2.first() .. elf2.last())
                || (elf1.last() in elf2.first() .. elf2.last())
        ) || ((elf2.first() in elf1.first() .. elf1.last())
                || (elf2.last() in elf1.first() .. elf1.last()))
    }
    return test
}
