package racingcar

class Parser {
    // 이름에서 예외처리를 담당하는 함수
    fun nameParser(nameList: List<String>) {
        val namePattern = Regex("^[a-zA-Z]{1,5}$") // 영문 대소문자이며 1~5글자를 가지는 정규식
        nameList.forEach {
            require (namePattern.containsMatchIn(it)) { "이름이 제안된 형식에 맞지 않습니다." }
        }
    }

    // 움직임 값에서 예외처리를 담당하는 함수
    fun countParser(count: String) {
        val countPattern = Regex("^[1-9]+$") // 1~9를 1회 이상 가지는 정규식
        require(countPattern.containsMatchIn(count)) { "0을 입력하거나, 숫자가 아닌 다른 문자를 입력했습니다." }
    }
}