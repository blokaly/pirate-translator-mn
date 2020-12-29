package com.github.blokaly
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller
open class MessageController {
    private val translator : PirateTranslator =   DefaultPirateTranslator()

    @Post
    open fun convert(@Valid @Body inputMessage: InputMessage) =  OutputMessage(inputMessage.message, translator.translate(inputMessage.message))
}