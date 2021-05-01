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

	@DisplayName("서로 다른 문자열")
	@ParameterizedTest
	@ValueSource(strings = {"a,b,c", "a,ab"})
	void success(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("Duplication 문자열")
	@ParameterizedTest
	@ValueSource(strings = {"a,a", "a,b,a", "abc,def,abc"})
	void failInDuplication(String text) {
		assertThat(validator.isValid(text)).isFalse();
		assertThat(validator.alert(text)).isEqualTo(Message.DUPLICATION);
	}

	@DisplayName("Pitstop 범위 초과")
	@ParameterizedTest
	@ValueSource(strings = {"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u"})
	void failInPitstop(String text) {
		assertThat(validator.isValid(text)).isFalse();
		assertThat(validator.alert(text)).isEqualTo(Message.PITSTOP);
	}

	@DisplayName("Standings 실패")
	@ParameterizedTest
	@ValueSource(strings = {"", "a", "a,", ",a", "a,b,", "a,,b", "a,,b,", "abcdef,uvwxyz"})
	void failInStandings(String text) {
		assertThat(validator.isValid(text)).isFalse();
		assertThat(validator.alert(text)).isEqualTo(Message.STANDINGS);
	}

}
