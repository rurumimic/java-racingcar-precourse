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

	@DisplayName("자동차 이름 저장")
	@ParameterizedTest
	@ValueSource(strings = {"a,b"})
	void saveCars(String text) {
		assertThat(registerState.saveCars(registerState.toCars(text))).isTrue();
		assertThat(registerState.saveCars(registerState.toCars(text))).isFalse();
	}
}
