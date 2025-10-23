package racingcar.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.factory.CarFactory;
import racingcar.input.InputProvider;
import racingcar.strategy.MoveStrategy;
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
    InputProvider provider = () -> "";
    RacingCarView view;
    RacingCarController controller;

    @BeforeEach
    void setUp(){
        validator = new CarNameValidator();
        factory = new CarFactory();
        tryCountValidator = new TryCountValidator();
        view = new RacingCarView(provider);
        controller = new RacingCarController(factory,validator,tryCountValidator,view);
    }

    @Test
    void 자동차_반복_누적_획인(){
        List<Car> cars = List.of(new Car("a"), new Car("b"));
        MoveStrategy alwaysMove = () -> true;
        BigInteger tryCount = new BigInteger("5");

        controller.playRound(cars, tryCount, alwaysMove);

        assertThat(cars.get(0).getPosition()).isEqualTo(5);
        assertThat(cars.get(1).getPosition()).isEqualTo(5);
    }

    @Test
    void 우승자_출력_확인(){
        List<Car> cars = List.of(new Car("a"), new Car("b"), new Car("c"));

        MoveStrategy alwaysMove = () -> true;
        cars.get(0).move(alwaysMove);
        cars.get(0).move(alwaysMove);
        cars.get(1).move(alwaysMove);
        cars.get(1).move(alwaysMove);
        cars.get(2).move(alwaysMove);

        List<String> result = controller.getWinners(cars);

        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo("a");
        assertThat(result.get(1)).isEqualTo("b");
    }
}
