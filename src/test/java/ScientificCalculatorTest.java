import org.testng.Assert;
import org.testng.annotations.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScientificCalculatorTest {

    private ScientificCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new ScientificCalculator();
    }
// Test Addition Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testAddition(double num1, double num2) {
        double result = calculator.add(num1, num2);
        Assert.assertEquals(result, num1 + num2);
        System.out.println(result);
    }
// Test Subtraction Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testSubtraction(double num1, double num2) {
        double result = calculator.subtract(num1, num2);
        Assert.assertEquals(result, num1 - num2);
        System.out.println(result);
    }
// Test Multiplication Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testMultiplication(double num1, double num2) {
        double result = calculator.multiply(num1, num2);
        Assert.assertEquals(result, num1 * num2);
        System.out.println(result);
    }
// Test Division Function
    @Test(groups = "basicOperations", dataProvider = "csvTestData")
    public void testDivision(double num1, double num2) {
        double result = calculator.divide(num1, num2);
        Assert.assertEquals(result, num1 / num2);}


// Test Square Root function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData")
    public void testSquareRoot(double num1, double num2) {

            double result = calculator.squareRoot(num1+num2);
            Assert.assertEquals(result, Math.sqrt(num1+num2));

    }
// Test Power Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData")
    public void testPower(double base, double exponent) {
        double result = calculator.power(base, exponent);
        Assert.assertEquals(result, Math.pow(base, exponent));
    }
// Test Sine Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData")
    public void testSinFunction(double angle1, double angle2) {
        double result = calculator.sin(Math.abs(angle1 - angle2));
        Assert.assertEquals(result, Math.sin(Math.abs(angle1 - angle2)));
    }
// Test Cosine Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData")
    public void testCosFunction(double angle1, double angle2) {
        double result = calculator.cos(Math.abs(angle1 - angle2));
        Assert.assertEquals(result, Math.cos(Math.abs(angle1 - angle2)));
    }
// Test Tan Function
    @Test(groups = "advancedOperations", dataProvider = "csvTestData")
    public void testTanFunction(double angle1, double angle2) {
        double result = calculator.tan(Math.abs(angle1 - angle2));
        Assert.assertEquals(result, Math.tan(Math.abs(angle1 - angle2)));
    }
// Test invalid input for Addition
    @Test(groups = "basicOperations")
    public void testInvalidAddition() {
  double result= calculator.add('c', 10);


    }
// Test invalid input for Divide method
    @Test(groups = "basicOperations")
    public void testInvalidDivisionByZero() {
        calculator.divide(5, 0);
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
}
