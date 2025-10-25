package racingcar.message;

public final class ErrorMessage {
    private ErrorMessage() {}

    public static final String EMPTY_INPUT = "입력은 비어있을 수 없습니다.";
    public static final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 5글자를 초과할 수 없습니다.";
    public static final String DUPLICATE_CAR_NAME = "자동차 이름은 중복이 불가능합니다.";
    public static final String INVALID_TRY_COUNT = "입력은 0 또는 양수만 가능합니다.";
}
