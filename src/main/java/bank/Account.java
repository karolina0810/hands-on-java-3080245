package bank;

import bank.exceptions.AmountExceptions;

public class Account {
  private int id;
  private String type;
  private Double balance;

  public Account (int id, String type, Double balance){
    setId (id);
    setType(type);
    setBalance(balance);
  }
 

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Double getBalance() {
    return this.balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public void deposit (double amount) throws AmountExceptions{
    if(amount <1){
      throw new AmountExceptions("The minumum deposit is 1.00");
    }
    else{
      double newBalance= balance + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }
  }
  public void withdraw (double amount)throws AmountExceptions{
    if(amount<0){
      throw new AmountExceptions("The withdrawal amount much be greater than 0.");
    }
    else if (amount>getBalance()){
      throw new AmountExceptions("You do not have sufficient funds for this withdrawal.");
      }
    else {
      double newBalance = balance - amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }

  }
}