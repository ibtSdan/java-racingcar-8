package racingcar.validator;

public class TryCountValidator {
    public void validateNotEmpty(String input){
        String cleandInput = input.trim();
        if (cleandInput==null || cleandInput.isEmpty()){
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }
}
