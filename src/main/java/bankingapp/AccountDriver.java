package bankingapp;

import java.util.Scanner;

public class AccountDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account accounts [] = new Account[10];
        int numAccounts = 0;

        int choice;

        do {
            choice = menu(scanner);
            System.out.println();

            switch(choice) {
                case 1: accounts[numAccounts++] = createAccount(scanner);
                    break;
                case 2: deposit(accounts, numAccounts, scanner );
                    break;
                case 3: withdrawal(accounts, numAccounts, scanner);
                    break;
                case 4: applyInterest(accounts, numAccounts, scanner);
                    break;

                case 5:
                    System.out.println("Have A Nice Day!");
                    break;
                default:
                    System.out.println("Invalid Entry");




            }
            System.out.println();

        } while (choice != 5);

    }

    public static int accountMenu(Scanner scanner) {
        System.out.println("Select Account Type");
        System.out.println("1). Checking Account");
        System.out.println("2). Savings Account");

        int choice;

        do{
            System.out.println("Enter Selection: ");
            choice = scanner.nextInt();

        } while(choice < 1 || choice > 2);

        return choice;

    }

    public static int searchAccount(Account[] accounts, int count, int accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void deposit(Account[] accounts, int count, Scanner scanner) {
        System.out.println("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            System.out.println("Enter Deposit Amount");
            double amount = scanner.nextDouble();
            accounts[index].deposit(amount);
        } else {
            System.out.println("Invalid Entry: ");
        }

    }

    public static void withdrawal(Account[] accounts, int count, Scanner scanner) {
        System.out.println("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if (index >= 0) {
            System.out.println("Enter Withdrawal Amount");
            double amount = scanner.nextDouble();
            accounts[index].withdrawal(amount);
        } else {
            System.out.println("Invalid Entry: ");
        }

    }

    public static void applyInterest(Account[] accounts, int count, Scanner scanner) {
        System.out.println("Please Enter Account Number");
        int accountNumber = scanner.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            if (accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount) accounts[index]).applyInterest();
            }

        } else {
            System.out.println("Invalid Entry: ");
        }
    }


    public static Account createAccount(Scanner scanner) {
        Account account = null;
        int choice = accountMenu(scanner);
        int accountNumber;

        System.out.println("Enter account number: ");
        accountNumber = scanner.nextInt();

        if(choice == 1) {
            System.out.println("Enter Transaction Fee: ");
            double fee = scanner.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else {
            System.out.println("Enter Interest Rate: ");
            double interestRate = scanner.nextDouble();
            account = new SavingsAccount(accountNumber, interestRate);

        }

        return account;
    }

    public static int menu(Scanner scanner) {
        System.out.println("Bank Account Menu");
        System.out.println("1). Create New Account");
        System.out.println("2). Deposit Funds");
        System.out.println("3). Withdraw Funds");
        System.out.println("4). Apply Interest");
        System.out.println("5). Quit");

        int choice;

        do {
            System.out.println("Enter Selection: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 5);

        return choice;

    }
}
