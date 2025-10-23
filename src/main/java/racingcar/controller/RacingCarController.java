package racingcar.controller;

import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.input.InputProvider;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.RacingCarView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private final CarFactory factory;
    private final CarNameValidator carNameValidator;
    private final TryCountValidator tryCountValidator;
    private final RacingCarView view;

    public RacingCarController(CarFactory factory, CarNameValidator carNameValidator, TryCountValidator tryCountValidator, RacingCarView view) {
        this.factory = factory;
        this.carNameValidator = carNameValidator;
        this.tryCountValidator = tryCountValidator;
        this.view = view;
    }

    public void run(){
        String carInput = view.getCarNamesInput();
        List<Car> cars = createCarsFromInput(carInput);
        String tryCountInput = view.getTryCountInput();
        BigInteger tryCount = createTryCountFromInput(tryCountInput);

        view.printResult();

        for (int i=0; i<tryCount.intValue(); i++) {
            moveAllCars(cars);
            view.printRoundResult(cars);
        }

        List<String> winners = getWinners(cars);
        view.printWinners(winners);
    }

    private void moveAllCars(List<Car> cars){
        for (Car car : cars){
            car.move();
        }
    }

    private List<String> getWinners(List<Car> cars){
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() >= maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
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
