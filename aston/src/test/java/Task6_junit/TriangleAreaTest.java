package Task6_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleAreaTest {

    @Test
    @DisplayName("Валидные значения основания и высоты")
    void testValidTriangleArea() {
        assertEquals(12.5, TriangleArea.calculateTriangleArea(5, 5), 0.0001,
                "Площадь треугольника с основанием 5 и высотой 5 должна быть равна 12.5");
    }

    @Test
    @DisplayName("Слишком большие значения основания и высоты")
    void testLargeValues() {
        assertEquals(10000000000.0, TriangleArea.calculateTriangleArea(100000.0, 200000.0), 0.0001,
                "Площадь треугольника с основанием 100 000 и высотой 200 000 должна быть равна 10 000 000 000");
    }

    @Test
    @DisplayName("Отрицательное основание треугольника")
    void testNegativeBase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.calculateTriangleArea(-5, 10)
        );
        assertEquals("Base and height should be > 0", exception.getMessage(),
                "Сообщение об исключении должно быть 'Base and height should be > 0'");
    }

    @Test
    @DisplayName("Отрицательная высота треугольника")
    void testNegativeHeight() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.calculateTriangleArea(5, -10)
        );
        assertEquals("Base and height should be > 0", exception.getMessage(),
                "Сообщение об исключении должно быть 'Base and height should be > 0'");
    }

    @Test
    @DisplayName("Нулевое основание треугольника")
    void testZeroBase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TriangleArea.calculateTriangleArea(0.0, 10.0)
        );
        assertEquals("Base and height should be > 0", exception.getMessage(),
                "Сообщение об исключении должно быть 'Base and height should be > 0'");
    }

}