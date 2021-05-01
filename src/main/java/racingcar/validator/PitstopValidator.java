package racingcar.validator;

import java.util.List;

import racingcar.enums.Pitstop;
import racingcar.enums.Message;
import racingcar.tool.Splitter;

public class PitstopValidator extends ValidatorDecorator {

	public PitstopValidator(Validator validator) {
		super(validator);
		this.message = Message.PITSTOP;
	}

	@Override
	public boolean validate(String text) {
		List<String> cars = Splitter.split(text);
		return cars.size() >= Pitstop.MIN.getValue() && cars.size() <= Pitstop.MAX.getValue();
	}
}
