package racingcar.validator;

import java.util.List;

import racingcar.enums.Pitstop;
import racingcar.enums.Message;
import racingcar.io.Splitter;

public class PitstopValidator extends Validator {

	Validator validator;

	public PitstopValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public String alert() {
		return Message.PITSTOP.toString();
	}

	@Override
	public boolean isValid(String text) {
		if (!validator.isValid(text)) {
			return false;
		}
		List<String> cars = Splitter.split(text);
		return cars.size() >= Pitstop.MIN.getValue() && cars.size() <= Pitstop.MAX.getValue();
	}
}
