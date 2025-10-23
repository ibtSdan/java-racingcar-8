package racingcar.validator;

public class TryCountValidator {
    public void validateNotEmpty(String input){
        String cleanedInput = input.trim();
        if (cleanedInput==null || cleanedInput.isEmpty()){
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }

    public void validateNonNegative(String input){
        if (!input.matches("\\d+")){
            throw new IllegalArgumentException("입력은 0 또는 양수만 가능합니다.");
        }
    }
}
