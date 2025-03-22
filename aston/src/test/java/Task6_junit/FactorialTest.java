package Task6_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    @DisplayName("Факториал 0")
    void testFactorialOfZero() {
        assertEquals(1, Factorial.calculateFactorial(0), "0! должен быть равен 1");
    }

    @Test
    @DisplayName("Факториал 1")
    void testFactorialOfOne() {
        assertEquals(1, Factorial.calculateFactorial(1), "1! должен быть равен 1");
    }

    @Test
    @DisplayName("Факториал")
    void testFactorialOfFive() {
        assertEquals(120, Factorial.calculateFactorial(5), "5! должен быть равен 120");
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    void testFactorialOfNegativeNumber() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calculateFactorial(-5)
        );
        assertEquals("n! for n < 0 is impossible", exception.getMessage(),
                "Сообщение об исключении должно быть 'n! for n < 0 is impossible'");
    }

    @Test
    @DisplayName("Факториал 20")
    void testFactorialOfTwenty() {
        assertEquals(2432902008176640000L, Factorial.calculateFactorial(20), "20! должен быть равен 2432902008176640000");
    }

    @Test
    @DisplayName("Факториал 21 - переполнение для long")
    void testFactorialOfTwentyOne() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calculateFactorial(21)
        );
        assertEquals("n! calculation exceeds limits", exception.getMessage(),
                "Сообщение об исключении должно быть 'n! calculation exceeds limits'");
    }
}