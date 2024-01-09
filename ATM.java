import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private static double balance = 0;
    private static int atmpin=12345;
    private static ArrayList<String> transactions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit=false;
        System.out.println("\nWelcome to ATM");
        System.out.println("Enter pin");
        int pin=scanner.nextInt();

        if (pin==atmpin){
        while (!quit) {
            System.err.println("\nPlease select the operation you want to carry out");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TransactionsHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    quit=true;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
    else{
        System.out.println("\nWrong pin.Please try again");
    }
        System.out.println("\nThankyou for using ATM. Please visit again");
    }

    private static void TransactionsHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdraw() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount < balance) {
            balance -= amount;
            transactions.add("Withdrawal: -" + amount);
            System.out.println("\nWithdrawal successful. Please collect your cash.");
            System.out.println("\nAvailable balance:"+balance);
        } else {
            System.out.println("\nInsufficient balance.");
        }
    }

    private static void deposit() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        int amount = scanner.nextInt();

        balance += amount;
        transactions.add("Deposit "+amount);
        System.out.println("\nDeposit successful. New balance: " + balance);
    }

    private static void transfer() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("\nEnter payee account number: ");
        String payeeAccount = scanner.next();
        System.out.print("Enter transfer amount: ");
        double transferAmount = scanner.nextDouble();

        if (transferAmount > balance) {
            System.out.println("Balance not sufficient to transfer "+transferAmount);
        } else {
            balance -= transferAmount;
            transactions.add("Transfer to " + payeeAccount + ": -" + transferAmount);
            System.out.println("Transfer successful to "+payeeAccount+" New balance: " + balance);
        }
    }
}