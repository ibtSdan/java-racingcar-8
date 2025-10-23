package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler implements InputProvider{
    @Override
    public String getInput() {
        return Console.readLine();
    }
}
