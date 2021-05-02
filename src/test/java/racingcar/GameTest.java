package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

	@DisplayName("게임 생성")
	@Test
	void on() {
		Game game = new Game();
		assertThat(game.on()).isTrue();
	}

	@DisplayName("게임 종료")
	@Test
	void end() {
		Game game = new Game();
		game.end();
		assertThat(game.on()).isFalse();
	}

	@DisplayName("게임 라운드 입력")
	@Test
	void ready() {
		Game game = new Game();
		game.ready();
		assertThat(game.on()).isTrue();
	}

	@DisplayName("경주 시작")
	@Test
	void start() {
		Game game = new Game();
		game.start();
		assertThat(game.on()).isTrue();
	}

	@DisplayName("우승 발표")
	@Test
	void podium() {
		List<Lap> laps = new ArrayList<>();
		Game game = new Game();
		game.storage().saveLaps(laps);
		game.podium();
		assertThat(game.on()).isTrue();
	}

}
