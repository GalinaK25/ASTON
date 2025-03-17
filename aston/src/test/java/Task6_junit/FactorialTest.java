package Task6_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    @DisplayName("Факториал 0")
    void testFactorialOfZero() {
        assertEquals(1, Factorial.calculateFactorial(0));
    }

    @Test
    @DisplayName("Факториал 1")
    void testFactorialOfOne() {
        assertEquals(1, Factorial.calculateFactorial(1));
    }

    @Test
    @DisplayName("Факториал")
    void testFactorialOfFive() {
        assertEquals(120, Factorial.calculateFactorial(5));
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    void testFactorialOfNegativeNumber() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Factorial.calculateFactorial(-5)
        );
        assertEquals("n! for n < 0 is impossible", exception.getMessage());
    }
}