package example

import org.w3c.dom.url.URL

actual object URIParser {
    actual fun parse(string: String): URI {
        val jsUrl = URL(string)
        return URI(
            protocol = jsUrl.protocol,
            host = jsUrl.host,
            port = jsUrl.port.toInt(),
            path = jsUrl.pathname,
            queryString = jsUrl.search,
            fragmentString = ""
        )
    }
}