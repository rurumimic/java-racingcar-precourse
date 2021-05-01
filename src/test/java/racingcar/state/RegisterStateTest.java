package racingcar.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.Game;

public class RegisterStateTest {

	Game game;
	RegisterState registerState;

	@BeforeEach
	void setup() {
		game = new Game();
		registerState = new RegisterState(game);
	}

	@DisplayName("자동차 이름 확인")
	@ParameterizedTest
	@ValueSource(strings = {"a,b", "a,b,c"})
	void valid(String text) {
		assertThat(registerState.validate(text)).isTrue();
	}

	@DisplayName("자동차 이름 불가")
	@ParameterizedTest
	@ValueSource(strings = {"", "a", "a,", ",a", "a,b,", "a,,b", "a,,b,", "abcdef,uvwxyz",
		"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u"})
	void notValid(String text) {
		assertThat(registerState.validate(text)).isFalse();
	}
}
