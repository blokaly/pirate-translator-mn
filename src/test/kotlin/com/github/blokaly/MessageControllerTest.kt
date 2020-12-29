package com.github.blokaly;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext
import com.amazonaws.services.lambda.runtime.Context
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpMethod
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import io.micronaut.function.aws.proxy.MicronautLambdaHandler

class MessageControllerTest {

    @Test
    fun testMessageController() {
        val handler = MicronautLambdaHandler()
        val input = InputMessage()
        input.message = "Hello"
        val objectMapper = handler.applicationContext.getBean(ObjectMapper::class.java)
        val json = objectMapper.writeValueAsString(input)
        val request = AwsProxyRequestBuilder("/", HttpMethod.POST.toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .body(json)
                .build()
        val lambdaContext: Context = MockLambdaContext()
        val response = handler.handleRequest(request, lambdaContext)
        Assertions.assertEquals(response.statusCode, HttpStatus.OK.code)
        val outputMessage: OutputMessage = objectMapper.readValue(response.body, OutputMessage::class.java)
        Assertions.assertNotNull(outputMessage)
        Assertions.assertEquals(input.message, outputMessage.message)
        Assertions.assertEquals("Ahoy!", outputMessage.pirateMessage)
        handler.applicationContext.close()
    }
}
