package calculator;

public class OurCalculator {
    public int add(int a, int b) {
        try {
            return Math.addExact(a, b);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Integer overflow");
        }
    }

    public int subtract(int a, int b) {
        try {
            return Math.addExact(a, -b);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Integer overflow");
        }
    }

    public int multiply(int a, int b) {
        try{
            return Math.multiplyExact(a, b);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Integer overflow");
        }
    }

    public float divide(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return (float) a / b;
        }
        catch (ArithmeticException e) {
            throw new ArithmeticException("Division by zero");
        }
    }

    public float power(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException("Indeterminate form");
        }
        return (float) Math.pow(a, b);
    }

    public float calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            case "^" -> power(a, b);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public static void main(String[] args) {
        OurCalculator calculator = new OurCalculator();
        int a = 6;
        int b = 2;
        String operator = "*";
        float result = calculator.calculate(a, b, operator);
        System.out.println(result);
    }

}
