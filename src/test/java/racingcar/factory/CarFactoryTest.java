package racingcar.factory;


import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarFactoryTest {
    @Test
    public void 자동차_생성_정상(){
        CarFactory factory = new CarFactory();
        List<String> names = List.of("a", "b", "c");

        List<Car> cars = factory.createCars(names);
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("a");
        assertThat(cars.get(1).getName()).isEqualTo("b");
        assertThat(cars.get(2).getName()).isEqualTo("c");
    }
}
