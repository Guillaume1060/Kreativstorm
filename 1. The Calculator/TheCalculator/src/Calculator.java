import java.util.Scanner;

public class Calculator {
    private static final Scanner sc = new Scanner(System.in);
    private static final double[] userNumbers = new double[2];
    private static Operator operator;

    // Run method
    public static void run() {
        boolean running = true;
        while (running) {
            try {
                getUserNumbers();
                getUserOperator();
                displayResult();
                running = askToContinue();
            } catch (IllegalArgumentException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        System.out.println("Good bye !");
    }

    // Step 1 - Getting numbers from the user
    public static void getUserNumbers() {
        userNumbers[0] = getUserNumber("Enter your first number :");
        userNumbers[1] = getUserNumber("Your first Number is " + userNumbers[0] + ", Enter your second number :");
    }

    public static double getUserNumber(String message) {
        while (true) {
            System.out.println(message);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("It must be a number");
            }
        }
    }

    // Step 2 - Getting a valid operator from the user
    public static void getUserOperator() {
        System.out.println("Choose your operator between +,-,*,/,^ or %");
        while (true) {
            String userInput = sc.nextLine();
            for (Operator op : Operator.values()) {
                if (op.getSymbol().equals(userInput)) {
                    operator = op;
                    return;
                }
            }
            System.out.println("Invalid Operator, please type +,-,*,/,^ or %");
        }
    }

    // Step 3 - Display result
    private static void displayResult() {
        double result = operator.calculate(userNumbers[0], userNumbers[1]);
        System.out.printf("%s %s %s = %s", userNumbers[0], operator.getSymbol(), userNumbers[1], result);
        System.out.println();
    }

    // Step 4 - Ask user to continue or not
    private static boolean askToContinue() {
        while (true) {
            try {
                System.out.println("Do you want to continue ? (type Y/N)");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("y")) return true;
                if (choice.equalsIgnoreCase("n")) return false;
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect, please type 'Y' or 'N'");
            }
        }
    }

    public static void main(String[] args) {
        run();
    }
}
