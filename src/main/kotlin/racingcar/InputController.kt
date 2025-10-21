package racingcar

class InputController {
    // 오류 검사
    val parser = Parser()

    // 문자열 이름 목록을 분리하기 위한 함수
    fun nameSplit(names: String): List<String> {
        val nameList = names.replace(" ", "").split(",")
        parser.nameParser(nameList)
        return nameList
    }

    // 이름을 가지고 Car리스트를 만드는 함수
    fun createCarList(names: String): List<Car> {
        val carlist = mutableListOf<Car>()
        val nameList = nameSplit(names)
        for (name in nameList) {
            carlist.add(Car(name))
        }
        return carlist
    }

    // 입력 받는 움직임 횟수를 정수로 반환해주는 함수
    fun countToInt(count: String): Int {
        parser.countParser(count)
        return count.toInt()
    }
}