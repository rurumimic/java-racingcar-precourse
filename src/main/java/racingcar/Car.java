package racingcar;

import racingcar.validator.NameValidator;
import racingcar.validator.Validator;

public class Car {

	private String name;

	public Car(String name) {
		Validator validator = new NameValidator();
		if (!validator.isValid(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
