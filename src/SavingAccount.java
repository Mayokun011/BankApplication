// Savings Account child class
// Has an interest rate
// A method to apply interest
public class SavingAccount extends Account {

private double interestRate;


    public SavingAccount() {
        super ();
    }
    /** Parameter constructor to initialize SavingsAccount
     * with a custom Account number and interest rate.
     */
    public SavingAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest(){
        return balance * interestRate;
    }

    public void applyInterest(){
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);
        deposit (interest);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0){
            balance += amount;
            System.out.printf("Amount: %.2f Deposited%n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);
        } else {
            System.out.println("A negative amount can not be deposited");
        }
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0){
            // Check Sufficient Balance
            if ((amount) <= balance){
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is: %.2f%n", balance);

            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }
}
