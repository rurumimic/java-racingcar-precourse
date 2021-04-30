package racingcar.enums;

public enum Message {
	NAME("이름은 영어 소문자 5글자 이내로 입력하세요."),
	LOWERCASE("자동차 목록은 영어 소문자와 쉼표만으로 구분하세요."),
	CANDIDATE("등록 가능한 자동차 수는 2 ~ 20개입니다.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
