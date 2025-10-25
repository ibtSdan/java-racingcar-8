package racingcar.view;

import racingcar.domain.Car;
import racingcar.input.InputProvider;
import racingcar.message.OutputMessage;

import java.util.List;

public class RacingCarView {
    private final InputProvider provider;

    public RacingCarView(InputProvider provider) {
        this.provider = provider;
    }

    public String getCarNamesInput(){
        System.out.println(OutputMessage.ASK_CAR_NAMES);
        return provider.getInput();
    }

    public String getTryCountInput(){
        System.out.println(OutputMessage.ASK_TRY_COUNT);
        return provider.getInput();
    }

    public void printResult(){
        System.out.println(OutputMessage.RESULT_TITLE);
    }

    public void printRoundResult(List<Car> cars){
        for (Car car : cars){
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners){
        System.out.println(OutputMessage.FINAL_WINNER+String.join(", ", winners));
    }
}
