package racingcar.controller;

import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.input.InputHandler;
import racingcar.input.InputProvider;
import racingcar.validator.CarNameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final CarFactory factory;
    private final CarNameValidator validator;
    private final InputProvider provider;

    public RacingCarController(CarFactory factory, CarNameValidator validator, InputProvider provider) {
        this.factory = factory;
        this.validator = validator;
        this.provider = provider;
    }

    public void run(){
        String carInput = provider.getInput();
        List<Car> cars = createCarsFromInput(carInput);
    }

    public List<Car> createCarsFromInput(String input){
        validateNotEmpty(input);
        List<String> names = split(input);
        validateAll(names);
        return createCars(names);
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
