package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final RacingCarView view;
    private final RacingGameService service;

    public RacingCarController(RacingCarView view, RacingGameService service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        String carInput = view.getCarNamesInput();
        String tryCountInput = view.getTryCountInput();

        service.startGame(carInput, tryCountInput);
    }
}