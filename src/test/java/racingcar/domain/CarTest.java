package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MoveStrategy;

public class CarTest {
    @Test
    void 자동차_항상_전진_성공(){
        Car car = new Car("abc");

        MoveStrategy alwaysMove = () -> true;
        car.move(alwaysMove);

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_항상_전진_실패(){
        Car car = new Car("aaa");

        MoveStrategy neverMove = () -> false;
        car.move(neverMove);

        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
