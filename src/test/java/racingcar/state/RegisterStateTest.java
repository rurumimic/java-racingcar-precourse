package racingcar.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.Game;

public class RegisterStateTest {

	Game game;
	RegisterState registerState;

	@BeforeEach
	void setup() {
		game = new Game();
		registerState = new RegisterState(game);
	}

	@DisplayName("게임 종료")
	@ParameterizedTest
	@ValueSource(strings = {"ABC", "123", ",abcd"})
	void notValid(String text) {
		registerState.validate(text);
		assertThat(game.play()).isFalse();
	}
}
