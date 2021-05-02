package racingcar.dice;

import racingcar.Distance;

public class OnlyOneDice extends Dice {
	public Distance roll() {
		return new Distance(1);
	}
}
