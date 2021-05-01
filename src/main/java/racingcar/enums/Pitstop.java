package racingcar.enums;

public enum Pitstop {
	MIN(2),
	MAX(20);

	private int value;

	Pitstop(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
