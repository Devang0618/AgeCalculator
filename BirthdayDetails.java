import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.DayOfWeek;
import java.util.Scanner;

public class BirthdayDetails {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Get the user's date of birth
        System.out.print("Enter your date of birth (yyyy-MM-dd): ");
        String dobInput = scanner.nextLine();

        try {
            // Parse the date of birth
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dob = LocalDate.parse(dobInput, formatter);

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Ensure the date of birth is not in the future
            if (dob.isAfter(currentDate)) {
                System.out.println("Date of birth cannot be in the future!");
            } else {
                // Calculate the age
                Period age = Period.between(dob, currentDate);

                // Find the day of the week the user was born
                DayOfWeek dayBorn = dob.getDayOfWeek();

                // Calculate the upcoming birthday
                LocalDate nextBirthday = dob.withYear(currentDate.getYear());
                if (nextBirthday.isBefore(currentDate) || nextBirthday.isEqual(currentDate)) {
                    nextBirthday = nextBirthday.plusYears(1);
                }
                DayOfWeek nextBirthdayDay = nextBirthday.getDayOfWeek();

                // Display the results
                System.out.println("\nHello, " + name + "!");
                System.out.println("You are " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
                System.out.println("You were born on a " + dayBorn + ".");
                System.out.println("Your upcoming birthday will be on a " + nextBirthdayDay + ".");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }

        // Close the scanner
        scanner.close();
    }
}
