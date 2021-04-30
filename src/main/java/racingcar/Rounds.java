package racingcar;

public class Rounds {

	private int value;

	public Rounds(int value) {
		if (value < 1) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
