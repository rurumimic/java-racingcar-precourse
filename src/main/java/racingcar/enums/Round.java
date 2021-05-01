package racingcar.enums;

public enum Round {
	MIN(1),
	MAX(99);

	private int value;

	Round(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
