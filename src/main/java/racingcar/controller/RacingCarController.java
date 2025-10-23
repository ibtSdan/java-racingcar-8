package racingcar.controller;

import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.input.InputProvider;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final CarFactory factory;
    private final CarNameValidator carNameValidator;
    private final InputProvider provider;
    private final TryCountValidator tryCountValidator;

    public RacingCarController(CarFactory factory, CarNameValidator carNameValidator, InputProvider provider, TryCountValidator tryCountValidator) {
        this.factory = factory;
        this.carNameValidator = carNameValidator;
        this.provider = provider;
        this.tryCountValidator = tryCountValidator;
    }

    public void run(){
        String carInput = provider.getInput();
        List<Car> cars = createCarsFromInput(carInput);
        String tryCountInput = provider.getInput();
        BigInteger tryCount = createTryCountFromInput(tryCountInput);
    }

    public List<Car> createCarsFromInput(String carInput){
        validateNotEmptyCarNames(carInput);
        List<String> carNames = carSplit(carInput);
        validateCarAll(carNames);
        return createCars(carNames);
    }

    private void validateNotEmptyCarNames(String carInput){
        carNameValidator.validateNotEmpty(carInput);
    }

    private List<String> carSplit(String carInput){
        return Arrays.stream(carInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCarAll(List<String> carNames){
        carNames.forEach(carNameValidator::validateLength);
        carNameValidator.validateDuplicate(carNames);
    }

    private List<Car> createCars(List<String> carNames){
        return factory.createCars(carNames);
    }

    public BigInteger createTryCountFromInput(String tryCountInput){
        validateNotEmptyTryCount(tryCountInput);
        validateNonNegative(tryCountInput);
        return new BigInteger(tryCountInput);
    }

    private void validateNotEmptyTryCount(String tryCountInput){
        tryCountValidator.validateNotEmpty(tryCountInput);
    }

    private void validateNonNegative(String tryCountInput){
        tryCountValidator.validateNonNegative(tryCountInput);
    }
}
