package racingcar;

import java.util.List;

import racingcar.state.EndState;
import racingcar.state.RaceState;
import racingcar.state.ReadyState;
import racingcar.state.RegisterState;
import racingcar.state.State;

public class Game {

	private State current;

	public Game() {
		current = new RegisterState(this);
	}

	public boolean play() {
		return !current.getClass().equals(EndState.class);
	}

	public void end() {
		current = new EndState();
	}

	public void ready(List<Car> cars) {
		current = new ReadyState(this);
	}

	public void start() {
		current = new RaceState(this);
	}

}
