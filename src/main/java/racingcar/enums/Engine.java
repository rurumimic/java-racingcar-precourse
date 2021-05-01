package racingcar.enums;

public enum Engine {
	GAS(10),
	CLUTCH(3),
	BRAKES(0),
	PEDAL(1);

	private int value;

	Engine(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
