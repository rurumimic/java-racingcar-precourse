package racingcar.validator;

public abstract class Validator {

	String message;

	public String alert() {
		return this.message;
	}

	public abstract String alert(String text);

	public abstract boolean isValid(String text);

}
