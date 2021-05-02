package racingcar.state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import racingcar.Car;
import racingcar.Distance;
import racingcar.Game;
import racingcar.Lap;
import racingcar.enums.Message;
import racingcar.io.Display;

public class PodiumState implements State {

	private Game game;
	private List<Car> cars;
	private Map<Car, Distance> finish;

	public PodiumState(Game game) {
		this.game = game;
		this.cars = game.storage().loadCars();
		for (Lap lap : game.storage().loadLaps()) {
			this.finish = lap.getRecord();
		}
	}

	@Override
	public void action() {
		game.end();
		if (this.finish == null) {
			Display.show(Message.ERROR_SAVE_LAPS);
			return;
		}
		Display.champions(champions());
	}

	public List<Car> champions() {
		ArrayList<Car> cars = new ArrayList<>(this.cars);
		Distance distance = Collections.max(this.finish.values());
		cars.removeIf(car -> (this.finish.get(car).getValue() < distance.getValue()));
		return cars;
	}

}
