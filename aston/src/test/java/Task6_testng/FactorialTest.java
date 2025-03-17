package Task6_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(Factorial.calculateFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(Factorial.calculateFactorial(1), 1);
    }

    @Test
    public void testFactorialOfFive() {
        Assert.assertEquals(Factorial.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "n! for n < 0 is impossible")
    public void testFactorialOfNegativeNumber() {
        Factorial.calculateFactorial(-1);
    }
}
