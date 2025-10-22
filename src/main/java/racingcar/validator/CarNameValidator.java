package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    public void validateNotEmpty(String carInput){
        String cleanedCarInput = carInput.trim();
        if (cleanedCarInput == null || cleanedCarInput.isEmpty()){
            throw new IllegalArgumentException("입력이 비어있을 수 없습니다.");
        }
    }

    public void validateLength(String input){
        String cleanedInput = input.trim();
        if (cleanedInput.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public void validateDuplicate(List<String> names){
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names){
            if (!uniqueNames.add(name)){
                throw new IllegalArgumentException("자동차 이름은 중복이 불가능합니다.");
            }
        }
    }
}
