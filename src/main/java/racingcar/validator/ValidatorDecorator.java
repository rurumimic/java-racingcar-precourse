package racingcar.validator;

public abstract class ValidatorDecorator extends Validator {

	Validator validator;

	public ValidatorDecorator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public String alert(String text) {
		if (!validator.isValid(text)) {
			return validator.message;
		}
		return this.message;
	}

	@Override
	public boolean isValid(String text) {
		if (!validator.isValid(text)) {
			return false;
		}
		return validate(text);
	}

	public abstract boolean validate(String text);

}
