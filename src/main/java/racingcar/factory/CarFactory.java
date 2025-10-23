package racingcar.factory;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    public List<Car> createCars(List<String> names){
        return names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
