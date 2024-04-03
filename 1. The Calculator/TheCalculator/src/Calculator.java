import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    private static final Scanner sc = new Scanner(System.in);
    private static final double[] userNumbers = new double[2];
    private static Operator userOperator;


    // Run method
    public static void run() {
        while (true) {
            double[] userNumbers = getUserNumbers();
            userOperator = getUserOperator();
            // double result = getResult.apply(userNumbers[0],userNumbers[1]);
            System.out.println(Arrays.toString(userNumbers));
            System.out.println(userOperator);
            // System.out.println(result);
        }
    }

    // Step 1 - Getting numbers from the user
    public static double[] getUserNumbers() {
        userNumbers[0] = getUserNumber("Enter your first number :");
        userNumbers[1] = getUserNumber("Your first Number is " + userNumbers[0] + ", Enter your second number :");
        return userNumbers;
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
    private static Operator getUserOperator() {
        System.out.println("Choose your operator between +,-,*,/,^ or %");
        while (true) {
            String userInput = sc.nextLine();
            for (Operator op : Operator.values()) {
                if (op.getSymbol().equals(userInput)) {
                    return op;
                }
            }
            System.out.println("Invalid Operator, please type +,-,*,/,^ or %");
        }
    }

    // Step 3 - Caluclate the result



    public static void main(String[] args) {
        run();
    }
}
