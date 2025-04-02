import java.util.Scanner;

public class SafeInput {

    /**
     * Get a ranged integer value from the user.
     * @param pipe - Scanner instance to read input.
     * @param prompt - Message to prompt the user.
     * @param low - Minimum acceptable value.
     * @param high - Maximum acceptable value.
     * @return Valid integer between low and high.
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInput = 0;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                userInput = pipe.nextInt();
                pipe.nextLine(); // Clear the buffer

                if (userInput >= low && userInput <= high) {
                    isValid = true;
                } else {
                    System.out.println("Error: Value must be between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // Discard invalid input
            }
        } while (!isValid);

        return userInput;
    }

    /**
     * Get any integer value from the user.
     * @param pipe - Scanner instance to read input.
     * @param prompt - Message to prompt the user.
     * @return Valid integer value.
     */
    public static int getInt(Scanner pipe, String prompt) {
        int userInput = 0;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                userInput = pipe.nextInt();
                pipe.nextLine(); // Clear the buffer
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // Discard invalid input
            }
        } while (!isValid);

        return userInput;
    }

    /**
     * Get a double value from the user.
     * @param pipe - Scanner instance to read input.
     * @param prompt - Message to prompt the user.
     * @return Valid double value.
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double userInput = 0;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) {
                userInput = pipe.nextDouble();
                pipe.nextLine(); // Clear the buffer
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a double value.");
                pipe.nextLine(); // Discard invalid input
            }
        } while (!isValid);

        return userInput;
    }

    /**
     * Get a string with non-zero length from the user.
     * @param pipe - Scanner instance to read input.
     * @param prompt - Message to prompt the user.
     * @return Non-empty string.
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = pipe.nextLine().trim();

            if (!userInput.isEmpty()) {
                isValid = true;
            } else {
                System.out.println("Input cannot be empty. Please enter a valid string.");
            }
        } while (!isValid);

        return userInput;
    }

    /**
     * Confirm with a Yes/No response from the user.
     * @param pipe - Scanner instance to read input.
     * @param prompt - Message to prompt the user.
     * @return True if the user agrees (Y), false otherwise.
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean isValid = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();

            if (response.equals("Y")) {
                return true;
            } else if (response.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!isValid);

        return false; // Fallback, should never hit this
    }
}
