import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day02KtTest {

    @Test
    fun `Test score with draws 1`() {
        val scores = scores1("Day02_draw_1.txt")
        assertEquals(4, scores[0])
        assertEquals(5, scores[1])
        assertEquals(6, scores[2])
        assertEquals(15, scores.sum())
    }

    @Test
    fun `Test score with wins 1`() {
        val scores = scores1("Day02_wins_1.txt")
        assertEquals(7, scores[0])
        assertEquals(8, scores[1])
        assertEquals(9, scores[2])
        assertEquals(24, scores.sum())
    }

    @Test
    fun `Test score with lost 1`() {
        val scores = scores1("Day02_lost_1.txt")
        assertEquals(3, scores[0])
        assertEquals(1, scores[1])
        assertEquals(2, scores[2])
        assertEquals(6, scores.sum())
    }

    @Test
    fun `Test score with draws 2`() {
        val scores = scores2("Day02_draw_2.txt")
        assertEquals(4, scores[0])
        assertEquals(5, scores[1])
        assertEquals(6, scores[2])
        assertEquals(15, scores.sum())
    }

    @Test
    fun `Test score with wins 2`() {
        val scores = scores2("Day02_wins_2.txt")
        assertEquals(7, scores[0])
        assertEquals(8, scores[1])
        assertEquals(9, scores[2])
        assertEquals(24, scores.sum())
    }

    @Test
    fun `Test score with lost 2`() {
        val scores = scores2("Day02_lost_2.txt")
        assertEquals(3, scores[0])
        assertEquals(1, scores[1])
        assertEquals(2, scores[2])
        assertEquals(6, scores.sum())
    }

}