package racingcar.io;

import racingcar.enums.Message;

public final class Display {
	public static void show(Message message) {
		System.out.println(message.toString());
	}
}
