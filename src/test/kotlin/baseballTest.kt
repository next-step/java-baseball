import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class BaseballTest {
    @Test
    fun shouldGeneratedValueIsNotNull() {
        // given

        // when
        val generatedValue = generateRand3digit().toIntOrNull()

        // then
        assertNotEquals(null, generatedValue)
    }

    @Test
    fun shouldGeneratedValueIs3digit() {
        // given

        // when
        val generatedValue = generateRand3digit()

        // then
        assertEquals(3, generatedValue.length)
    }
}