package hexa

import hexa.Hexadecimal.parseHexadecimal
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFails
import kotlin.test.assertIs

class HexadecimalTest {
    @Test
    fun string_hexadecimal_can_be_converted_to_byte_array() {
        assertContentEquals(byteArrayOf(), "".parseHexadecimal())
        assertContentEquals(byteArrayOf(0), "0".parseHexadecimal())
        assertContentEquals(byteArrayOf(0), "01".parseHexadecimal())
        assertContentEquals(byteArrayOf(1), "01".parseHexadecimal())
        assertContentEquals(byteArrayOf(0x10), "10".parseHexadecimal())
        assertContentEquals(byteArrayOf(0xff.toByte()), "ff".parseHexadecimal())
        assertContentEquals(byteArrayOf(1.toByte(), 0xcd.toByte()), "1cd".parseHexadecimal())
        assertContentEquals(byteArrayOf(0x10.toByte(), 0xab.toByte()), "10ab".parseHexadecimal())
        assertContentEquals(byteArrayOf(0xff.toByte(), 0xff.toByte()), "ffff".parseHexadecimal())
        assertContentEquals(
            listOf(0x12, 0x34, 0x56, 0x78, 0x90, 0xab, 0xcd, 0xef)
                .map { it.toByte() }.toByteArray(), "1234567890abcdef".parseHexadecimal()
        )
    }

    @Test
    fun invalid_string_not_accepted() {
        var failure = assertFails { "g".parseHexadecimal() }
        assertIs<IllegalArgumentException>(failure)

        failure = assertFails { "123z".parseHexadecimal() }
        assertIs<IllegalArgumentException>(failure)
    }
}