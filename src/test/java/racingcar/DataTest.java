package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.enums.Message;
import racingcar.exceptions.CarsSaveException;
import racingcar.exceptions.LapsSaveException;
import racingcar.exceptions.RoundsSaveException;

public class DataTest {

	Data data = new Data();

	@DisplayName("라운드 한 번만 저장 가능")
	@Test
	void saveRounds() {
		Rounds rounds = new Rounds(1);
		data.saveRounds(rounds);
		assertThat(data.loadRounds()).isNotNull();
		assertThatExceptionOfType(RoundsSaveException.class).isThrownBy(() -> {
			data.saveRounds(rounds);
		}).withMessage(Message.ERROR_SAVE_ROUNDS.toString());

	}

	@DisplayName("자동차 목록 한 번만 저장 가능")
	@Test
	void saveCars() {
		List<Car> cars = new ArrayList<>();
		data.saveCars(cars);
		assertThat(data.loadCars()).isNotNull();
		assertThatExceptionOfType(CarsSaveException.class).isThrownBy(() -> {
			data.saveCars(cars);
		}).withMessage(Message.ERROR_SAVE_CARS.toString());
	}

	@DisplayName("랩 한 번만 저장 가능")
	@Test
	void saveLaps() {
		List<Lap> laps = new ArrayList<>();
		data.saveLaps(laps);
		assertThat(data.loadLaps()).isNotNull();
		assertThatExceptionOfType(LapsSaveException.class).isThrownBy(() -> {
			data.saveLaps(laps);
		}).withMessage(Message.ERROR_SAVE_LAPS.toString());
	}

}
