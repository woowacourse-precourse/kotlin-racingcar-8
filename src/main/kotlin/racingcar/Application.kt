package racingcar

data class Car(val name: String, val position: Int) {
    init {
        require(name.isNotEmpty()) { "자동차 이름은 한 글자 이상을 포함해야 합니다." }
        require(name.length <= 5) { "자동차 이름은 5글자 이하여야 합니다." }
    }

    init {
        require(position >= 0) { "자동차의 위치($position)는 0미만일 수 없습니다." }
    }

    fun moveForward(): Car {
        return Car(name, position + 1)
    }

    constructor(name: String) : this(name, 0)
}

fun createUniqueCars(names: List<String>): List<Car> {
    val usedNames = mutableSetOf<String>()
    return names.map { name ->
        require(!usedNames.contains(name)) { "중복된 자동차 이름($name)은 허용되지 않습니다." }
        usedNames.add(name)
        Car(name)
    }
}

fun main() {
    // TODO: 프로그램 구현
}
