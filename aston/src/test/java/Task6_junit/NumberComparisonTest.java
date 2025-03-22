package Task6_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComparisonTest {

    @Test
    @DisplayName("Первое число больше второго")
    void testFirstGreaterThanSecond() {
        assertEquals("10 > 5", NumberComparison.compareNumbers(10, 5), "Число 10 должно быть больше 5");
    }

    @Test
    @DisplayName("Первое число меньше второго")
    void testFirstLessThanSecond() {
        assertEquals("5 < 10", NumberComparison.compareNumbers(5, 10), "Число 5 должно быть меньше 10");
    }

    @Test
    @DisplayName("Равные числа")
    void testNumbersEqual() {
        assertEquals("5 = 5", NumberComparison.compareNumbers(5, 5), "Число 5 должно быть равно 5");
    }

    @Test
    @DisplayName("Сравнение отрицательных чисел")
    void testNegativeNumbers() {
        assertEquals("-10 < -5", NumberComparison.compareNumbers(-10, -5), "Число -10 должно быть меньше -5");
    }

    @Test
    @DisplayName("Сравнение положительного числа с 0")
    void testFirstNumberGreaterThanZero() {
        assertEquals("5 > 0", NumberComparison.compareNumbers(5, 0), "Число 5 должно быть больше 0");
    }

    @Test
    @DisplayName("Сравнение отрицательного числа с 0")
    void testFirstNumberLessThanZero() {
        assertEquals("-5 < 0", NumberComparison.compareNumbers(-5, 0), "Число -5 должно быть меньше 0");
    }

}