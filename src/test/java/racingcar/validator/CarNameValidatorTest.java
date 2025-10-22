package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameValidatorTest {
    CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void 자동차_입력값이_없을때_예외(){
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateNotEmpty(input);
        });
    }

    @Test
    void 자동차_입력값이_있을때_정상(){
        String input = "a,b,c";
        assertDoesNotThrow(() -> carNameValidator.validateNotEmpty(input));
    }

    @Test
    void 자동차_입력값이_공백이면_예외(){
        String input = "   ";
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateNotEmpty(input);
        });
    }
}