package racingcar.io;

import java.util.Scanner;

public final class Keyboard {
	public static String read() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
