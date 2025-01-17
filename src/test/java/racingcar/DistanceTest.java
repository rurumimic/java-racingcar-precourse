package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.enums.Message;
import racingcar.exceptions.DistanceOutOfBoundsException;

public class DistanceTest {

	@DisplayName("이동 거리 초기화")
	@Test
	void initDistance() {
		Distance distance = new Distance();
		assertThat(distance.getValue()).isEqualTo(0);
	}

	@DisplayName("이동 거리 생성")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	void newDistance(int number) {
		Distance distance = new Distance(number);
		assertThat(distance.getValue()).isEqualTo(number);
	}

	@DisplayName("이동 거리 생성 실패")
	@ParameterizedTest
	@ValueSource(ints = {-1, -2, -3})
	void failNewDistance(int number) {
		assertThatExceptionOfType(DistanceOutOfBoundsException.class).isThrownBy(() -> {
			new Distance(number);
		}).withMessage(Message.DISTANCE_RANGE.toString());
	}

	@DisplayName("이동 거리 합")
	@Test
	void add() {
		Distance one = new Distance(1);
		Distance two = new Distance(2);
		Distance three = one.add(two);
		assertThat(three.getValue()).isEqualTo(3);
	}

	@DisplayName("이동 거리 표시")
	@ParameterizedTest
	@CsvSource(value = {"1:-", "3:---"}, delimiter = ':')
	void print(int number, String text) {
		assertThat(new Distance().toString()).isEqualTo("");
		assertThat(new Distance(number).toString()).isEqualTo(text);
	}

	@DisplayName("이동 거리 비교")
	@ParameterizedTest
	@CsvSource(value = {"1:0", "0:1", "2:-1"}, delimiter = ':')
	void compareTo(int value, int expected) {
		assertThat(new Distance(1).compareTo(new Distance(value))).isEqualTo(expected);
		assertThat(new Distance(1).compareTo(new Distance(value))).isEqualTo(expected);
		assertThat(new Distance(1).compareTo(new Distance(value))).isEqualTo(expected);
	}

}
