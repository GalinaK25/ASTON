package Task6_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

    public class TriangleAreaTest {

        @Test
        public void testValidTriangleArea() {
            Assert.assertEquals(TriangleArea.calculateTriangleArea(5.0, 5.0), 12.5, 0.0001);
        }

        @Test(expectedExceptions = IllegalArgumentException.class,
                expectedExceptionsMessageRegExp = "Base and height should be > 0")
        public void testNegativeBase() {
            TriangleArea.calculateTriangleArea(-5.0, 10.0);
        }

        @Test(expectedExceptions = IllegalArgumentException.class,
                expectedExceptionsMessageRegExp = "Base and height should be > 0")
        public void testNegativeHeight() {
            TriangleArea.calculateTriangleArea(5.0, -10.0);
        }

        @Test(expectedExceptions = IllegalArgumentException.class,
                expectedExceptionsMessageRegExp = "Base and height should be > 0")
        public void testZeroBase() {
            TriangleArea.calculateTriangleArea(0.0, 10.0);
        }
    }