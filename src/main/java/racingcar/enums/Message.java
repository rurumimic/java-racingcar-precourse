package racingcar.enums;

public enum Message {
	WELCOME("경주할 자동차 목록을 영어 소문자로 입력하세요. 자동차는 쉼표로 구분합니다:"),
	NAME("이름은 영어 소문자 5글자 이내로 입력하세요."),
	STANDINGS("자동차 목록은 영어 소문자와 쉼표만으로 구분하세요."),
	PITSTOP("등록 가능한 자동차 수는 2 ~ 20개입니다."),
	DUPLICATION("서로 다른 자동차 이름을 입력하세요."),

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
