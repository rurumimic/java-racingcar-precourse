package racingcar.validator;

import java.util.regex.Pattern;

import racingcar.enums.Message;

public class LowercaseValidator extends Validator {

	@Override
	public String alert() {
		return Message.LOWERCASE.toString();
	}

	@Override
	public boolean isValid(String text) {
		return Pattern.matches("^[a-z][a-z,]*[a-z]$", text);
	}
}
