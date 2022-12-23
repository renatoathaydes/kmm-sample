package hexa

import hexa.Hexadecimal.parseHexadecimal
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Parse a hexadecimal string.
 */
@OptIn(ExperimentalJsExport::class)
@JsExport
fun parseHexadecimal(input: String): ByteArray {
    return input.parseHexadecimal()
}

@OptIn(ExperimentalJsExport::class)
@JsExport
object Hexadecimal {

    fun String.parseHexadecimal(): ByteArray {
        if (isEmpty()) return byteArrayOf()
        val even = length % 2 == 0
        val result = ByteArray(length / 2 + (if (even) 0 else 1))
        val startIndex = if (even) 0 else {
            result[0] = this[0].digit().toByte()
            1
        }
        for (charIndex in startIndex until length step 2) {
            val low = this[charIndex + 1].digit()
            val high = this[charIndex].digit() shl 4
            result[(charIndex + 1) / 2] = ((high + low) and 0xff).toByte()
        }
        return result
    }

    private fun Char.digit(): Int {
        return when (this.lowercaseChar()) {
            '0' -> 0
            '1' -> 1
            '2' -> 2
            '3' -> 3
            '4' -> 4
            '5' -> 5
            '6' -> 6
            '7' -> 7
            '8' -> 8
            '9' -> 9
            'a' -> 10
            'b' -> 11
            'c' -> 12
            'd' -> 13
            'e' -> 14
            'f' -> 15
            else -> throw IllegalArgumentException("Not a hexadecimal digit: '$this'")
        }
    }
}
