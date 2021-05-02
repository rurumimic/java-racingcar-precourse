package racingcar;

import racingcar.enums.Message;
import racingcar.exceptions.InvalidCarNameException;
import racingcar.validator.NameValidator;
import racingcar.validator.Validator;

public class Car {

	private String name;

	public Car(String name) {
		Validator validator = new NameValidator();
		if (!validator.isValid(name)) {
			throw new InvalidCarNameException(Message.NAME.toString());
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
