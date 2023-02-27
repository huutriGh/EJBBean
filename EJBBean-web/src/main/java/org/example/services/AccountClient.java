package org.example.services;

import org.example.statefull.AccountBean;
import org.example.stateless.CalculatorBean;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AccountClient {

    @EJB
    CalculatorBean calculator;
    @EJB
    AccountBean account;

    public float callRemoteEJB(long banlance){
        account.createAccount(banlance);
        System.out.println("Create Account with "+banlance);
        account.deposit(banlance/2);
        System.out.println("Deposit " +(banlance/2));
        try {
            account.withdraw(banlance/3);
            System.out.println("Withdraw "+(banlance/3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        banlance = account.getBalance();
        System.out.println("Money left " + banlance);
        float totalMoney = calculator.calculateInterest(banlance);
        System.out.println("Money plus interests " + totalMoney);
        return totalMoney;
    }
}
