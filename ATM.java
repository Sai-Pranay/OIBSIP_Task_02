import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static final String USER_ID = "pranay";
    private static String USER_PIN = "2002";
    private static double BALANCE = 10000;

    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.println("Welcome to the ATM.");
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("PIN: ");
        String userPin = scanner.nextLine();
        if (!userId.equals(USER_ID) || !userPin.equals(USER_PIN)) {
            System.out.println("Invalid user ID or PIN. Exiting...");
            return;
        }

        // Main menu
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Transactions history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's user ID: ");
                    String recipientId = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    transfer(recipientId, transferAmount);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void viewTransactionHistory() {
        System.out.println("Transaction history:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void withdraw(double amount) {
        if (amount > BALANCE) {
            System.out.println("Insufficient funds.");
        } else {
            BALANCE -= amount;
            transactionHistory.add("Withdraw: " + amount);
            System.out.println("Withdrawal successful. Current balance: " + BALANCE);
        }
    }

    private static void deposit(double amount) {
        BALANCE += amount;
        transactionHistory.add("Deposit: " + amount);
        System.out.println("Deposit successful. Current balance: " + BALANCE);
    }

    private static void transfer(String recipientId, double amount) {
        if (amount > BALANCE) {
            System.out.println("Insufficient funds.");
        } else {
            BALANCE -= amount;
            transactionHistory.add("Transfer to " + recipientId + ": " + amount);
            System.out.println("Transfer successful. Current balance: " + BALANCE);
        }
    }
}
