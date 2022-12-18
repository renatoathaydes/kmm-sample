package example

import java.net.URISyntaxException

actual object URIParser {
    actual fun parse(string: String): URI {
        val javaUri = try {
            java.net.URI(string)
        } catch (e: URISyntaxException) {
            throw IllegalArgumentException("invalid URI")
        }
        return URI(
            protocol = javaUri.scheme ?: "http",
            host = javaUri.host ?: "",
            port = javaUri.port,
            path = javaUri.path ?: "/",
            queryString = javaUri.query ?: "",
            fragmentString = javaUri.fragment ?: ""
        )
    }
}