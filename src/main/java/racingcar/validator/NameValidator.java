package racingcar.validator;

import java.util.regex.Pattern;

import racingcar.enums.Message;

public class NameValidator extends Validator {

	public NameValidator() {
		message = Message.NAME.toString();
	}

	@Override
	public String alert() {
		return this.message;
	}

	@Override
	public boolean isValid(String text) {
		return Pattern.matches("^[a-z]{1,5}$", text);
	}
}
