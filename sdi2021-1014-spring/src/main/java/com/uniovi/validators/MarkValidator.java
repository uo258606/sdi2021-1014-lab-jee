package com.uniovi.validators;

import com.uniovi.entities.*;
import com.uniovi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class MarkValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return Mark.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mark", "Error.empty");
		if (mark.getDescription().length() < 20) {
			errors.rejectValue("description", "Error.mark.description.length");
		}
		if (mark.getScore() > 10 || mark.getScore() < 0) {
			errors.rejectValue("score", "Error.mark.score.value");
		}

	}
}