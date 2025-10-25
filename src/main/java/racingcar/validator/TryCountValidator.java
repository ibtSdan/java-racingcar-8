package racingcar.validator;

import racingcar.message.ErrorMessage;

public class TryCountValidator extends BaseValidator{
    public void validateNotEmpty(String input){
        super.validateNotEmpty(input);
    }

    public void validateNonNegative(String input){
        if (!input.matches("\\d+")){
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT);
        }
    }
}
