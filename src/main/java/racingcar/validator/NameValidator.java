package racingcar.validator;

import java.util.regex.Pattern;

import racingcar.enums.Message;

public class NameValidator extends Validator {

	public NameValidator() {
		this.message = Message.NAME;
	}

	@Override
	public Message alert(String text) {
		return this.message;
	}

	@Override
	public boolean isValid(String text) {
		return Pattern.matches("^[a-z]{1,5}$", text);
	}
}
