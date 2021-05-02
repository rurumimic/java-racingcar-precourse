package racingcar;

import java.util.List;

import racingcar.enums.Message;
import racingcar.exceptions.CarsSaveException;
import racingcar.exceptions.LapsSaveException;
import racingcar.exceptions.RoundsSaveException;

public class Data {

	private Rounds rounds;
	private List<Car> cars;
	private List<Lap> laps;

	public Rounds loadRounds() {
		return this.rounds;
	}

	public List<Car> loadCars() {
		return this.cars;
	}

	public List<Lap> loadLaps() {
		return this.laps;
	}

	public void saveRounds(Rounds rounds) {
		if (this.rounds != null) {
			throw new RoundsSaveException(Message.ERROR_SAVE_ROUNDS.toString());
		}
		this.rounds = rounds;
	}

	public void saveCars(List<Car> cars) {
		if (this.cars != null) {
			throw new CarsSaveException(Message.ERROR_SAVE_CARS.toString());
		}
		this.cars = cars;
	}

	public void saveLaps(List<Lap> laps) {
		if (this.laps != null) {
			throw new LapsSaveException(Message.ERROR_SAVE_LAPS.toString());
		}
		this.laps = laps;
	}

}
