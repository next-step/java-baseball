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
        val transformedUserList = transformStringNumToIntArray(userInput)
        val transformedGeneratedList = transformStringNumToIntArray(generatedValue)

        // when
        val evalulatedResult = evaluateRule(transformedUserList, transformedGeneratedList)

        // then
        assertEquals(EvaluatedRule.NOTHING.value, evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated1ball() {
        // given
        val userInput = "123"
        val generatedValue = "356"
        val transformedUserList = transformStringNumToIntArray(userInput)
        val transformedGeneratedList = transformStringNumToIntArray(generatedValue)

        // when
        val evalulatedResult = evaluateRule(transformedUserList, transformedGeneratedList)

        // then
        assertEquals("1 ${EvaluatedRule.BALL.value}", evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated2strike() {
        // given
        val userInput = "123"
        val generatedValue = "126"
        val transformedUserList = transformStringNumToIntArray(userInput)
        val transformedGeneratedList = transformStringNumToIntArray(generatedValue)

        // when
        val evalulatedResult = evaluateRule(transformedUserList, transformedGeneratedList)

        // then
        assertEquals("2 ${EvaluatedRule.STRIKE.value}", evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated3strike() {
        // given
        val userInput = "123"
        val generatedValue = "123"
        val transformedUserList = transformStringNumToIntArray(userInput)
        val transformedGeneratedList = transformStringNumToIntArray(generatedValue)

        // when
        val evalulatedResult = evaluateRule(transformedUserList, transformedGeneratedList)

        // then
        assertEquals("3 ${EvaluatedRule.STRIKE.value}", evalulatedResult)
    }

    @Test
    fun shouldRuleEvalulated1strike1ball() {
        // given
        val userInput = "123"
        val generatedValue = "138"
        val transformedUserList = transformStringNumToIntArray(userInput)
        val transformedGeneratedList = transformStringNumToIntArray(generatedValue)

        // when
        val evalulatedResult = evaluateRule(transformedUserList, transformedGeneratedList)

        // then
        assertEquals("1 ${EvaluatedRule.STRIKE.value} 1 ${EvaluatedRule.BALL.value}", evalulatedResult)
    }
}