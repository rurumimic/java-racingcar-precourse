package racingcar.state;

import racingcar.Game;
import racingcar.Rounds;
import racingcar.enums.Message;
import racingcar.exceptions.RoundsOutOfBoundsException;
import racingcar.exceptions.RoundsSaveException;
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

		if (saveRounds(text)) {
			game.start();
		}
	}

	public boolean saveRounds(String text) {
		try {
			game.storage().saveRounds(toRounds(text));
			return true;
		} catch (RoundsOutOfBoundsException | NumberFormatException e) {
			Display.show(Message.ROUNDS_RANGE);
		} catch (RoundsSaveException e) {
			Display.show(Message.ERROR_SAVE_ROUNDS);
			game.end();
		}
		return false;
	}

	public Rounds toRounds(String text) {
		return new Rounds(Integer.parseInt(text));
	}

}
