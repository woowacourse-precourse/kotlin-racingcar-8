package racingcar.model

import racingcar.constant.DELIMITER
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
            val count = checked.getOrDefault(name, 0) + 1
            checked[name] = count

            val tag = if (total > 1) ('A' + count - 1) else null
            User(name, tag)
        }

    }
}