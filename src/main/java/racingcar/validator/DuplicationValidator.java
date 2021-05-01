package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.enums.Message;
import racingcar.tool.Splitter;

public class DuplicationValidator extends ValidatorDecorator {

	public DuplicationValidator(Validator validator) {
		super(validator);
		this.message = Message.DUPLICATION;
	}

	@Override
	public boolean validate(String text) {
		List<String> cars = Splitter.split(text);
		Set<String> set = new HashSet<>(cars);
		return cars.size() == set.size();
	}
}
