package racingcar.validator;

import racingcar.message.ErrorMessage;

public abstract class BaseValidator {
    protected void validateNotEmpty(String input){
        if (input==null || input.trim().isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT);
        }
    }
}
