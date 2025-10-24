package racingcar.model

import racingcar.validator.Validator

class UserParser(inputName: String) {
    private val userNames: List<String>

    init {
        val names = inputName.split(DELIMITER).map { it.trim() }
        Validator.validateNameLengths(names)

        userNames = names
    }

    fun getUserList(): List<User> {
        val nameCounts = userNames.groupingBy { it }.eachCount()
        val checked: MutableMap<String, Int> = mutableMapOf()

        return userNames.map { name ->
            val total = nameCounts[name] ?: 0
            val count = checked.getOrPut(name) { 0 } + 1
            checked[name] = count

            User(name, getTag(total, count))
        }
    }

    private fun getTag(total: Int, count: Int): Char? {
        return if (total > 1) (TAG_START_CHAR + count - 1) else null
    }

    companion object {
        private const val DELIMITER = ','
        private const val TAG_START_CHAR = 'A'
    }
}