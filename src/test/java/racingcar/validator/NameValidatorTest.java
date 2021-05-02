package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;

public class NameValidatorTest {

	Validator validator = new NameValidator();

	@DisplayName("메세지 확인")
	@Test
	void alert() {
		assertThat(validator.alert()).isEqualTo(Message.NAME);
	}

	@DisplayName("통과: 글자 1 ~ 5")
	@ParameterizedTest
	@ValueSource(strings = {"a", "apple"})
	void valid(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("실패: 글자 < 0, 글자 > 5")
	@ParameterizedTest
	@ValueSource(strings = {"", "abcdef", "ABC", "999", "?!"})
	void invalid(String text) {
		assertThat(validator.isValid(text)).isFalse();
	}

}
