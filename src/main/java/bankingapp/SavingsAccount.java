package bankingapp;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;


    }


    @Override
    public void deposit(double amt) {
        if ( amt > 0 ) {
            balance += amt;
            System.out.println("Deposit of " + amt + " successful" );
            System.out.println("Current Balance: $" + balance);
        } else {
            System.out.println("Invalid amount");

        }

    }

    @Override
    public void withdrawal(double amt) {

        if (amt > 0) {
            if(amt <= balance) {
                System.out.println("Your withdrawal: $" + amt);
                balance -= amt;
                System.out.println("Account balance after withdrawal with transaction fee applied: $" + balance );
            }

        } else {
            System.out.println("Invalid amount selected");
        }

    }

    public double calculateInterestRate() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calculateInterestRate();
        System.out.println("you earned a tuppence: $" + interest);
        deposit(interest);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


}
