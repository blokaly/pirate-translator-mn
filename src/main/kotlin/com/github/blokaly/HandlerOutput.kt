package com.github.blokaly
import io.micronaut.core.annotation.Introspected

@Introspected
data class HandlerOutput(val message: String, val pirateMessage: String)