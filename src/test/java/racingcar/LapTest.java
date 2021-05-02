package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LapTest {

	Map<Car, Distance> record;
	Car apple;
	Distance distance = new Distance();

	@BeforeEach
	void setup() {
		record = new HashMap<>();
		apple = new Car("apple");
		record.put(apple, distance);
	}

	@DisplayName("Lap 생성")
	@Test
	void newLap() {
		Lap lap = new Lap(record);
		assertThat(lap.getRecord().get(apple).getValue()).isEqualTo(0);
	}

}
