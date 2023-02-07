import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private long accountNumber;
    private static int numAccounts;
    private static double amountMoney;
    

    public BankAccount(){
      this.checkingBalance = 0;
      this.savingBalance = 0;
      this.accountNumber = generateAccountNum();
      numAccounts ++;
    }

    public BankAccount(double checkingBalance, double savingBalance){
      this.checkingBalance = checkingBalance;
      this.savingBalance = savingBalance;
      this.accountNumber = generateAccountNum();
      numAccounts ++;
      amountMoney += savingBalance;
      amountMoney += checkingBalance;
    }

// Create a getter method for the user's checking account balance.
    public double getUserChecking(){
      return this.checkingBalance;
    }

    // Create a getter method for the user's saving account balance.
    public double getUserSaving(){
      return this.savingBalance;
    }


// Create a method that will allow a user to deposit money into 
// either the checking or saving, be sure to add to total amount stored.

    public void deposit(double amount){
      if(amount < 0 ){
        System.out.println("Cannot deposit negative amount.");
      }
      else{
        this.checkingBalance += amount;
        amountMoney += amount;
      }
    }
    // Create a method to withdraw money from one balance.
    // Do not allow them to withdraw money if there are insufficient funds.
    public void withdraw(double amount){
      if(amount > this.checkingBalance){
        System.out.println("Insufficient Balance.");
      }
      else{
        this.checkingBalance -= amount;
        amountMoney -= amount;
      }
    }

// Create a method to see the total money from the checking and saving.
    public static double showAmount(){
      return amountMoney;
    }

    public static int showNumAccounts(){
      return numAccounts;
    }


    private long generateAccountNum(){
      long BankAccountNum = new Random().nextInt(300000000)+ 4200000000L;
      return BankAccountNum;
    }
    public long getAccountNum(){
      return this.accountNumber;
    }
}