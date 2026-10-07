import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.Scanner;

public class Main {

    // Rating validation
    static int getValidRating(Scanner scanner) {

        while (true) {

            System.out.print("Rating (1-5): ");
            int rating = scanner.nextInt();

            if (rating >= 1 && rating <= 5) {
                return rating;
            }

            System.out.println("Invalid rating! Please enter a rating between 1 and 5.");
        }
    }

    // Analytics
    static void showAnalytics() {

        try {

            Connection connection = DatabaseConnection.getConnection();

            String breakfastSQL =
                    "SELECT AVG(rating), COUNT(rating) FROM breakfast_reviews";

            String lunchSQL =
                    "SELECT AVG(rating), COUNT(rating) FROM lunch_reviews";

            String dinnerSQL =
                    "SELECT AVG(rating), COUNT(rating) FROM dinner_reviews";

            PreparedStatement breakfastStatement =
                    connection.prepareStatement(breakfastSQL);

            PreparedStatement lunchStatement =
                    connection.prepareStatement(lunchSQL);

            PreparedStatement dinnerStatement =
                    connection.prepareStatement(dinnerSQL);

            var breakfastResult = breakfastStatement.executeQuery();
            var lunchResult = lunchStatement.executeQuery();
            var dinnerResult = dinnerStatement.executeQuery();

            breakfastResult.next();
            lunchResult.next();
            dinnerResult.next();

            double breakfastAverage = breakfastResult.getDouble(1);
            int breakfastCount = breakfastResult.getInt(2);

            double lunchAverage = lunchResult.getDouble(1);
            int lunchCount = lunchResult.getInt(2);

            double dinnerAverage = dinnerResult.getDouble(1);
            int dinnerCount = dinnerResult.getInt(2);

            System.out.println("\n===== HOSTEL FOOD ANALYTICS =====");

            System.out.printf(
                    "Breakfast: %.2f / 5  (%d ratings)%n",
                    breakfastAverage, breakfastCount
            );

            System.out.printf(
                    "Lunch: %.2f / 5  (%d ratings)%n",
                    lunchAverage, lunchCount
            );

            System.out.printf(
                    "Dinner: %.2f / 5  (%d ratings)%n",
                    dinnerAverage, dinnerCount
            );

            // Find best and worst meal

            String bestMeal;
            String worstMeal;

            double highest = Math.max(
                    breakfastAverage,
                    Math.max(lunchAverage, dinnerAverage)
            );

            double lowest = Math.min(
                    breakfastAverage,
                    Math.min(lunchAverage, dinnerAverage)
            );

            if (highest == breakfastAverage) {
                bestMeal = "Breakfast";
            }
            else if (highest == lunchAverage) {
                bestMeal = "Lunch";
            }
            else {
                bestMeal = "Dinner";
            }

            if (lowest == breakfastAverage) {
                worstMeal = "Breakfast";
            }
            else if (lowest == lunchAverage) {
                worstMeal = "Lunch";
            }
            else {
                worstMeal = "Dinner";
            }

            System.out.println("\nBest Meal: " + bestMeal);
            System.out.println("Worst Meal: " + worstMeal);

            breakfastStatement.close();
            lunchStatement.close();
            dinnerStatement.close();
            connection.close();

        } catch (Exception e) {

            System.out.println("Analytics failed!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== HOSTEL PULSE =====");
        System.out.println("1. Food Review");
        System.out.println("2. Analytics");
        System.out.println("3. Exit");

        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.println("\n===== FOOD REVIEW =====");
            System.out.println("1. Breakfast");
            System.out.println("2. Lunch");
            System.out.println("3. Dinner");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int mealChoice = scanner.nextInt();

            // Breakfast
            if (mealChoice == 1) {

                scanner.nextLine();

                System.out.print("Registration No: ");
                String regNo = scanner.nextLine();

                int rating = getValidRating(scanner);

                scanner.nextLine();

                System.out.print("Review: ");
                String review = scanner.nextLine();

                try {

                    Connection connection =
                            DatabaseConnection.getConnection();

                    String sql = "INSERT INTO breakfast_reviews " +
                                 "(reg_no, rating, review, review_date) " +
                                 "VALUES (?, ?, ?, ?)";

                    PreparedStatement statement =
                            connection.prepareStatement(sql);

                    statement.setString(1, regNo);
                    statement.setInt(2, rating);
                    statement.setString(3, review);
                    statement.setDate(4,
                            new Date(System.currentTimeMillis()));

                    statement.executeUpdate();

                    System.out.println("\nReview saved successfully!");

                    statement.close();
                    connection.close();

                } catch (Exception e) {

                    System.out.println("Failed to save review!");
                    e.printStackTrace();
                }
            }

            // Lunch
            else if (mealChoice == 2) {

                scanner.nextLine();

                System.out.print("Registration No: ");
                String regNo = scanner.nextLine();

                int rating = getValidRating(scanner);

                scanner.nextLine();

                System.out.print("Review: ");
                String review = scanner.nextLine();

                try {

                    Connection connection =
                            DatabaseConnection.getConnection();

                    String sql = "INSERT INTO lunch_reviews " +
                                 "(reg_no, rating, review, review_date) " +
                                 "VALUES (?, ?, ?, ?)";

                    PreparedStatement statement =
                            connection.prepareStatement(sql);

                    statement.setString(1, regNo);
                    statement.setInt(2, rating);
                    statement.setString(3, review);
                    statement.setDate(4,
                            new Date(System.currentTimeMillis()));

                    statement.executeUpdate();

                    System.out.println("\nReview saved successfully!");

                    statement.close();
                    connection.close();

                } catch (Exception e) {

                    System.out.println("Failed to save review!");
                    e.printStackTrace();
                }
            }

            // Dinner
            else if (mealChoice == 3) {

                scanner.nextLine();

                System.out.print("Registration No: ");
                String regNo = scanner.nextLine();

                int rating = getValidRating(scanner);

                scanner.nextLine();

                System.out.print("Review: ");
                String review = scanner.nextLine();

                try {

                    Connection connection =
                            DatabaseConnection.getConnection();

                    String sql = "INSERT INTO dinner_reviews " +
                                 "(reg_no, rating, review, review_date) " +
                                 "VALUES (?, ?, ?, ?)";

                    PreparedStatement statement =
                            connection.prepareStatement(sql);

                    statement.setString(1, regNo);
                    statement.setInt(2, rating);
                    statement.setString(3, review);
                    statement.setDate(4,
                            new Date(System.currentTimeMillis()));

                    statement.executeUpdate();

                    System.out.println("\nReview saved successfully!");

                    statement.close();
                    connection.close();

                } catch (Exception e) {

                    System.out.println("Failed to save review!");
                    e.printStackTrace();
                }
            }

            else {
                System.out.println("Going back...");
            }

        }

        else if (choice == 2) {

            showAnalytics();

        }

        else {

            System.out.println("Exiting HostelPulse...");

        }

        scanner.close();
    }
}