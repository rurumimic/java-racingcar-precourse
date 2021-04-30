package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@DisplayName("자동차 생성")
	@ParameterizedTest
	@ValueSource(strings = {"a", "apple"})
	void success(String text) {
		Car car = new Car(text);
		assertThat(car.getName()).isEqualTo(text);
	}

	@DisplayName("자동차 생성 실패")
	@ParameterizedTest
	@ValueSource(strings = {"", "abcdef", "ABC", "999", "?!"})
	void fail(String text) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Car(text);
		});
	}
}
