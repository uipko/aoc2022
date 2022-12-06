import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05KtTest {

    @Test
    fun `Test crateMover9000 top crates, small`() {
        val crates = crateMover("Day05.txt", MoverType.TYPE_9000)
        assertEquals("CMZ", crates)
    }

    @Test
    fun `Test crateMover9000  top crates, all`() {
        val crates = crateMover("Day05_all.txt", MoverType.TYPE_9000)
        assertEquals("CFFHVVHNC", crates)
    }

    @Test
    fun `Test crateMover9001 top crates, small`() {
        val crates = crateMover("Day05.txt", MoverType.TYPE_9001)
        assertEquals("MCD", crates)
    }

    @Test
    fun `Test crateMover9001 top crates, all`() {
        val crates = crateMover("Day05_all.txt", MoverType.TYPE_9001)
        assertEquals("FSZWBPTBG", crates)
    }
}
