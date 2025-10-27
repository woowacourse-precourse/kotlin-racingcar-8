package racingcar

class Separator {
    fun separateName(names: String): List<String> = names.split(NAME_SEPARATOR)

    companion object {
        const val NAME_SEPARATOR = ","
    }
}