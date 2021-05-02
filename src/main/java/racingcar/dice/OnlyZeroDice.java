package racingcar.dice;

import racingcar.Distance;

public class OnlyZeroDice extends Dice {
	public Distance roll() {
		return new Distance(0);
	}
}
