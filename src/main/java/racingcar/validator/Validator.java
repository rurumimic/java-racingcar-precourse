package racingcar.validator;

import racingcar.enums.Message;

public abstract class Validator {

	Message message;

	public Message alert() {
		return this.message;
	}

	public abstract Message alert(String text);

	public abstract boolean isValid(String text);

}
