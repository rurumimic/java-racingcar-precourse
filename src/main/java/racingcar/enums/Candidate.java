package racingcar.enums;

public enum Candidate {
	MIN(2),
	MAX(20);

	private int value;

	Candidate(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
