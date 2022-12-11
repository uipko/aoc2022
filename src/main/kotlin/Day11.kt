data class Monkey(val items: MutableList<Long> = mutableListOf(),
                  var operator: String, var first: String, var second: String,
                  var test: Long, var t: Int, var f: Int,
                  var inspected: Long = 0L)


fun main() {
    val monkeys = monkeyBusiness("Day11.txt", 20, 3)
    println("Total monkey business part 1: ${totalMonkeyBusiness(monkeys)}")

    val monkeys2 = monkeyBusiness("Day11.txt", 10_000, 1L)
    println("Total monkey business part 2: ${totalMonkeyBusiness(monkeys2)}")
}

fun totalMonkeyBusiness(monkeys: List<Monkey>): Long {
    return monkeys.sortedBy { it.inspected }.takeLast(2).fold(1L) { acc, elem -> acc * elem.inspected }
}

fun monkeyBusiness(fileName: String, rounds: Int, divider: Long): List<Monkey> {
    val monkeys = readFile(fileName).split("\n\n").map() {
            text ->
        val lines = text.lines()
        val items = lines[1].split("items: ").last().split(", ").map { it.toLong() }.toMutableList()
        val (first, operator, second) = lines[2].split(" ").takeLast(3)
        val test = lines[3].split(" ").last().toLong()
        val t = lines[4].split(" ").last().toInt()
        val f = lines[5].split(" ").last().toInt()

        Monkey(items, operator, first, second, test, t, f)
    }
    val superModulo = monkeys.fold(1L) { acc, elem -> acc * elem.test}
    //rounds
    (1..rounds).forEach() { _ ->
        monkeys.forEach { monkey ->
            monkey.items.forEach { item ->
                monkey.inspected++

                var worries = when (monkey.operator) {
                    "*" -> when (monkey.second) {
                        "old" -> item * item
                        else -> item * monkey.second.toLong()
                    }

                    else -> when (monkey.second) {
                        "old" -> item + item
                        else -> item + monkey.second.toLong()
                    }
                }
                worries /= divider
                worries %= superModulo

                val newMonkey = if (worries.mod(monkey.test) == 0L) monkey.t else monkey.f
                monkeys[newMonkey].items.add(worries)
            }
            monkey.items.clear()
        }
    }
    return monkeys
}
