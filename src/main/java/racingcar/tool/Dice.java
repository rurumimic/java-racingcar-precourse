package racingcar.tool;

import java.util.Random;

import racingcar.Distance;
import racingcar.enums.Engine;

public final class Dice {
	public static Distance roll() {
		Random random = new Random();
		if (random.nextInt(Engine.GAS.getValue()) > Engine.CLUTCH.getValue()) {
			return new Distance(Engine.PEDAL.getValue());
		}
		return new Distance();
	}
}
