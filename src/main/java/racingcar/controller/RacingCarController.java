package racingcar.controller;

import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.validator.CarNameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final CarFactory factory;
    private final CarNameValidator validator;

    public RacingCarController(CarFactory factory, CarNameValidator validator) {
        this.factory = factory;
        this.validator = validator;
    }

    public void run(){
        // 입력
        List<Car> cars = createCarsFromInput(input);
    }

    private List<Car> createCarsFromInput(String input){
        validateNotEmpty(input);
        List<String> names = split(input);
        validateAll(names);
        List<Car> cars = createCars(names);
    }

    private void validateNotEmpty(String input){
        validator.validateNotEmpty(input);
    }

    private List<String> split(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateAll(List<String> names){
        names.forEach(validator::validateLength);
        validator.validateDuplicate(names);
    }

    private List<Car> createCars(List<String> names){
        return factory.createCars(names);
    }
}
