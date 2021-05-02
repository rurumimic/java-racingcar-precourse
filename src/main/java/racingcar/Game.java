package racingcar;

import racingcar.state.EndState;
import racingcar.state.PodiumState;
import racingcar.state.RaceState;
import racingcar.state.ReadyState;
import racingcar.state.RegisterState;
import racingcar.state.State;

public class Game {

	private State state;
	private Data data = new Data();

	public Game() {
		state = new RegisterState(this);
	}

	public void action() {
		state.action();
	}

	public boolean on() {
		return !state.getClass().equals(EndState.class);
	}

	public void end() {
		state = new EndState();
	}

	public void ready() {
		state = new ReadyState(this);
	}

	public void start() {
		state = new RaceState(this);
	}

	public void podium() {
		state = new PodiumState(this);
	}

	public Data storage() {
		return data;
	}

}
