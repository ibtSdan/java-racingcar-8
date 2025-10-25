package racingcar.service;

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

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {
    RacingCarView dummyView;
    CarFactory dummyFactory;
    CarNameValidator dummyCarValidator;
    TryCountValidator dummyTryValidator;
    RacingGameService service;

    @BeforeEach
    void setUp(){
        dummyView = new RacingCarView(() -> "");
        dummyFactory = new CarFactory();
        dummyCarValidator = new CarNameValidator();
        dummyTryValidator = new TryCountValidator();
        service = new RacingGameService(dummyView,dummyFactory,dummyCarValidator,dummyTryValidator);
    }

    @Test
    void 라운드_진행_획인(){
        List<Car> cars = List.of(new Car("a"), new Car("b"));
        MoveStrategy alwaysMove = () -> true;
        BigInteger tryCount = new BigInteger("5");

        service.playRound(cars, tryCount, alwaysMove);

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

        List<String> result = service.getWinners(cars);

        assertThat(result).hasSize(2);
        assertThat(result.get(0)).isEqualTo("a");
        assertThat(result.get(1)).isEqualTo("b");
    }
}
