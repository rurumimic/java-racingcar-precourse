package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;
import racingcar.exceptions.InvalidCarNameException;

public class CarTest {

	@DisplayName("자동차 생성 성공: 1 ~ 5 글자수 + 영어 소문자")
	@ParameterizedTest
	@ValueSource(strings = {"a", "apple"})
	void newCar(String text) {
		Car car = new Car(text);
		assertThat(car.getName()).isEqualTo(text);
	}

	@DisplayName("자동차 생성 실패: 영어 소문자만 가능")
	@ParameterizedTest
	@ValueSource(strings = {"", "ABC", "999", "?!"})
	void notEnglish(String text) {
		assertThatExceptionOfType(InvalidCarNameException.class).isThrownBy(() -> {
			new Car(text);
		}).withMessage(Message.NAME.toString());
	}

	@DisplayName("자동차 생성 실패: 최대 5글자만 가능")
	@ParameterizedTest
	@ValueSource(strings = {"abcdef"})
	void outOfBounds(String text) {
		assertThatExceptionOfType(InvalidCarNameException.class).isThrownBy(() -> {
			new Car(text);
		}).withMessage(Message.NAME.toString());
	}
}
