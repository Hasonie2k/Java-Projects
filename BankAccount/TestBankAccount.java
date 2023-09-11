public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000, 2000);

        System.out.println("Checking balance: " + account.getCheckingBalance());
        System.out.println("Savings balance: " + account.getSavingsBalance());

        account.deposit("checking", 699);
        account.deposit("savings", 2020);
        account.withdraw("checking", 120);
        account.withdraw("savings", 420);

        System.out.println("Total balance: " + account.getTotalBalance());

        System.out.println("Number of accounts created: " + BankAccount.getNumAccountsCreated());
    }
}
