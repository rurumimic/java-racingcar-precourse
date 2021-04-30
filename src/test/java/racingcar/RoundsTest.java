package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoundsTest {

	@DisplayName("라운드 생성")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void success(int number) {
		Rounds rounds = new Rounds(number);
		assertThat(rounds.getValue()).isEqualTo(number);
	}

	@DisplayName("라운드 생성 실패")
	@ParameterizedTest
	@ValueSource(ints = {0, -1, -2})
	void fail(int number) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Rounds(number);
		});
	}

}
