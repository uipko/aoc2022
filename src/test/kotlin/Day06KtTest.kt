import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06KtTest {

    /*
    ---- Testdata ----
    bvwbjplbgvbhsrlpgdmjqwftvncz: first marker after character 5
    nppdvjthqldpwncqszvftbrmjlhg: first marker after character 6
    nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg: first marker after character 10
    zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw: first marker after character 11
     */
    @Test
    fun `Test stream 1`() {
        val nrOfChars = parseStream("Day06_1.txt", 4)
        assertEquals(5, nrOfChars)
    }

    @Test
    fun `Test stream 2`() {
        val nrOfChars = parseStream("Day06_2.txt",4 )
        assertEquals(6, nrOfChars)
    }

    @Test
    fun `Test stream 3`() {
        val nrOfChars = parseStream("Day06_3.txt",4)
        assertEquals(10, nrOfChars)
    }

    @Test
    fun `Test stream 4`() {
        val nrOfChars = parseStream("Day06_4.txt", 4)
        assertEquals(11, nrOfChars)
    }


    @Test
    fun `Test stream 4 (14)`() {
        val nrOfChars = parseStream("Day06_4.txt", 14)
        assertEquals(26, nrOfChars)
    }
}
