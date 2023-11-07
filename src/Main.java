import java.util.Scanner;

public  class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        // Create Array for Accounts
        Account accounts[] = new Account[10];
        int numAccounts = 0;

        int choice;

        do {
            choice = menu(keyboard);
            System.out.println();
            if (choice == 1) {
                accounts[numAccounts++] = createAccount(keyboard);
            } else if (choice == 2) {
                doDeposit(accounts, numAccounts, keyboard);
            } else if (choice == 3) {
                doWithdraw(accounts, numAccounts, keyboard);
            } else if (choice == 4) {
                applyInterest(accounts, numAccounts, keyboard);
            } else {
                System.out.println("GOODBYE!");
            }
            System.out.println();

        } while (choice != 5);
    }
    /**
     * Account choice
     * @param keyboard
     * @return  choice
     */

    public static int accountMenu(Scanner keyboard){
        System.out.println("Select Account Type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do{
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 2);
        return choice;
    }

    public static int searchAccount(Account accounts [], int count, int accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber){
                return 1;
        }
    }
        return -1;
    }

    /**
     * Funtion to perform Deposit on selected account
     * @param accounts
     * @param count
     */
    public static void doDeposit(Account accounts [], int count, Scanner keyboard) {
        //Get Account NUMBER
        System.out.print("\nplease enter account number: ");
        int accountNumber = keyboard.nextInt();

        // Search for account
        int index = searchAccount(accounts, count, accountNumber);
        if (index >= 0) {
            System.out.print("Please enter Deposit Amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }
        public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {
            //Get Account NUMBER
            System.out.print("\nPlease enter account number: ");
            int accountNumber = keyboard.nextInt();

            // Search for account
            int index = searchAccount(accounts, count, accountNumber);
            if (index >= 0) {
                System.out.println("Please enter Withdraw Amount: ");
                double amount = keyboard.nextDouble();

                accounts[index].withdraw(amount);
            } else {
                System.out.println("No account exist with AccountNumber: " + accountNumber);
            }
        }
            public static void applyInterest (Account accounts [],int count, Scanner keyboard) {
                //Get Account NUMBER
                System.out.println("\nPlease enter account number: ");
                int accountNumber = keyboard.nextInt();

                // Search for account
                int index = searchAccount(accounts, count, accountNumber);
                if (index >= 0) {
                    if (accounts[index] instanceof SavingAccount) {
                        ((SavingAccount) accounts[index]).applyInterest();
                    }
                }

                // System.out.println("Please enter  Amount: ");
                //  double amount = keyboard.nextDouble();

                // accounts[index].applyInterest();
                else {
                    System.out.println("No account exist with AccountNumber: " + accountNumber);
                }
            }
    /**
     * Function to create a new Account
     */
    public static Account createAccount (Scanner keyboard){

        Account accounts = null;
        int choice = accountMenu(keyboard);
        int accountNumber;
        System.out.println("Enter Account Number: ");
        accountNumber = keyboard.nextInt();
        if (choice == 1) {
            System.out.println("Enter Transaction Fee: ");
            double fee = keyboard.nextDouble();
            accounts = new CheckingAccount(accountNumber, fee);
        } else {
            System.out.println("Please enter Interest Rate");
            double ir = keyboard.nextDouble();

            accounts = new SavingAccount(accountNumber, ir);
        }
        return accounts;
    }
    /**
     * Menu to display options to get the user selection
     * @param keyboard
     * @return choice
     */
    public static int menu(Scanner keyboard) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4.Apply Interest");
        System.out.println("5. Quit");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 5);

        return choice;

    }
}