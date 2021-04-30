package racingcar;

public class Distance {

	private int value;

	public Distance() {
		this.value = 0;
	}

	public Distance(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
