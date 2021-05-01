package racingcar.io;

import java.util.List;

import racingcar.Car;
import racingcar.Distance;
import racingcar.Lap;
import racingcar.enums.Message;

public final class Display {
	public static void show(Message message) {
		System.out.println(message.toString());
	}

	public static void broadcast(Lap lap) {
		System.out.println(Message.NEWLINE.toString());

		for (Car car : lap.getRecord().keySet()) {
			System.out.println(track(car, lap.getRecord().get(car)));
		}
	}

	private static String track(Car car, Distance distance) {
		return String.format(Message.BROADCAST.toString(), car.getName(), distance.toString());
	}

	public static void champions(List<Car> cars) {
		System.out.println(Message.NEWLINE.toString());
		System.out.print(Message.CHAMPIONS.toString());

		int index;
		for (index = 0; index < cars.size() - 1; index++) {
			System.out.printf("%s, ", cars.get(index).getName());
		}

		System.out.println(cars.get(index).getName());
	}

}
