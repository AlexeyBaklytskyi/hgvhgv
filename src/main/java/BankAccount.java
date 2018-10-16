public class BankAccount {

    private int accountNumber;
    private double balance;
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double credit(double creditAmount) {
        balance = balance + creditAmount;
        return balance;
    }
    public double debit(double debitAmount) {
            if (balance >= debitAmount) {
            balance = balance - debitAmount;
              } else System.out.println("Сумма снятия больше чем остаток на счету!");
        return balance;
    }
}
