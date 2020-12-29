package com.github.blokaly
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class HandlerInputRequestHandlerTest {

    @Test
    fun testPirateTranslator() {

        val classUnderTest : PirateTranslator = DefaultPirateTranslator()

        Assertions.assertEquals(
            "Ahoy!, I am Captain Jack Sparrow",
            classUnderTest.translate("Hello, I am Captain Jack Sparrow")
        )

        Assertions.assertEquals("Aye!", classUnderTest.translate("Yes"))
    }

    @Test
    fun testHandler() {
        val requestHandler = AppRequestHandler()
        val input = HandlerInput()
        input.message = "Yes"
        val output = requestHandler.execute(input)
        Assertions.assertNotNull(output)
        Assertions.assertEquals(input.message, output!!.message)
        Assertions.assertEquals("Aye!", output.pirateMessage)
        requestHandler.applicationContext.close()
    }
}