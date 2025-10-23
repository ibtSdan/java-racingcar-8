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
}
