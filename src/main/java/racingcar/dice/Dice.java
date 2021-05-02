package racingcar.dice;

import java.util.Random;

import racingcar.Distance;
import racingcar.enums.Engine;

public class Dice {

	private boolean shiftGears() {
		Random random = new Random();
		return random.nextInt(Engine.RPM.getValue()) > Engine.CLUTCH.getValue();
	}

	public Distance roll() {
		if (shiftGears()) {
			return new Distance(Engine.PEDAL.getValue());
		}
		return new Distance(Engine.BRAKES.getValue());
	}

}
