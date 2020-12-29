package com.github.blokaly
import io.micronaut.core.annotation.Introspected

@Introspected
data class OutputMessage(val message: String, val pirateMessage: String)