package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;

public class NamesValidatorTest {

	Validator validator = new NamesValidator(new DuplicationValidator(new PitstopValidator(new StandingsValidator())));

	@DisplayName("메세지 확인")
	@Test
	void alert() {
		assertThat(validator.alert()).isEqualTo(Message.NAME);
	}

	@DisplayName("통과: 글자 1 ~ 5")
	@ParameterizedTest
	@ValueSource(strings = {"a,b,c", "a,ab"})
	void success(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("실패: 글자 > 5")
	@ParameterizedTest
	@ValueSource(strings = {"a,abcdef"})
	void failInNames(String text) {
		assertThat(validator.isValid(text)).isFalse();
		assertThat(validator.alert(text)).isEqualTo(Message.NAME);
	}

	@DisplayName("실패: 중복 이름")
	@ParameterizedTest
	@ValueSource(strings = {"a,a", "a,b,a", "abc,def,abc"})
	void invalidAtDuplication(String text) {
		DuplicationValidatorTest test = new DuplicationValidatorTest();
		test.invalid(text);
	}

	@DisplayName("실패: 이름 < 1, 이름 > 20")
	@ParameterizedTest
	@ValueSource(strings = {"a", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u"})
	void invalidAtPitstop(String text) {
		PitstopValidatorTest test = new PitstopValidatorTest();
		test.invalid(text);
	}

	@DisplayName("실패: 공백 포함")
	@ParameterizedTest
	@ValueSource(strings = {"", "a,", ",a", "a,b,", "a,,b"})
	void invalidAtStandings(String text) {
		StandingsValidatorTest test = new StandingsValidatorTest();
		test.invalid(text);
	}
}
