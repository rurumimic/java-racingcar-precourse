package racingcar;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		while (game.on()) {
			game.action();
		}
	}
}
