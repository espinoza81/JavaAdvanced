package BankAccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String command;
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        String error = "Account does not exist";

        while (!"End".equals(command = console.nextLine())) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int id = bankAccount.getId();
                    bankAccounts.put(id, bankAccount);
                    break;
                case "Deposit":
                    id = Integer.parseInt(token[1]);
                    double amount = Double.parseDouble(token[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount, id);
                    } else {
                        System.out.println(error);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(token[1]);
                    BankAccount.setInterest(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(token[1]);
                    int years = Integer.parseInt(token[2]);
                    if (bankAccounts.containsKey(id)) {
                        System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(id, years));
                    } else {
                        System.out.println(error);
                    }
                    break;
            }
        }
    }
}
