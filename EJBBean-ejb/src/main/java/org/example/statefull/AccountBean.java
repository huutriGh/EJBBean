package org.example.statefull;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful(name = "AccountEJB")
@Remote
public class AccountBean {

    long balance;

    public long getBalance() {
        return balance;
    }

    public AccountBean() {
    }

    public void createAccount(long amount) {
        this.balance = amount;
    }

    public void deposit(long amount) {

        this.balance += amount;

        System.out.println("Money deposit. total is " + balance);
    }

    public void withdraw(long amount) throws Exception {

        long newAmount = balance - amount;
        if (newAmount < 0) {
            throw new Exception("Unsufficient funds for account! ");
        }

        balance = newAmount;
        System.out.println("Money withdrawal. total is " + balance);
    }
}
