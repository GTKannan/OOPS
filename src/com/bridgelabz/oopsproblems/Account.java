package com.bridgelabz.oopsproblems;

public class Account {

    private double balance;

    // Constructor
    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance can't be negative. Setting to 0.");
            this.balance = 0;
        }
    }

    // Method to return current balance
    public double getBalance() {
        return balance;
    }

    // Method to debit (withdraw) amount from account
    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else if (amount < 0) {
            System.out.println("Cannot debit a negative amount.");
        } else {
            balance -= amount;
            System.out.println("Debited ₹" + amount + ". New balance: ₹" + balance);
        }
    }
}

class AccountTest {
    public static void main(String[] args) {
        // Create account with initial balance
        Account myAccount = new Account(2000.00);

        System.out.println("Initial Balance: ₹" + myAccount.getBalance());

        // Valid debit
        myAccount.debit(700.00);

        // Debit more than balance
        myAccount.debit(400.00);

        // Try negative debit
        myAccount.debit(-100.00);

        // Final balance
        System.out.println("Final Balance: ₹" + myAccount.getBalance());
    }
}
