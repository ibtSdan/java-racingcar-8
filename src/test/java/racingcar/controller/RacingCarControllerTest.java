package racingcar.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.input.InputProvider;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.RacingCarView;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarControllerTest {
    CarNameValidator validator;
    CarFactory factory;
    TryCountValidator tryCountValidator;

    @BeforeEach
    void setUp(){
        validator = new CarNameValidator();
        factory = new CarFactory();
        tryCountValidator = new TryCountValidator();
    }

    @Test
    void 자동차_리스트_생성_성공(){
        InputProvider provider1 = () -> "a,b,c";
        RacingCarView view = new RacingCarView(provider1);
        RacingCarController controller1 = new RacingCarController(factory,validator,tryCountValidator,view);

        List<Car> cars = controller1.createCarsFromInput(provider1.getInput());

        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("a");
        assertThat(cars.get(1).getName()).isEqualTo("b");
        assertThat(cars.get(2).getName()).isEqualTo("c");
    }

    @Test
    void 자동차_리스트_생성_예외(){
        InputProvider provider2 = () -> "abcdef,abc";
        RacingCarView view = new RacingCarView(provider2);
        RacingCarController controller2 = new RacingCarController(factory,validator,tryCountValidator,view);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller2.createCarsFromInput(provider2.getInput());
        });

        assertThat(exception.getMessage()).isEqualTo("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    void 시도할_횟수_생성_성공(){
        InputProvider provider3 = () -> "3";
        RacingCarView view = new RacingCarView(provider3);
        RacingCarController controller3 = new RacingCarController(factory,validator,tryCountValidator,view);

        BigInteger number = controller3.createTryCountFromInput(provider3.getInput());

        assertThat(number).isEqualTo(3);
    }

    @Test
    void 시도할_횟수_생성_예외(){
        InputProvider provider4 = () -> "-3";
        RacingCarView view = new RacingCarView(provider4);
        RacingCarController controller4 = new RacingCarController(factory,validator,tryCountValidator,view);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller4.createTryCountFromInput(provider4.getInput());
        });

        assertThat(exception.getMessage()).isEqualTo("입력은 0 또는 양수만 가능합니다.");
    }
}
