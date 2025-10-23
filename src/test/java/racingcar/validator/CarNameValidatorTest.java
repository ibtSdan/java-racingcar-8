package racingcar.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameValidatorTest {
    CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void 자동차_입력값이_없으면_예외(){
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateNotEmpty(input);
        });
    }

    @Test
    void 자동차_입력값이_있으면_성공(){
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

    @Test
    void 자동차이름_길이가_5를_초과하면_예외(){
        String input = "abcdef";
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateLength(input);
        });
    }

    @Test
    void 자동차이름_길이가_5이하면_성공(){
        String input = "abcde";
        assertDoesNotThrow(() -> carNameValidator.validateLength(input));
    }

    @Test
    void 자동차_이름이_중복_되면_예외(){
        List<String> names = Arrays.asList("a", "b", "a");
        assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.validateDuplicate(names);
        });
    }

    @Test
    void 자동차_이름이_중복_없으면_성공(){
        List<String> names = Arrays.asList("a", "b", "c");
        assertDoesNotThrow(() -> carNameValidator.validateDuplicate(names));
    }
}