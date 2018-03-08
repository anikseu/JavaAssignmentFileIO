/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.ui;

/**
 *
 * @author kmhasan
 */
public class BankAccount {
    private long accountId;
    private String accountName;
    private String address;
    private double balance;

    public BankAccount(long accountId, String accountName, String address, double balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.address = address;
        this.balance = balance;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void withdraw(int amount) {
        balance = balance - amount;
    }
    
    public void deposit(int amount) {
        balance = balance + amount;
    }
    
    public String toString() {
//        System.out.println("ID: " + accountId + ", Name: " + accountName + ", Balance: " + balance);
        return String.format("ID: %d, Name: %s, Balance: %.2f", accountId, accountName, balance);
    }
}
