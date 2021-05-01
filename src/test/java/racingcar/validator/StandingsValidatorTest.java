package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;

public class StandingsValidatorTest {

	Validator validator = new StandingsValidator();

	@DisplayName("메세지 확인")
	@Test
	void alert() {
		assertThat(validator.alert()).isEqualTo(Message.STANDINGS.toString());
	}

	@DisplayName("정규표현식 통과")
	@ParameterizedTest
	@ValueSource(strings = {"a,b", "a,b,c"})
	void success(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("정규표현식 실패")
	@ParameterizedTest
	@ValueSource(strings = {"", "a", "a,", ",a", "a,b,", "a,,b", "a,,b,", "abcdef,uvwxyz"})
	void fail(String text) {
		assertThat(validator.isValid(text)).isFalse();

	}
}
