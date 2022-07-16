package bankingapp;

public class CheckingAccount extends Account {

    private static double FEE = 2.5;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;

    }


    @Override
    public void deposit(double amt) {
        if ( amt > 0 ) {
            balance += amt;
            System.out.println("Deposit of " + amt + " successful" );


            balance -= FEE;
            System.out.println("This bank is trash and we charge for deposits. A fee of $" + FEE + " has been applied");
            System.out.println("Current Balance: $" + balance);
        } else {
            System.out.println("Invalid amount");

        }

    }

    @Override
    public void withdrawal(double amt) {
        double feebal = amt + FEE;
        if (amt > 0) {
            if(feebal <= balance) {
                System.out.println("Your withdrawal: $" + amt);
                balance -= feebal;
                System.out.println("Account balance after withdrawal and generous transaction fee applied: $" + balance );
            }

        } else {
            System.out.println("Invalid amount selected");
        }

    }
}
