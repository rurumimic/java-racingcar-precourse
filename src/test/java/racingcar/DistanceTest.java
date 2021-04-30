package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DistanceTest {

	@DisplayName("이동 거리 초기화")
	@Test
	void create() {
		Distance distance = new Distance();
		assertThat(distance.getValue()).isEqualTo(0);
	}

	@DisplayName("이동 거리 생성")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void success(int number) {
		Distance distance = new Distance(number);
		assertThat(distance.getValue()).isEqualTo(number);
	}

	@DisplayName("이동 거리 생성 실패")
	@ParameterizedTest
	@ValueSource(ints = {-1, -2, -3})
	void fail(int number) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Distance(number);
		});
	}

}
