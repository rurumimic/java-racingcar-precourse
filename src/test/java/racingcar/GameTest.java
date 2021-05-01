package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;

public class GameTest {

	@DisplayName("게임 생성")
	@Test
	void play() {
		Game game = new Game();
		assertThat(game.play()).isTrue();
	}

	@DisplayName("게임 종료")
	@Test
	void toEnd() {
		Game game = new Game();
		game.toEnd();
		assertThat(game.play()).isFalse();
	}
}
