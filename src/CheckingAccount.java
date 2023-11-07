public class CheckingAccount extends Account {

    private static double FEE = 2.5;

    public CheckingAccount() {
        super ();
    }

    /** Parameter constructor to initialize CheckingAccount
     * with a custom Account number and a customer transaction fee.
     */
    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0){
            balance += amount;
            System.out.printf("Amount %.2f Deposited%n", amount);

            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n", FEE);
            System.out.printf("Current Balance is: %.2f%n", balance);
        } else {
            System.out.println("A negative amount can not be deposited");
        }


    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0){
            // Check Sufficient Balance
            if ((amount + FEE) <= balance){
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current Balance is %.2f%n", balance);


            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }

    }
}
