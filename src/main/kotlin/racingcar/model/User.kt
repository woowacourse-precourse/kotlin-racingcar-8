package racingcar.model

data class User(
    val name: String,
    var tag: Char? = null,
    var score: Int = 0
)