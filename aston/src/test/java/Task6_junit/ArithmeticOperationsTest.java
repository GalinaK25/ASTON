package Task6_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArithmeticOperationsTest {

    @Test
    @DisplayName("Сложение")
    void testAddition() {
        assertEquals(6, ArithmeticOperations.add(1, 5), "1+5 должно быть равно 6");
        assertEquals(-6, ArithmeticOperations.add(-1, -5), "-1+-5 должно быть равно -6");
        assertEquals(0, ArithmeticOperations.add(0, 0), "0+0 должно быть равно 0");
    }

    @Test
    @DisplayName("Переполнение при сложении")
    void testAdditionOverflow() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.add(Integer.MAX_VALUE, 1),
                "Сложение больших чисел должно вызвать переполнение");
    }

    @Test
    @DisplayName("Вычитание")
    void testSubtraction() {
        assertEquals(0, ArithmeticOperations.subtract(5, 5), "5-5 должно быть равно 0");
        assertEquals(5, ArithmeticOperations.subtract(5, 0), "5-0 должно быть равно 5");
        assertEquals(-5, ArithmeticOperations.subtract(0, 5), "0-5 должно быть равно -5");
    }

    @Test
    @DisplayName("Умножение")
    void testMultiplication() {
        assertEquals(5, ArithmeticOperations.multiply(1, 5), "1*5 должно быть равно 5");
        assertEquals(0, ArithmeticOperations.multiply(0, 5), "0*5 должно быть равно 0");
        assertEquals(-5, ArithmeticOperations.multiply(-1, 5), "-1*5 должно быть равно -5");
    }

    @Test
    @DisplayName("Переполнение при умножении")
    void testMultiplicationOverflow() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.multiply(Integer.MAX_VALUE, 2),
                "Умножение больших чисел должно вызвать переполнение");
    }

    @Test
    @DisplayName("Деление")
    void testDivision() {
        assertEquals(0.2, ArithmeticOperations.divide(1, 5), 0.01, "1/5 должно быть равно 0.2");
        assertEquals(0, ArithmeticOperations.divide(0, 5), 0.01, "0/5 должно быть равно 0");
        assertEquals(-0.2, ArithmeticOperations.divide(-1, 5), "-1/5 должно быть равно -0.2");
    }

    @Test
    @DisplayName("Деление на 0")
    void testDivisionByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> ArithmeticOperations.divide(1, 0)
        );
        assertEquals("/0 is impossible", exception.getMessage(), "Сообщение об исключении должно быть '/0 is impossible'");
    }


}