package racingcar.state;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.Car;
import racingcar.Game;

public class RegisterStateTest {

	Game game;
	RegisterState registerState;

	@BeforeEach
	void setup() {
		game = new Game();
		registerState = new RegisterState(game);
	}

	@DisplayName("통과: 0 < (영어 소문자 1 ~ 5) <= 20")
	@ParameterizedTest
	@ValueSource(strings = {"a,b", "abcde,z", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t"})
	void valid(String text) {
		assertThat(registerState.validate(text)).isTrue();
	}

	@DisplayName("실패")
	@ParameterizedTest
	@ValueSource(strings = {
		"", "a,", ",a", "a,b,", "a,,b", // Standings
		"a", "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u", // Pitstop
		"a,a", // Duplication
		"a,abcdef" // Names
	})
	void invalid(String text) {
		assertThat(registerState.validate(text)).isFalse();
	}

	@DisplayName("자동차 이름 저장 성공")
	@ParameterizedTest
	@ValueSource(strings = {"a,b"})
	void saveCars(String text) {
		assertThat(registerState.saveCars(text)).isTrue();
	}

	@DisplayName("자동차 이름 저장 실패")
	@ParameterizedTest
	@ValueSource(strings = {"a,b"})
	void failSaveCars(String text) {
		assertThat(registerState.saveCars(text)).isTrue();
		assertThat(registerState.saveCars(text)).isFalse();
	}

	@DisplayName("자동차 목록 생성")
	@Test
	void toCars() {
		List<Car> origin = new ArrayList<>();
		origin.add(new Car("a"));
		origin.add(new Car("bc"));

		List<Car> cars = registerState.toCars("a,bc");
		assertThat(origin.size()).isEqualTo(cars.size());
		assertThat(cars.get(0).getName()).isEqualTo(origin.get(0).getName());
	}

}
