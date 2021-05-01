package racingcar.validator;

import java.util.List;

import racingcar.enums.Pitstop;
import racingcar.enums.Message;
import racingcar.tool.Splitter;

public class PitstopValidator extends ValidatorDecorator {

	String message = Message.PITSTOP.toString();

	public PitstopValidator(Validator validator) {
		super(validator);
	}

	@Override
	public boolean validate(String text) {
		List<String> cars = Splitter.split(text);
		return cars.size() >= Pitstop.MIN.getValue() && cars.size() <= Pitstop.MAX.getValue();
	}
}
