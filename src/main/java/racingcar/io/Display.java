package racingcar.io;

import racingcar.Car;
import racingcar.Distance;
import racingcar.Lap;
import racingcar.enums.Message;

public final class Display {
	public static void show(Message message) {
		System.out.println(message.toString());
	}

	public static void broadcast(Lap lap) {
		System.out.println(Message.NEW_ROUND.toString());

		for (Car car : lap.getRecord().keySet()) {
			System.out.println(track(car, lap.getRecord().get(car)));
		}
	}

	private static String track(Car car, Distance distance) {
		return String.format(Message.BROADCAST.toString(), car.getName(), distance.toString());
	}

}
