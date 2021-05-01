package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.enums.Message;
import racingcar.tool.Splitter;

public class DuplicationValidator extends Validator {

	Validator validator;

	public DuplicationValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public String alert() {
		return Message.DUPLICATION.toString();
	}

	@Override
	public boolean isValid(String text) {
		if (!validator.isValid(text)) {
			return false;
		}
		List<String> cars = Splitter.split(text);
		Set<String> set = new HashSet<>(cars);
		return cars.size() == set.size();
	}
}
