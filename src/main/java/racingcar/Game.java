package racingcar;

import racingcar.state.EndState;
import racingcar.state.RegisterState;
import racingcar.state.State;

public class Game {

	private State current;

	public Game() {
		current = new RegisterState(this);
	}

	public void toEnd() {
		current = new EndState();
	}

	public boolean play() {
		return !current.getClass().equals(EndState.class);
	}
}
