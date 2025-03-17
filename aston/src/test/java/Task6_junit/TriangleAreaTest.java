package Task6_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    @Test
    @DisplayName("Валидные значения основания и высоты")
    void testValidTriangleArea() {
        assertEquals(12.5, TriangleArea.calculateTriangleArea(5, 5), 0.0001);
    }

    @Test
    @DisplayName("Отрицательное основание треугольника")
    void testNegativeBase() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> TriangleArea.calculateTriangleArea(-5, 10)
        );
        assertEquals("Base and height should be > 0", exception.getMessage());
    }

    @Test
    @DisplayName("Отрицательная высота треугольника")
    void testNegativeHeight() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> TriangleArea.calculateTriangleArea(5, -10)
        );
        assertEquals("Base and height should be > 0", exception.getMessage());
    }

    @Test
    @DisplayName("Нулевое основание треугольника")
    void testZeroBase() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> TriangleArea.calculateTriangleArea(0.0, 10.0)
        );
        assertEquals("Base and height should be > 0", exception.getMessage());
    }
}