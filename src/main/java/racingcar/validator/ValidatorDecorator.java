package racingcar.validator;

import racingcar.enums.Message;

public abstract class ValidatorDecorator extends Validator {

	Validator validator;

	public ValidatorDecorator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public Message alert(String text) {
		if (!validator.isValid(text)) {
			return validator.alert(text);
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
