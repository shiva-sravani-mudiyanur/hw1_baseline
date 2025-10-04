

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.List;

/**
 * The Transaction class represents a financial transaction with an amount, category, and timestamp. 
 * It includes getter and setter methods to access and modify these details.
 * 
 * Made changes to transactions to make the class Immutable by making the fields private & final and removing setters.
 * Values to the fields are assigned only when object created and can't be modified further.  
 */

public final class Transaction {

  private final double amount;
  private final String category;
  private final String timestamp;

  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  public double getAmount() {
    return amount;
  }

  public String getCategory() {
    return category;
  }
  
  public String getTimestamp() {
    return timestamp;
  }

  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}