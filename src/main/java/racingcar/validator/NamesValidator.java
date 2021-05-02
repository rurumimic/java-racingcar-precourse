package racingcar.validator;

import java.util.List;

import racingcar.enums.Message;
import racingcar.tool.Splitter;

public class NamesValidator extends ValidatorDecorator {

	private NameValidator nameValidator = new NameValidator();

	public NamesValidator(Validator validator) {
		super(validator);
		this.message = Message.NAME;
	}

	@Override
	public boolean validate(String text) {
		List<String> cars = Splitter.split(text);
		int invalids = 0;
		for (String car : cars) {
			invalids += countInvalid(car);
		}
		return invalids == 0;
	}

	private int countInvalid(String text) {
		return nameValidator.isValid(text) ? 0 : 1;
	}

}
