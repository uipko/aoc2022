import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03KtTest {

    @Test
    fun `Test sum of duplicate items`() {
        val priorities = doubleItems("Day03_1.txt")
        assertEquals(16, priorities[0])
        assertEquals(38, priorities[1])
        assertEquals(42, priorities[2])
        assertEquals(22, priorities[3])
        assertEquals(20, priorities[4])
        assertEquals(19, priorities[5])
        assertEquals(157, priorities.sum())
    }

    @Test
    fun `Test sum of badges`() {
        val badges = badges("Day03_1.txt")
        assertEquals(18, badges[0])
        assertEquals(52, badges[1])
        assertEquals(70, badges.sum())
    }
}
