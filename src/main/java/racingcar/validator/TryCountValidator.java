package racingcar.validator;

public class TryCountValidator extends BaseValidator{
    public void validateNotEmpty(String input){
        super.validateNotEmpty(input, "시도할 횟수는 비어있을 수 없습니다.");
    }

    public void validateNonNegative(String input){
        if (!input.matches("\\d+")){
            throw new IllegalArgumentException("입력은 0 또는 양수만 가능합니다.");
        }
    }
}
