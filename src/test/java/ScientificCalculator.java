import static java.lang.Double.isNaN;

public class ScientificCalculator {

// Add Method with exception handling for non-numeric input
    public double add(Object a, Object b) {
        try {
            if (a instanceof Number && b instanceof Number) {
                double operand1 = ((Number) a).doubleValue();
                double operand2 = ((Number) b).doubleValue();
                return operand1 + operand2;
            } else {
                System.out.println("Invalid input.. Both inputs must be numeric.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return 0.0; // Return a default value or handle it as needed.
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
    public double divide(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Dividend cannot be zero");
            }
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        return 0.0;
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