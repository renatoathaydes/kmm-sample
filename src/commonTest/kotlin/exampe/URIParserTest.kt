package exampe

import example.URIParser
import kotlin.test.Test
import kotlin.test.assertEquals

class URIParserTest {

    @Test
    fun canParseURI() {
        val uri = URIParser.parse("https://example.com:8080/p1/p2?q1&q2#f1")
        assertEquals("https", uri.protocol)
        assertEquals("example.com", uri.host)
        assertEquals(8080, uri.port)
        assertEquals("/p1/p2", uri.path)
        assertEquals("q1&q2", uri.queryString)
        assertEquals("f1", uri.fragmentString)
    }
}