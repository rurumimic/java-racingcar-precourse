package racingcar;

import racingcar.validator.NameValidator;
import racingcar.validator.Validator;

public class Car {

	Validator validator = new NameValidator();
	String name;

	public Car(String name) {
		if (!validator.isValid(name)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

}
