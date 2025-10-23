package racingcar.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.input.InputProvider;
import racingcar.validator.CarNameValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarControllerTest {
    CarNameValidator validator;
    CarFactory factory;

    @BeforeEach
    void setUp(){
        validator = new CarNameValidator();
        factory = new CarFactory();
    }

    @Test
    void run_정상_흐름_자동차_리스트_생성_성공(){
        InputProvider provider1 = () -> "a,b,c";
        RacingCarController controller1 = new RacingCarController(factory,validator,provider1);

        List<Car> cars = controller1.createCarsFromInput(provider1.getInput());

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("a");
        assertThat(cars.get(1).getName()).isEqualTo("b");
        assertThat(cars.get(2).getName()).isEqualTo("c");
    }

    @Test
    void run_예외_상황_흐름(){
        InputProvider provider2 = () -> "abcdef,abc";
        RacingCarController controller2 = new RacingCarController(factory,validator,provider2);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller2.createCarsFromInput(provider2.getInput());
        });

        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}
