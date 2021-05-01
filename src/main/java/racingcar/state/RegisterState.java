package racingcar.state;

import java.util.ArrayList;
import java.util.List;

import racingcar.Car;
import racingcar.Game;
import racingcar.enums.Message;
import racingcar.io.Display;
import racingcar.io.Keyboard;
import racingcar.tool.Splitter;
import racingcar.validator.DuplicationValidator;
import racingcar.validator.PitstopValidator;
import racingcar.validator.StandingsValidator;
import racingcar.validator.Validator;

public class RegisterState implements State {

	Validator validator = new DuplicationValidator(new PitstopValidator(new StandingsValidator()));

	Game game;

	public RegisterState(Game game) {
		this.game = game;
	}

	@Override
	public void action() {
		Display.show(Message.WELCOME);
		String text = Keyboard.read();
		if (!validate(text)) {
			Display.show(validator.alert(text));
			return;
		}
		game.ready(toCars(text));
	}

	public boolean validate(String text) {
		return validator.isValid(text);
	}

	public List<Car> toCars(String text) {
		List<Car> cars = new ArrayList<>();
		for (String name : Splitter.split(text)) {
			cars.add(new Car(name));
		}
		return cars;
	}

}
