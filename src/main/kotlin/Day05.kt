
enum class MoverType {
    TYPE_9000,
    TYPE_9001
}

fun main() {
    val crates = crateMover("Day05.txt", MoverType.TYPE_9000)
    println("CrateMover 9000 top crates are $crates")

    val crates2 = crateMover("Day05.txt", MoverType.TYPE_9001)
    println("CrateMover 9001 top crates are $crates2")

}

fun crateMover(fileName: String, type: MoverType): String {
    val (stack, moves) = readFile(fileName).split("\n\n").map { it.lines()}

    val stacks = (stack.dropLast(1).map {
        it.padEnd(stack.last().length+3/4*4, ' ' ) }.map {
            chunks -> chunks.chunked(4).map { it[1]} })
    val columns = (stacks.first().indices).map {
            columnIndex -> stacks.map { it[columnIndex] }.filter { !it.isWhitespace() }.toMutableList() }

    moves.forEach { move ->
        move.split(" ").drop(1).filter { it.toIntOrNull() != null }
            .map { it.toInt() }.let { (nr, from, to) ->
            val elementsToMove = columns[from - 1].subList(0,nr)
            columns[to - 1].addAll(0, elementsToMove.let {if (type == MoverType.TYPE_9000) it.reversed() else it})
            elementsToMove.clear()
        }
    }
    return columns.map { it.first() }.joinToString("")
}
