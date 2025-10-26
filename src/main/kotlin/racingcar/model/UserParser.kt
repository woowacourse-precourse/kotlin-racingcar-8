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

    private fun getTag(total: Int, count: Int): String? {
        if (total <= 1) return null

        var idx = count - 1
        var tag = ""
        while (true) {
            tag += TAG_START_CHAR + (idx % TAG_BASE)
            idx = idx / TAG_BASE - 1

            if (idx < 0) break
        }
        return tag.reversed()
    }

    companion object {
        private const val DELIMITER = ','
        private const val TAG_START_CHAR = 'A'
        private const val TAG_BASE = 26 //알파벳 개수
    }
}