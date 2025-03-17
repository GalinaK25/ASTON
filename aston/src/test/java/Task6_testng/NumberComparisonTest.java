package Task6_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparisonTest {

    @Test(description = "Первое число больше второго")
    public void testFirstGreaterThanSecond() {
        Assert.assertEquals(NumberComparison.compareNumbers(10, 5), "10 > 5");
    }

    @Test(description = "Первое число меньше второго")
    public void testFirstLessThanSecond() {
        Assert.assertEquals(NumberComparison.compareNumbers(5, 10), "5 < 10");
    }

    @Test(description = "Числа равны")
    public void testNumbersEqual() {
        Assert.assertEquals(NumberComparison.compareNumbers(5, 5), "5 = 5");
    }

    @Test(description = "Сравнение отрицательных чисел")
    public void testNegativeNumbers() {
        Assert.assertEquals(NumberComparison.compareNumbers(-10, -5), "-10 < -5");
    }
}