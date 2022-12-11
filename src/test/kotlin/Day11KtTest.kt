import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigInteger

class Day11KtTest {

    @Test
    fun `Test monkey business round 1`() {
        val monkeys = monkeyBusiness("Day11.txt", 1, 3L)
        assertEquals(listOf<Long>(20, 23, 27, 26), monkeys[0].items)
        assertEquals(listOf<Long>(2080, 25, 167, 207, 401, 1046), monkeys[1].items)
        assertEquals(listOf<Long>(), monkeys[2].items)
        assertEquals(listOf<Long>(), monkeys[3].items)
    }

    @Test
    fun `Test monkey business round 2`() {
        val monkeys = monkeyBusiness("Day11.txt", 2, 3L)
        assertEquals(listOf<Long>(695, 10, 71, 135, 350), monkeys[0].items)
        assertEquals(listOf<Long>(43, 49, 58, 55, 362), monkeys[1].items)
        assertEquals(listOf<Long>(), monkeys[2].items)
        assertEquals(listOf<Long>(), monkeys[3].items)
    }

    @Test
    fun `Test monkey business round 3`() {
        val monkeys = monkeyBusiness("Day11.txt", 3, 3L)
        assertEquals(listOf<Long>(16, 18, 21, 20, 122), monkeys[0].items)
        assertEquals(listOf<Long>(1468, 22, 150, 286, 739), monkeys[1].items)
        assertEquals(listOf<Long>(), monkeys[2].items)
        assertEquals(listOf<Long>(), monkeys[3].items)
    }

    @Test
    fun `Test monkey business round 20`() {
        val monkeys = monkeyBusiness("Day11.txt", 20, 3L)
        assertEquals(listOf<Long>(10, 12, 14, 26, 34), monkeys[0].items)
        assertEquals(listOf<Long>(245, 93, 53, 199, 115), monkeys[1].items)
        assertEquals(listOf<Long>(), monkeys[2].items)
        assertEquals(listOf<Long>(), monkeys[3].items)
    }

    @Test
    fun `Test monkey business round outcome`() {
        val monkeys = monkeyBusiness("Day11.txt", 20, 3L)
        val total = totalMonkeyBusiness(monkeys)
        assertEquals(10605, total)
    }

    @Test
    fun `Test monkey business round outcome part 2 1 round`() {
        val monkeys = monkeyBusiness("Day11.txt", 1, 1L)
        val total = totalMonkeyBusiness(monkeys)
        assertEquals(6*4, total)
    }

    @Test
    fun `Test monkey business round outcome part 2 20 round`() {
        val monkeys = monkeyBusiness("Day11.txt", 20, 1L)
        val total = totalMonkeyBusiness(monkeys)
        assertEquals(103*99, total)
    }

    @Test
    fun `Test monkey business round outcome part 2 1_000 round`() {
        val monkeys = monkeyBusiness("Day11.txt", 1_000, 1L)
        val total = totalMonkeyBusiness(monkeys)
        assertEquals(5204*5192, total)
    }

    @Test
    fun `Test monkey business round outcome part 2 5_000 rounds`() {
        val monkeys = monkeyBusiness("Day11.txt", 5_000, 1L)
        val total = totalMonkeyBusiness(monkeys)
        assertEquals(26075*26000, total)
    }


    @Test
    fun `Test monkey business round outcome part 2`() {
        val monkeys = monkeyBusiness("Day11.txt", 10_000, 1L)
        val total = totalMonkeyBusiness(monkeys)
        assertEquals(2713310158, total)
    }

}
