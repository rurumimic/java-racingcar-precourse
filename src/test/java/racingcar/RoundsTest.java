package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;
import racingcar.exceptions.RoundsOutOfBoundsException;

public class RoundsTest {

	@DisplayName("라운드 생성: 범위 1 ~ 99")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 99})
	void newRounds(int number) {
		Rounds rounds = new Rounds(number);
		assertThat(rounds.getValue()).isEqualTo(number);
	}

	@DisplayName("라운드 생성 실패: 범위 초과")
	@ParameterizedTest
	@ValueSource(ints = {0, -1, -2, 100})
	void failNewRounds(int number) {
		assertThatExceptionOfType(RoundsOutOfBoundsException.class).isThrownBy(() -> {
			new Rounds(number);
		}).withMessage(Message.ROUNDS_RANGE.toString());
	}

}
