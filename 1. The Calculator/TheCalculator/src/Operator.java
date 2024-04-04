// I've created an ENUM of operators with its symbol and a functional interface to calculate.
public enum Operator {
    ADDITION("+", Double::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    // Managing the case of division by 0 by sending an error to the catch.
    DIVISION("/", (a, b) -> {
        if (b!=0) return a/b;
        throw new IllegalArgumentException("Division by zero is not allowed");
    }),
    EXPONENTIATION("^", Math::pow),
    MODULUS("%", (a, b) -> a % b);

    private final String symbol;
    private final CalculationOperation operation;

    Operator(String symbol, CalculationOperation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public double calculate(double a, double b) {
        return operation.operate(a, b);
    }

    // Interface with only one abstract method allowed
    @FunctionalInterface
    interface CalculationOperation {
        double operate(double a, double b);
    }
}