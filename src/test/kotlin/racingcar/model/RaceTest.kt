package racingcar.model

import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `자동차 생성 확인`() {
        val race = Race(listOf("pobi", "woni"), Number())

        assert(race.getCars().size == 2)
        assert(race.getCars()[0].name == "pobi")
        assert(race.getCars()[1].name == "woni")
    }

    @Test
    fun `게임 진행 후 위치 변화`() {
        val race = Race(listOf("pobi", "woni"), Number())

        race.play()

        val positions = race.getCars().map { it.getPosition() }
        assert(positions.sum() >= 0)
    }
}