package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class tryCountValidatorTest {
    TryCountValidator validator = new TryCountValidator();

    @Test
    void 시도할_횟수가_비어_있으면_예외(){
        String number = "";
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNotEmpty(number);
        });
    }

    @Test
    void 시도할_횟수가_비어있지_않으면_성공(){
         String number = "3";
         assertDoesNotThrow(() -> validator.validateNotEmpty(number));
    }

    @Test
    void 시도할_횟수가_공백이면_예외(){
        String number = "    ";
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNotEmpty(number);
        });
    }

    @Test
    void 시도할_횟수가_숫자가_아니면_예외(){
        String number = "a";
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNonNegative(number);
        });
    }

    @Test
    void 시도할_횟수가_음수면_예외(){
        String number = "-1";
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNonNegative(number);
        });
    }

    @Test
    void 시도할_횟수가_0이면_성공(){
        String number = "0";
        assertDoesNotThrow(() -> validator.validateNonNegative(number));
    }

    @Test
    void 시도할_횟수가_양수면_성공(){
        String number = "3";
        assertDoesNotThrow(() -> validator.validateNonNegative(number));
    }
}
