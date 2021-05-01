package racingcar.tool;

import java.util.Arrays;
import java.util.List;

public final class Splitter {
	public static List<String> split(String text) {
		return Arrays.asList(text.split(","));
	}
}
