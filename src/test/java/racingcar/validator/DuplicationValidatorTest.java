package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;

public class DuplicationValidatorTest {

	Validator validator = new DuplicationValidator(new PitstopValidator(new StandingsValidator()));

	@DisplayName("메세지 확인")
	@Test
	void alert() {
		assertThat(validator.alert()).isEqualTo(Message.DUPLICATION.toString());
	}

	@DisplayName("서로 다른 문자열")
	@ParameterizedTest
	@ValueSource(strings = {"a,b,c", "a,ab"})
	void success(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("중복 문자열")
	@ParameterizedTest
	@ValueSource(strings = {"a,a", "a,b,a", "abc,def,abc"})
	void fail(String text) {
		assertThat(validator.isValid(text)).isFalse();
	}

}
