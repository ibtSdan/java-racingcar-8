package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy{
    @Override
    public boolean movable() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue>=4;
    }
}
