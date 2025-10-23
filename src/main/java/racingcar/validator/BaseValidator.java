package racingcar.validator;

public abstract class BaseValidator {
    protected void validateNotEmpty(String input, String errorMsg){
        if (input==null || input.trim().isEmpty()){
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
