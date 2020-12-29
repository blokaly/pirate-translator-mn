package com.github.blokaly

interface PirateTranslator {
    fun translate(message: String): String
}

class DefaultPirateTranslator : PirateTranslator {

    private val replacements = mapOf("Hello" to "Ahoy!", "Yes" to "Aye!", "Yes, Captain!" to "Aye Aye!")

    override fun translate(message: String) = replacements.entries.fold(message) { acc, (key, value) -> acc.replace(key, value) }

}