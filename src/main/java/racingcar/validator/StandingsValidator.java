package racingcar.validator;

import java.util.regex.Pattern;

import racingcar.enums.Message;

public class StandingsValidator extends Validator {

	String message = Message.STANDINGS.toString();

	@Override
	public String alert(String text) {
		return this.message;
	}

	@Override
	public boolean isValid(String text) {
		return Pattern.matches("^[a-z]{1,5}(,[a-z]{1,5})+$", text);
	}
}
