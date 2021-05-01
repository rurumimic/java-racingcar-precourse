package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

	@DisplayName("게임 생성")
	@Test
	void play() {
		Game game = new Game();
		assertThat(game.play()).isTrue();
	}

	@DisplayName("게임 종료")
	@Test
	void end() {
		Game game = new Game();
		game.end();
		assertThat(game.play()).isFalse();
	}

	@DisplayName("게임 라운드 입력")
	@Test
	void ready() {
		Game game = new Game();
		game.ready();
		assertThat(game.play()).isTrue();
	}

	@DisplayName("경주 시작")
	@Test
	void start() {
		Game game = new Game();
		game.start();
		assertThat(game.play()).isTrue();
	}

}
