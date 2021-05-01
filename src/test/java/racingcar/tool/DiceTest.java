package racingcar.tool;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.enums.Engine;

public class DiceTest {

	@DisplayName("랜덤 숫자: 0, 1")
	@Test
	void roll() {
		assertThat(Dice.roll().getValue()).isBetween(Engine.BRAKES.getValue(), Engine.PEDAL.getValue());
	}

}
