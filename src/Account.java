public abstract class Account {

    private int accountNumber;
    protected double balance;

    public Account () {

    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
     /** Function is deposit funds into the account as long
      * as the account parameter is > 0
      * @param amount value to be deposited
      *
      * Apply transaction for the Checking Account

   **/
    public abstract void deposit (double amount);

    /**Function to withdraw funds from the account as long
     * as the account to withdraw must be > 0
     * Amount to withdraw must be <= balance
     * @param amount value to be withdrawn
     */
    public abstract void withdraw (double amount);
}
