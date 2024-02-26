import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: Rs. " + balance);
    }
}

public class ATM_MACHINE {
    private Map<String, Account> accounts;

    public ATM_MACHINE() {
        accounts = new HashMap<>();
        // Add some dummy accounts for testing
        accounts.put("935866", new Account("935866", "7890", 0.0));
        accounts.put("789012", new Account("789012", "5678", 0.0));
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("******************");
        System.out.println("Welcome to the ATM");
        System.out.println("******************");
        System.out.println();
        while (true) {
            System.out.print("Enter Account Number: ");
            String accountNumber = sc.nextLine();
            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            Account account = accounts.get(accountNumber);

            if (account != null && account.getPin().equals(pin)) {
                System.out.println("Login successful");
                while (true) {
                    System.out.println("\nOptions:");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");
                    System.out.print("Select an option: ");

                    int option = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    switch (option) {
                        case 1:
                            account.displayBalance();
                            break;
                        case 2:
                            System.out.print("Enter Deposit Amount: Rs. ");
                            double depositAmount = sc.nextDouble();
                            sc.nextLine(); // Consume newline
                            account.deposit(depositAmount);
                            System.out.println("Amount has been successfully deposited");
                            break;
                        case 3:
                            System.out.print("Enter withdrawal amount: Rs. ");
                            double withdrawalAmount = sc.nextDouble();
                            sc.nextLine(); // Consume newline
                            account.withdraw(withdrawalAmount);
                            System.out.println("Withdrawal successful\nPlease collect your cash");
                            break;
                        case 4:
                            System.out.println("Thank you for using the ATM\nVisit Agian!!");
                            return;
                        default:
                            System.out.println("Invalid option");
                    }
                }
            } else {
                System.out.println("Invalid account number or PIN. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM_MACHINE atm = new ATM_MACHINE();
        atm.run();
    }
}