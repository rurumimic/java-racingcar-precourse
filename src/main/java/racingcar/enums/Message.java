package racingcar.enums;

public enum Message {
	NEWLINE(""),

	/* Register State */
	WELCOME("\n경주할 자동차 이름을 영어 소문자로 입력하세요. (이름은 쉼표 기준으로 구분):"),
	NAME("이름은 영어 소문자 5글자 이내로 입력하세요."),
	STANDINGS("자동차 목록은 영어 소문자와 쉼표만으로 입력하세요."),
	PITSTOP("등록 가능한 자동차 수는 2 ~ 20개입니다."),
	DUPLICATION("서로 다른 자동차 이름을 입력하세요."),

	/* Ready State */
	ROUNDS("\n시도할 회수는 몇 회인가요? (1 ~ 99):"),
	ROUNDS_RANGE("1 ~ 99 사이의 숫자를 입력하세요."),

	/* Race State */
	START("\n실행 결과"),
	BROADCAST("%5s : %s"),

	/* Prize State */
	CHAMPIONS("가 최종 우승했습니다."),

	/* Distance */
	DISTANCE_RANGE("최소 거리는 0 입니다."),

	/* ERRORS */
	ERROR_SAVE_CARS("\n자동차 이름 저장 에러."),
	ERROR_SAVE_ROUNDS("\n라운드 저장 에러."),
	ERROR_SAVE_LAPS("\n랩 저장 에러.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
