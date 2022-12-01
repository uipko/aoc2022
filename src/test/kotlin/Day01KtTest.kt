import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01KtTest {

    @Test
    fun `Test part1 with simple input file`() {
        assertEquals(31, part1("Day01_smiple.txt"))
    }

    @Test
    fun `Test part2 with simple input file`() {
        assertEquals(52, part2("Day01_smiple.txt"))
    }

    @Test
    fun `Test part1 with actual challenge file`() {
        assertEquals(66487, part1("Day01.txt"))
    }

    @Test
    fun `Test part2 with actual challenge file`() {
        assertEquals(197301, part2("Day01.txt"))
    }
}