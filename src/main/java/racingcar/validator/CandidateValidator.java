package racingcar.validator;

import racingcar.enums.Candidate;
import racingcar.enums.Message;

public class CandidateValidator extends Validator {

	Validator validator;

	public CandidateValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public String alert() {
		return Message.CANDIDATE.toString();
	}

	@Override
	public boolean isValid(String text) {
		if (!validator.isValid(text)) {
			return false;
		}
		String[] names = text.split(",");
		return names.length >= Candidate.MIN.getValue() && names.length <= Candidate.MAX.getValue();
	}
}
