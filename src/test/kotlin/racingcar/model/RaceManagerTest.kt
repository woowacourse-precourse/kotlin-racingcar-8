package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RaceManagerTest {

    @Test
    fun `레이스 횟수 설정하기`() {
        val raceManager = RaceManager()
        raceManager.setRaceCount(3)
        assertEquals(3, raceManager.getRaceCount())
    }


    @Test
    fun `리스트로 Car 생성하기`() {
        val carNames = mutableListOf<String>("A", "B", "C")
        val cars = mutableListOf<Car>(Car("A"), Car("B"), Car("C"))
        assertEquals(cars, RaceManager().createCar(carNames))
    }

    @Test
    fun `레이싱 진행 후 차 위치 확인`() {
        val raceManager = RaceManager()
        raceManager.createCar(listOf("A", "B", "C"))
        raceManager.startRound()

        val carList = raceManager.getCars()

        carList.forEach {
            assertTrue(it.position >= 0)
            println("${it.name}의 위치 : ${it.position}")
        }
    }

    @Test
    fun `중복 이름이 1개 있을 경우`() {
        val raceManager = RaceManager()
        val carNames = listOf("Joy", "Joy", "Alice")
        val answer = listOf("JoyA", "JoyB", "Alice")
        val map = mutableMapOf<String, Set<Int>>()
        map["Joy"] = mutableSetOf(0, 1)
        assertEquals(answer, raceManager.addSuffixToDuplicateNames(carNames, map))
    }

    @Test
    fun `중복 이름이 2개 있고 순서가 섞여 있는 경우`() {
        val raceManager = RaceManager()
        val carNames = listOf("Joy","Alice" ,"Alice", "Joy", "Bob")
        val answer = listOf("JoyA","AliceA" ,"AliceB", "JoyB", "Bob")
        val map = mutableMapOf<String, Set<Int>>()
        map["Joy"] = mutableSetOf(0, 3)
        map["Alice"] = mutableSetOf(1, 2)
        assertEquals(answer, raceManager.addSuffixToDuplicateNames(carNames, map))
    }
}