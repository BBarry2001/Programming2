package ModuleOne;

public class TestBankingSystem {
    public static void main(String[] args) {
        // Create a BankAccount instance
        BankAccount bankAccount = new BankAccount("John", "Doe", 12345);
        bankAccount.deposit(1000);
        bankAccount.withdrawal(500);
        bankAccount.accountSummary();

        // Create a CheckingAccount instance
        CheckingAccount checkingAccount = new CheckingAccount("Jane", "Doe", 67890, 1.5);
        checkingAccount.deposit(2000);
        checkingAccount.withdrawal(2500); // This should trigger an overdraft fee
        checkingAccount.displayAccount();
    }
}

