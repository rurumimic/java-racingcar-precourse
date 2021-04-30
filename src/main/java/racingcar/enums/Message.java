package racingcar.enums;

public enum Message {
	NAME("이름은 영어 소문자 5글자 이내로 입력하세요.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
