package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.enums.Message;
import racingcar.tool.Splitter;

public class DuplicationValidator extends ValidatorDecorator {

	String message = Message.DUPLICATION.toString();

	public DuplicationValidator(Validator validator) {
		super(validator);
	}

	@Override
	public boolean validate(String text) {
		List<String> cars = Splitter.split(text);
		Set<String> set = new HashSet<>(cars);
		return cars.size() == set.size();
	}
}
