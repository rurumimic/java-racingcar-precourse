package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;

public class PitstopValidatorTest {

	Validator validator = new PitstopValidator(new StandingsValidator());

	@DisplayName("메세지 확인")
	@Test
	void alert() {
		assertThat(validator.alert()).isEqualTo(Message.PITSTOP);
	}

	@DisplayName("Pitstop 범위 내")
	@ParameterizedTest
	@ValueSource(strings = {"a,b", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t"})
	void success(String text) {
		assertThat(validator.isValid(text)).isTrue();
	}

	@DisplayName("Pitstop 범위 밖")
	@ParameterizedTest
	@ValueSource(strings = {"a", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u"})
	void failInPitstop(String text) {
		assertThat(validator.isValid(text)).isFalse();
		assertThat(validator.alert(text)).isEqualTo(Message.PITSTOP);
	}

	@DisplayName("Standings 실패")
	@ParameterizedTest
	@ValueSource(strings = {"", "a,", ",a", "a,b,", "a,,b"})
	void failInStandings(String text) {
		assertThat(validator.isValid(text)).isFalse();
		assertThat(validator.alert(text)).isEqualTo(Message.STANDINGS);
	}

}
