package racingcar.model

data class User(
    val name: String,
    var tag: String? = null,
    private var score: Int = 0
) {
    fun move() {
        score++
    }

    fun getScore(): Int = score

    fun displayName(): String {
        return if (tag == null) name else "$name #$tag"
    }
}