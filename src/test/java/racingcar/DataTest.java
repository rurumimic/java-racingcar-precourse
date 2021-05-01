package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataTest {

	Data data = new Data();

	@DisplayName("라운드 저장")
	@Test
	void saveRounds() {
		Rounds rounds = new Rounds(1);
		assertThat(data.saveRounds(rounds)).isTrue();
		assertThat(data.saveRounds(rounds)).isFalse();
	}

	@DisplayName("자동차 저장")
	@Test
	void saveCars() {
		List<Car> cars = new ArrayList<>();
		assertThat(data.saveCars(cars)).isTrue();
		assertThat(data.saveCars(cars)).isFalse();
	}

	@DisplayName("랩 저장")
	@Test
	void saveLaps() {
		List<Lap> laps = new ArrayList<>();
		assertThat(data.saveLaps(laps)).isTrue();
		assertThat(data.saveLaps(laps)).isFalse();
	}

}
