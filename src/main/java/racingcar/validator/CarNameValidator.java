package racingcar.validator;

public class CarNameValidator {
    public void validateNotEmpty(String carInput){
        String cleanedCarInput = carInput.trim();
        if (cleanedCarInput == null || cleanedCarInput.isEmpty()){
            throw new IllegalArgumentException("입력이 비어있을 수 없습니다.");
        }
    }

    public void validateLength(String input){
        if (input.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
