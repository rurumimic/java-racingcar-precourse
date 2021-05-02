package racingcar.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.Game;
import racingcar.enums.Message;
import racingcar.enums.Round;
import racingcar.exceptions.RoundsOutOfBoundsException;

public class ReadyStateTest {

	Game game;
	ReadyState readyState;

	@BeforeEach
	void setup() {
		game = new Game();
		readyState = new ReadyState(game);
	}

	@DisplayName("라운드 한 번만 저장 가능")
	@ParameterizedTest
	@ValueSource(strings = {"1"})
	void saveRounds(String text) {
		assertThat(readyState.saveRounds(text)).isTrue();
		assertThat(readyState.saveRounds(text)).isFalse();
	}

	@DisplayName("라운드 생성: 1 ~ 99")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "98", "99"})
	void toRounds(String text) {
		assertThat(readyState.toRounds(text).getValue()).isBetween(Round.MIN.getValue(), Round.MAX.getValue());
	}

	@DisplayName("라운드 생성 실패: 숫자 아님")
	@ParameterizedTest
	@ValueSource(strings = {"", "text", "3.14"})
	void failToRoundsWithoutNumber(String text) {
		assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
			readyState.toRounds(text);
		});
	}

	@DisplayName("라운드 생성 실패: 숫자 < 1, 숫자 > 99")
	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "100"})
	void failToRoundsWithString(String text) {
		assertThatExceptionOfType(RoundsOutOfBoundsException.class).isThrownBy(() -> {
			readyState.toRounds(text);
		}).withMessage(Message.ROUNDS_RANGE.toString());
	}

}
