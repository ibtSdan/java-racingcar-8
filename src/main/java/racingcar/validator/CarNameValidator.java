package racingcar.validator;

import racingcar.message.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator extends BaseValidator{
    public void validateNotEmpty(String carInput){
        super.validateNotEmpty(carInput);
    }

    public void validateLength(String input){
        if (input.length() > 5){
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    public void validateDuplicate(List<String> names){
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names){
            if (!uniqueNames.add(name)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME);
            }
        }
    }
}
