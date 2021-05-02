package racingcar;

import racingcar.enums.Message;
import racingcar.enums.Round;
import racingcar.exceptions.RoundsOutOfBoundsException;

public class Rounds {

	private int value;

	public Rounds(int value) {
		if (value < Round.MIN.getValue() || value > Round.MAX.getValue()) {
			throw new RoundsOutOfBoundsException(Message.ROUNDS_RANGE.toString());
		}
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
