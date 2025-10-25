package racingcar.service;

import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.RacingCarView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private final RacingCarView view;
    private final CarFactory factory;
    private final CarNameValidator carNameValidator;
    private final TryCountValidator tryCountValidator;

    public RacingGameService(RacingCarView view, CarFactory factory, CarNameValidator carNameValidator, TryCountValidator tryCountValidator) {
        this.view = view;
        this.factory = factory;
        this.carNameValidator = carNameValidator;
        this.tryCountValidator = tryCountValidator;
    }

    public void startGame(String carInput, String tryCountInput){
        List<Car> cars = createCarsFromInput(carInput);
        BigInteger tryCount = createTryCountFromInput(tryCountInput);
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        view.printResult();
        playRound(cars, tryCount, moveStrategy);
        view.printWinners(getWinners(cars));
    }

    public void playRound(List<Car> cars, BigInteger tryCount, MoveStrategy moveStrategy){
        for (int i=0; i<tryCount.intValue(); i++) {
            moveAllCars(cars, moveStrategy);
            view.printRoundResult(cars);
        }
    }

    private void moveAllCars(List<Car> cars, MoveStrategy moveStrategy){
        for (Car car : cars){
            car.move(moveStrategy);
        }
    }

    public List<String> getWinners(List<Car> cars){
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> createCarsFromInput(String carInput){
        carNameValidator.validateNotEmpty(carInput);
        List<String> carNames = carSplit(carInput);
        carNames.forEach(carNameValidator::validateLength);
        carNameValidator.validateDuplicate(carNames);
        return factory.createCars(carNames);
    }

    private List<String> carSplit(String carInput){
        return Arrays.stream(carInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private BigInteger createTryCountFromInput(String tryCountInput){
        tryCountValidator.validateNotEmpty(tryCountInput);
        tryCountValidator.validateNonNegative(tryCountInput);
        return new BigInteger(tryCountInput);
    }
}