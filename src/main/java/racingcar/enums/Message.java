package racingcar.enums;

public enum Message {
	NEWLINE(""),

	/* Register State */
	WELCOME("경주할 자동차 목록을 영어 소문자로 입력하세요. 자동차는 쉼표로 구분합니다:"),
	NAME("이름은 영어 소문자 5글자 이내로 입력하세요."),
	STANDINGS("자동차 목록은 영어 소문자와 쉼표만으로 구분하세요."),
	PITSTOP("등록 가능한 자동차 수는 2 ~ 20개입니다."),
	DUPLICATION("서로 다른 자동차 이름을 입력하세요."),

	/* Ready State */
	ROUNDS("시도할 회수는 몇 회인가요? (1 ~ 99):"),
	ROUNDS_RANGE("1 ~ 99 사이의 숫자를 입력하세요."),

	/* Race State */
	START("실행 결과"),
	BROADCAST("%5s : %s"),

	/* Prize State */
	CHAMPIONS("%s가 최종 우승했습니다."),

	/* ERRORS */
	ERROR_SAVE_CARS("자동차 이름 저장 에러 발생."),
	ERROR_SAVE_ROUNDS("라운드 저장 에러 발생."),
	ERROR_SAVE_LAPS("랩 저장 에러 발생.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
