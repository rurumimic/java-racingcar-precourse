package racingcar.state;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.Car;
import racingcar.Distance;
import racingcar.Game;
import racingcar.Lap;
import racingcar.exceptions.CarsSaveException;
import racingcar.exceptions.InvalidCarNameException;
import racingcar.exceptions.LapsSaveException;

public class PodiumStateTest {

	Game game;
	PodiumState podiumState;
	Car apple, baby, candy, dog;
	List<Car> cars;
	Map<Car, Distance> finish;
	List<Lap> laps;

	void createCars() {
		apple = new Car("apple");
		baby = new Car("baby");
		candy = new Car("candy");
		dog = new Car("dog");
		cars = Arrays.asList(apple, baby, candy, dog);
	}

	void createLaps() {
		finish = new HashMap<Car, Distance>() {{
			put(apple, new Distance(3));
			put(baby, new Distance(1));
			put(candy, new Distance(3));
			put(dog, new Distance(2));
		}};
		laps = Collections.singletonList(new Lap(finish));
	}

	@BeforeEach
	void setup() {
		game = new Game();
		createCars();
		createLaps();
		game.storage().saveCars(cars);
		game.storage().saveLaps(laps);
		podiumState = new PodiumState(game);
	}

	@DisplayName("챔피언 목록 생성")
	@Test
	void champions() {
		List<Car> cars = podiumState.champions();
		List<String> valid = Arrays.asList("apple", "candy");
		List<String> invalid = Arrays.asList("baby", "dog");
		for (Car car : cars) {
			assertThat(valid.contains(car.getName())).isTrue();
			assertThat(invalid.contains(car.getName())).isFalse();
		}
	}

}
