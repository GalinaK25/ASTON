package Task6_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Сложение")
    void testAddition() {
        assertEquals(6, ArithmeticOperations.add(1, 5));
    }

    @Test
    @DisplayName("Вычитание")
    void testSubtraction() {
        assertEquals(-4, ArithmeticOperations.subtract(1, 5));
    }

    @Test
    @DisplayName("Умножение")
    void testMultiplication() {
        assertEquals(5, ArithmeticOperations.multiply(1, 5));
    }

    @Test
    @DisplayName("Деление")
    void testDivision() {
        assertEquals(0.2, ArithmeticOperations.divide(1, 5), 0.01);
    }

    @Test
    @DisplayName("Деление на 0")
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            () -> ArithmeticOperations.divide(1, 0)
        );
        assertEquals("/0 is impossible", exception.getMessage());
    }
}