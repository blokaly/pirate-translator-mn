package com.github.blokaly
import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler
import java.util.UUID

@Introspected
class AppRequestHandler : MicronautRequestHandler<HandlerInput?, HandlerOutput?>() {
    private val translator : PirateTranslator =   DefaultPirateTranslator()

    override fun execute(input: HandlerInput?): HandlerOutput? {
       return  input?.let { HandlerOutput(it.message, translator.translate(it.message)) }
    }
}