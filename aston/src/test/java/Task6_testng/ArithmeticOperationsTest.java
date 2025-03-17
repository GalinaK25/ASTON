package Task6_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {

    @Test
    public void testAddition() {
        Assert.assertEquals(ArithmeticOperations.add(1, 5), 6);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(ArithmeticOperations.subtract(1, 5), -4);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(ArithmeticOperations.multiply(1, 5), 5);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(ArithmeticOperations.divide(1, 5), 0.2, 0.0001);
    }

    @Test(expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "/0 is impossible")
    public void testDivisionByZero() {
        ArithmeticOperations.divide(1, 0);
    }
}