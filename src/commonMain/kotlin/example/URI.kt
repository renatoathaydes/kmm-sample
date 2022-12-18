package example

data class URI(
    val protocol: String,
    val host: String,
    val port: Int,
    val path: String,
    val queryString: String,
    val fragmentString: String,
)

expect object URIParser {
    fun parse(string: String): URI
}
