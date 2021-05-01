package racingcar.state;

import racingcar.Game;
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

	}

	public void validate(String text) {
		if (!validator.isValid(text)) {
			game.end();
		}
	}

}
