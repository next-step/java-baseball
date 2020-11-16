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

    @Test
    fun shouldRuleEvalulatedNothing() {
        // given
        val userInput = "123"
        val generatedValue = "456"

        // when
        val evalulatedResult = evaluateRule(userInput, generatedValue)

        // then
        assertEquals(EvalulatedRule.NOTHING.value, evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated1ball() {
        // given
        val userInput = "123"
        val generatedValue = "356"

        // when
        val evalulatedResult = evaluateRule(userInput, generatedValue)

        // then
        assertEquals("1 ${EvalulatedRule.BALL.value}", evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated2strike() {
        // given
        val userInput = "123"
        val generatedValue = "126"

        // when
        val evalulatedResult = evaluateRule(userInput, generatedValue)

        // then
        assertEquals("2 ${EvalulatedRule.STRIKE.value}", evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated3strike() {
        // given
        val userInput = "123"
        val generatedValue = "123"

        // when
        val evalulatedResult = evaluateRule(userInput, generatedValue)

        // then
        assertEquals("3 ${EvalulatedRule.STRIKE.value}", evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated1strike1ball() {
        // given
        val userInput = "123"
        val generatedValue = "138"

        // when
        val evalulatedResult = evaluateRule(userInput, generatedValue)

        // then
        assertEquals("1 ${EvalulatedRule.STRIKE.value} 1 ${EvalulatedRule.BALL.value}", evalulatedResult)
    }
}