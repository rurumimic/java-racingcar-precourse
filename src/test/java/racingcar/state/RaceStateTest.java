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
import racingcar.dice.OnlyOneDice;
import racingcar.dice.OnlyZeroDice;

public class RaceStateTest {

	Game game;
	RaceState raceState;

	Car apple, baby, candy;
	List<Car> cars;

	void createCars() {
		apple = new Car("apple");
		baby = new Car("baby");
		candy = new Car("candy");
		cars = Arrays.asList(apple, baby, candy);
	}

	@BeforeEach
	void setup() {
		game = new Game();
		createCars();
		game.storage().saveCars(cars);
		game.storage().saveRounds(new Rounds(3));
		raceState = new RaceState(game);
	}

	@DisplayName("경기 시작 전 자동차 정렬")
	@Test
	void standby() {
		Lap lap = raceState.standby();
		for (Car car : lap.getRecord().keySet()) {
			assertThat(lap.getRecord().get(car).getValue()).isEqualTo(0);
		}
	}

	@DisplayName("모든 자동차 정지")
	@Test
	void stop() {
		Lap prev = raceState.standby();
		Lap next = raceState.drive(prev.getRecord(), new OnlyZeroDice());

		for (Car car : next.getRecord().keySet()) {
			assertThat(next.getRecord().get(car).getValue()).isEqualTo(0);
		}
	}

	@DisplayName("모든 자동차 이동")
	@Test
	void move() {
		Lap prev = raceState.standby();
		Lap next = raceState.drive(prev.getRecord(), new OnlyOneDice());

		for (Car car : next.getRecord().keySet()) {
			assertThat(next.getRecord().get(car).getValue()).isEqualTo(1);
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
