package racingcar.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.Game;
import racingcar.Rounds;
import racingcar.enums.Round;

public class ReadyStateTest {

	Game game;
	ReadyState readyState;

	@BeforeEach
	void setup() {
		game = new Game();
		readyState = new ReadyState(game);
	}

	@DisplayName("라운드 생성: 1 ~ 99")
	@Test
	void toRounds() {
		assertThat(readyState.toRounds("1").getValue()).isEqualTo(Round.MIN.getValue());
		assertThat(readyState.toRounds("99").getValue()).isEqualTo(Round.MAX.getValue());
	}

	@DisplayName("라운드 생성 실패: 범위 밖")
	@Test
	void failToRounds() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			readyState.toRounds("0");
		});
		assertThatIllegalArgumentException().isThrownBy(() -> {
			readyState.toRounds("100");
		});
	}

	@DisplayName("라운드 변환 가능")
	@ParameterizedTest
	@ValueSource(strings = {"1", "99"})
	void valid(String text) {
		assertThat(readyState.validate(text)).isTrue();
	}

	@DisplayName("라운드 변환 불가")
	@ParameterizedTest
	@ValueSource(strings = {"0", "100"})
	void invalid(String text) {
		assertThat(readyState.validate(text)).isFalse();
	}

	@DisplayName("라운드 저장")
	@ParameterizedTest
	@ValueSource(ints = {1})
	void saveRounds(int number) {
		assertThat(readyState.saveRounds(new Rounds(number))).isTrue();
		assertThat(readyState.saveRounds(new Rounds(number))).isFalse();
	}

}
