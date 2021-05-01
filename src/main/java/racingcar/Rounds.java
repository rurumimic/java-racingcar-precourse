package racingcar;

import racingcar.enums.Round;

public class Rounds {

	private int value;

	public Rounds(int value) {
		if (value < Round.MIN.getValue() || value > Round.MAX.getValue()) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
