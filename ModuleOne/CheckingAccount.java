package ModuleOne;
public class CheckingAccount extends BankAccount {
    private double interestRate;
    private final double OVERDRAFT_FEE = 30.0;

    // Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    // Overdraft withdrawal method
    @Override
    public void withdrawal(double amount) {
        if (getBalance() < amount) {
            super.withdrawal(amount + OVERDRAFT_FEE);
            System.out.println("Overdraft! A fee of $" + OVERDRAFT_FEE + " has been charged.");
        } else {
            super.withdrawal(amount);
        }
    }

    // Display account information
    public void displayAccount() {
        super.accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
