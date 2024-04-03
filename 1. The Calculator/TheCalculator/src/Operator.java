import java.util.function.Function;

// I've created an ENUM of operators with its functional interface
public enum Operator {
    ADDITION("+", Double::sum),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b),
    EXPONENTIATION("^", (a, b) -> a ^ b),
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

    @FunctionalInterface
    interface CalculationOperation {
        double operate(double a, double b);
    }
}