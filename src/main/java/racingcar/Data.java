package racingcar;

import java.util.List;

public class Data {

	private Rounds rounds;
	private List<Car> cars;
	private List<Lap> laps;

	public boolean saveRounds(Rounds rounds) {
		if (this.rounds == null) {
			this.rounds = rounds;
			return true;
		}
		return false;
	}

	public boolean saveCars(List<Car> cars) {
		if (this.cars == null) {
			this.cars = cars;
			return true;
		}
		return false;
	}

	public boolean saveLaps(List<Lap> laps) {
		if (this.laps == null) {
			this.laps = laps;
			return true;
		}
		return false;
	}
}
