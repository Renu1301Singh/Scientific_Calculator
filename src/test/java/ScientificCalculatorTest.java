import org.testng.Assert;
import org.testng.annotations.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ScientificCalculatorTest {

    private ScientificCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new ScientificCalculator();
    }
// Test Addition Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testAddition(double num1, double num2) throws Exception {
        double result = ScientificCalculator.add(num1, num2);
        assertEquals(result, num1 + num2);
        System.out.println(result);
    }
// Test Subtraction Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testSubtraction(double num1, double num2) {
        double result = ScientificCalculator.subtract(num1, num2);
        assertEquals(result, num1 - num2);
        System.out.println(result);
    }
// Test Multiplication Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testMultiplication(double num1, double num2) {
        double result = ScientificCalculator.multiply(num1, num2);
        assertEquals(result, num1 * num2);
        System.out.println(result);
    }
// Test Division Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testDivision(double num1, double num2) {
        double result = ScientificCalculator.divide(num1, num2);
        assertEquals(result, num1 / num2);}


// Test Square Root function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData2")
    public void testSquareRoot(double num1) {

            double result = ScientificCalculator.squareRoot(num1);
            assertEquals(result, Math.sqrt(num1));

    }
// Test Power Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData")
    public void testPower(double base, double exponent) {
        double result = ScientificCalculator.power(base, exponent);
        assertEquals(result, Math.pow(base, exponent));
    }
// Test Sine Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData2")
    public void testSinFunction(double angle) {
        double result = ScientificCalculator.sin(angle );
        assertEquals(result, Math.sin(angle));
    }
// Test Cosine Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData2")
    public void testCosFunction(double angle) {
        double result = ScientificCalculator.cos(angle );
        assertEquals(result, Math.cos(angle));
    }
// Test Tan Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData2")
    public void testTanFunction(double angle) {
        double result = ScientificCalculator.tan(angle);
        assertEquals(result, Math.tan(angle));
    }
// Test invalid input for Addition
    @Test(groups = "basicOperations")
    public void testInvalidAddition() {
        try {
            ScientificCalculator.add('c', 5);
            Assert.fail("Exception should have been thrown");
            System.out.println("1");
        } catch (Exception e) {
            // Check if the exception message matches the expected value
            String expectedMessage = "Non-Numeric Values are not allowed";
            String actualMessage = e.getMessage();
            System.out.println(actualMessage);
            Assert.assertEquals(actualMessage, expectedMessage, "Exception message does not match.");
        }
    }
// Test invalid input for Divide method
@Test(groups = "basicOperations")
public void testInvalidDivisionByZero() {
    try {
        ScientificCalculator.divide(5, 0);
        Assert.fail("Exception should have been thrown");
        System.out.println("1");
    } catch (Exception e) {
        // Check if the exception message matches the expected value
        String expectedMessage = "Dividend cannot be zero";
        String actualMessage = e.getMessage();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Exception message does not match.");
    }
}

// Method to collect data from CSV
    @DataProvider(name = "csvTestData")
    public Object[][] csvTestDataDataProvider() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("testData.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            double num1 = Double.parseDouble(values[0]);
            double num2 = Double.parseDouble(values[1]);
            testData.add(new Object[]{num1, num2});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
    @DataProvider(name = "csvTestData2")
    public Object[][] csvTestData2DataProvider() throws IOException {
        List<Object[]> testData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("testData2.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            double num1 = Double.parseDouble(values[0]);
            testData.add(new Object[]{num1});
        }
        reader.close();
        return testData.toArray(new Object[0][0]);
    }
}
