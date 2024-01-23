import static java.lang.Double.isNaN;

public class ScientificCalculator {

// Add Method with exception handling for non-numeric input
    public double add(Object a, Object b) throws Exception {

        if (a instanceof Number && b instanceof Number) {
            double operand1 = ((Number) a).doubleValue();
            double operand2 = ((Number) b).doubleValue();
            return operand1 + operand2;
        }
        errorMessage = "Non-Numeric Values are not allowed";
        throw new Exception(errorMessage);
        // Return a default value or handle it as needed.
    }
// Subtraction method
    public double subtract(double a, double b) {
        return a - b;
    }
// Multiplication Method
    public double multiply(double a, double b) {
        return a * b;
    }
// Division Method
private static String errorMessage;

    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            errorMessage = "Dividend cannot be zero";
            throw new ArithmeticException(errorMessage);
        }
        return a / b;
    }
    public static String getErrorMessage() {
        return errorMessage;
    }

// Square Root Method
    public double squareRoot(double a) { if (a < 0) {
            throw new IllegalArgumentException("Square root of negative numbers is not allowed");
        }
        return Math.sqrt(a);
    }
// Power Method
    public double power(double a, double b) {
        return Math.pow(a, b);
    }
// Sine Function Method
    public double sin(double a) {
        return Math.sin(a);
    }
// Cosine Function Method
    public double cos(double a) {
        return Math.cos(a);
    }
// Tan Function Method
    public double tan(double a) {
        return Math.tan(a);
    }
}