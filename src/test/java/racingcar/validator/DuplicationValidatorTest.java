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
		assertThat(validator.alert()).isEqualTo(Message.DUPLICATION);
	}

	@DisplayName("통과: 서로 다른 이름")
	@ParameterizedTest
	@ValueSource(strings = {"a,b,c", "a,ab"})
	void valid(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("실패: 중복 이름")
	@ParameterizedTest
	@ValueSource(strings = {"a,a", "a,b,a", "abc,def,abc"})
	void invalid(String text) {
		assertThat(validator.isValid(text)).isFalse();
		assertThat(validator.alert(text)).isEqualTo(Message.DUPLICATION);
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
