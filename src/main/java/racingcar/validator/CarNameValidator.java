package racingcar.validator;

public class CarNameValidator {
    public void validateNotEmpty(String carInput){
        String cleanedCarInput = carInput.trim();
        if (cleanedCarInput == null || cleanedCarInput.isEmpty()){
            throw new IllegalArgumentException("입력이 비어있을 수 없습니다.");
        }
    }
}
