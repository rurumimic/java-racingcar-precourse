package racingcar.state;

import racingcar.Game;

public class ReadyState implements State {

	Game game;

	public ReadyState(Game game) {
		this.game = game;
	}

	@Override
	public void action() {

	}
}
