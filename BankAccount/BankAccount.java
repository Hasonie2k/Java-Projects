public class BankAccount {
    private static int numAccountsCreated = 0;
    private static double totalBalance = 0;

    private double checkingBalance;
    private double savingsBalance;

    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        totalBalance += checkingBalance + savingsBalance;
        numAccountsCreated++;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(String accountType, double amount) {
        if (accountType.equals("checking")) {
            checkingBalance += amount;
        } else if (accountType.equals("savings")) {
            savingsBalance += amount;
        }
        totalBalance += amount;
    }

    public void withdraw(String accountType, double amount) {
        if (accountType.equals("checking") && checkingBalance >= amount) {
            checkingBalance -= amount;
            totalBalance -= amount;
        } else if (accountType.equals("savings") && savingsBalance >= amount) {
            savingsBalance -= amount;
            totalBalance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    public double getTotalBalance() {
        return totalBalance;
    }
    public static int getNumAccountsCreated() {
        return numAccountsCreated;
    }
}