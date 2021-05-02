package racingcar.exceptions;

public class InvalidCarNameException extends IllegalArgumentException {
	public InvalidCarNameException(String message) {
		super(message);
	}
}
