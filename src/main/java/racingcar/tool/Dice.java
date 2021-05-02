package racingcar.tool;

import java.util.Random;

import racingcar.Distance;
import racingcar.enums.Engine;

public final class Dice {

	private static boolean shiftGears() {
		Random random = new Random();
		return random.nextInt(Engine.RPM.getValue()) > Engine.CLUTCH.getValue();
	}

	public static Distance roll() {
		if (shiftGears()) {
			return new Distance(Engine.PEDAL.getValue());
		}
		return new Distance();
	}

}
