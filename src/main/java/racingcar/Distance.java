package racingcar;

import racingcar.enums.Message;
import racingcar.exceptions.DistanceOutOfBoundsException;

public class Distance implements Comparable<Distance> {

	private int value;

	public Distance() {
		this.value = 0;
	}

	public Distance(int value) {
		if (value < 0) {
			throw new DistanceOutOfBoundsException(Message.DISTANCE_RANGE.toString());
		}
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public Distance add(Distance distance) {
		return new Distance(this.value + distance.getValue());
	}

	@Override
	public String toString() {
		return new String(new char[this.value]).replace("\0", "-");
	}

	@Override
	public int compareTo(Distance o) {
		return Integer.compare(this.value, o.getValue());
	}
}
