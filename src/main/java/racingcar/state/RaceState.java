package racingcar.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.Car;
import racingcar.Distance;
import racingcar.Game;
import racingcar.Lap;
import racingcar.Rounds;
import racingcar.enums.Message;
import racingcar.exceptions.LapsSaveException;
import racingcar.io.Display;
import racingcar.dice.Dice;

public class RaceState implements State {

	private Game game;
	private Rounds rounds;
	private List<Car> cars;
	private List<Lap> laps = new ArrayList<>();

	public RaceState(Game game) {
		this.game = game;
		this.cars = game.storage().loadCars();
		this.rounds = game.storage().loadRounds();
	}

	@Override
	public void action() {
		Display.show(Message.START);
		race(standby());

		if (saveLaps(this.laps)) {
			game.podium();
			return;
		}
	}

	private void race(Lap lineup) {
		laps.add(lineup);
		circuit(lineup.getRecord());
	}

	private void circuit(Map<Car, Distance> prev) {
		for (int i = 0; i < rounds.getValue(); i++) {
			Lap lap = drive(prev, new Dice());
			prev = lap.getRecord();
			laps.add(lap);
			Display.broadcast(lap);
		}
	}

	public Lap standby() {
		Map<Car, Distance> record = new HashMap<>();
		for (Car car : cars) {
			record.put(car, new Distance());
		}
		return new Lap(record);
	}

	public Lap drive(Map<Car, Distance> prev, Dice dice) {
		Map<Car, Distance> record = new HashMap<>();
		for (Car car : cars) {
			record.put(car, prev.get(car).add(dice.roll()));
		}
		return new Lap(record);
	}

	public boolean saveLaps(List<Lap> laps) {
		try {
			game.storage().saveLaps(laps);
			return true;
		} catch (LapsSaveException e) {
			Display.show(Message.ERROR_SAVE_LAPS);
			game.end();
		}
		return false;
	}

}
