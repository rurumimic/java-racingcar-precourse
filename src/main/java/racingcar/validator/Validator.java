package racingcar.validator;

public abstract class Validator {

	String message;

	public abstract String alert();

	public abstract boolean isValid(String text);

}
