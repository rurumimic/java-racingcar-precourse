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
		assertThat(validator.alert()).isEqualTo(Message.STANDINGS);
	}

	@DisplayName("통과: 영어 소문자 + 쉼표")
	@ParameterizedTest
	@ValueSource(strings = {"a,b", "a,b,c"})
	void valid(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("실패: 공백 포함")
	@ParameterizedTest
	@ValueSource(strings = {"", "a,", ",a", "a,b,", "a,,b"})
	void invalid(String text) {
		assertThat(validator.isValid(text)).isFalse();
	}
}
