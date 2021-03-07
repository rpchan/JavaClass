//A class that represents one transaction record

public class TransactionRecord {
   private int account;
   private double amount;
   
   // no-argument constructor calls other constructor with default values
   public TransactionRecord() {
      this(0, 0.0);
   } 

   // initialize a record
   public TransactionRecord(int acct, double amt) {
      setAccount(acct);
      setAmount(amt);
   } 

   // set account number   
   public void setAccount(int acct) {
      account = acct;
   } 

   // get account number   
   public int getAccount() { 
      return account; 
   } 

   // set amount
   public void setAmount(double amt) {
      amount = amt;
   }

   // get amount 
   public double getAmount() { 
      return amount; 
   } 
} //end of TransactionRecord


