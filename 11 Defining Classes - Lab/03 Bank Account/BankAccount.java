package BankAccount;

public class BankAccount {
    private static int id;
    private double balance = 0;
    private static double interestRate = 0.02;

    public BankAccount() {
        id++;
        System.out.println("Account ID" + id + " created");
    }

    public int getId() {
        return id;
    }

    double getInterest(int id, int years) {
        return BankAccount.interestRate*years*this.balance;
    }

    static void setInterest(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit (double amount, int id){
        this.balance += amount;
        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
    }
}
