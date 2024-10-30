import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String promptString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine().trim();
    }

    public static LocalDate promptDate(String message) {
        while (true) {
            System.out.print(message + " (YYYY-MM-DD): ");
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    public static int promptInt(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}
