package org.example.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "CalculatorEJB")
@Remote
public class CalculatorBean {

  float interest = 10;
    public CalculatorBean() {

    }
  public float calculateInterest(long balance) {
    return balance * (1+ (interest/100));
  }

}
