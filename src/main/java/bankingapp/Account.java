package bankingapp;

public abstract class Account {
    private int accountNumber;

    protected double balance;

    public Account() {};

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public abstract void deposit(double amt);

    public abstract void withdrawal(double amt);
}
