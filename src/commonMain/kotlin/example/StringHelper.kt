package example

object StringHelper {
    fun String.capitalize(): String {
        if (isEmpty()) return this
        val first = this[0].uppercase()
        return first + substring(1)
    }
}
