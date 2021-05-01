package racingcar.state;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.Car;
import racingcar.Game;
import racingcar.Lap;
import racingcar.Rounds;

public class RaceStateTest {

	Game game;
	RaceState raceState;

	Car apple = new Car("apple");
	Car baby = new Car("baby");
	Car candy = new Car("candy");

	@BeforeEach
	void setup() {
		game = new Game();
		List<Car> cars = Arrays.asList(apple, baby, candy);
		game.getData().saveCars(cars);
		game.getData().saveRounds(new Rounds(3));
		raceState = new RaceState(game);
	}

	@DisplayName("자동차 정렬")
	@Test
	void standby() {
		Lap lap = raceState.standby();
		for (Car car : lap.getRecord().keySet()) {
			assertThat(lap.getRecord().get(car).getValue()).isEqualTo(0);
		}
	}

	@DisplayName("자동차 주행")
	@Test
	void drive() {
		Lap prev = raceState.standby();
		Lap next = raceState.drive(prev.getRecord());

		for (Car car : next.getRecord().keySet()) {
			assertThat(next.getRecord().get(car).getValue()).isBetween(0, 1);
		}
	}

	@DisplayName("경기 기록 저장")
	@Test
	void saveLaps() {
		List<Lap> laps = new ArrayList<>();
		laps.add(raceState.standby());
		assertThat(raceState.saveLaps(laps)).isTrue();
		assertThat(raceState.saveLaps(laps)).isFalse();
	}
}
