package racingcar;

import java.util.Map;

public class Lap {

	private Map<Car, Distance> record;

	public Lap(Map<Car, Distance> record) {
		this.record = record;
	}

	public Map<Car, Distance> getRecord() {
		return record;
	}

}
