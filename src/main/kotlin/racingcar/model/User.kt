package racingcar.model

data class User(
    val name: String,
    var tag: Char? = null,
    var score: Int = 0
) {
    fun move() {
        score++
    }

    fun displayName(): String {
        return if (tag == null) name else "$name #$tag"
    }
}