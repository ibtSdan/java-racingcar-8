package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.factory.CarFactory;
import racingcar.input.ConsoleInput;
import racingcar.input.InputProvider;
import racingcar.service.RacingGameService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        CarNameValidator carNameValidator = new CarNameValidator();
        TryCountValidator tryCountValidator = new TryCountValidator();
        InputProvider provider = new ConsoleInput();
        RacingCarView view = new RacingCarView(provider);
        RacingGameService service = new RacingGameService(view, factory, carNameValidator, tryCountValidator);

        RacingCarController controller = new RacingCarController(view, service);
        controller.run();
    }
}
