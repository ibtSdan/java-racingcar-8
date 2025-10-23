package racingcar.view;

import racingcar.domain.Car;
import racingcar.input.InputProvider;

import java.util.List;

public class RacingCarView {
    private final InputProvider provider;

    public RacingCarView(InputProvider provider) {
        this.provider = provider;
    }

    public String getCarNamesInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return provider.getInput();
    }

    public String getTryCountInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return provider.getInput();
    }

    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars){
        for (Car car : cars){
            System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
        }
    }

    public void printWinners(List<String> winners){
        System.out.println("최종 우승자 : "+String.join(", ", winners));
    }
}
