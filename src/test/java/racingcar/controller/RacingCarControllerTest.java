package racingcar.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.validator.CarNameValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarControllerTest {
    private CarNameValidator validator;
    private CarFactory factory;
    private RacingCarController controller;

    @BeforeEach
    void setUp(){
        validator = new CarNameValidator();
        factory = new CarFactory();
        controller = new RacingCarController(factory, validator);
    }

    @Test
    void run_정상_흐름_자동차_리스트_생성_성공(){
        String input = "a,b,c";
        List<Car> cars = controller.run(input);

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("a");
        assertThat(cars.get(1).getName()).isEqualTo("b");
        assertThat(cars.get(2).getName()).isEqualTo("c");
    }
}
