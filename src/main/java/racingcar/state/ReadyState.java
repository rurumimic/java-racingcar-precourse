package racingcar.state;

import racingcar.Game;
import racingcar.Rounds;
import racingcar.enums.Message;
import racingcar.io.Display;
import racingcar.io.Keyboard;

public class ReadyState implements State {

	private Game game;

	public ReadyState(Game game) {
		this.game = game;
	}

	@Override
	public void action() {
		Display.show(Message.ROUNDS);
		String text = Keyboard.read();

		if (!validate(text)) {
			Display.show(Message.ROUNDS_RANGE);
			return;
		}

		if (!saveRounds(toRounds(text))) {
			Display.show(Message.ERROR_SAVE_ROUNDS);
			game.end();
			return;
		}

		game.start();
	}

	public Rounds toRounds(String text) {
		return new Rounds(Integer.parseInt(text));
	}

	public boolean validate(String text) {
		try {
			toRounds(text);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean saveRounds(Rounds rounds) {
		return game.storage().saveRounds(rounds);
	}
}
