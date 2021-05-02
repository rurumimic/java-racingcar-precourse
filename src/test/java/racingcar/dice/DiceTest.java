package racingcar.dice;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiceTest {

	@DisplayName("숫자: 0")
	@Test
	void zero() {
		Dice dice = new OnlyZeroDice();
		assertThat(dice.roll().getValue()).isEqualTo(0);
	}

	@DisplayName("숫자: 1")
	@Test
	void one() {
		Dice dice = new OnlyOneDice();
		assertThat(dice.roll().getValue()).isEqualTo(1);
	}

}
