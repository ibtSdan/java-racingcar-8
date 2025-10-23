package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.factory.CarFactory;
import racingcar.input.InputHandler;
import racingcar.input.InputProvider;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        CarNameValidator carNameValidator = new CarNameValidator();
        TryCountValidator tryCountValidator = new TryCountValidator();
        InputProvider provider = new InputHandler();
        RacingCarView view = new RacingCarView(provider);

        RacingCarController controller = new RacingCarController(factory, carNameValidator, tryCountValidator, view);
        controller.run();
    }
}
