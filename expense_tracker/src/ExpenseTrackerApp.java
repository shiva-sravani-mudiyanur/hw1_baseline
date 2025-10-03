import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    // Error Handling
    view.getAddTransactionBtn().addActionListener(e -> {
    	
    	InputValidation validation = new InputValidation();
      
    	double amount;
		try {
			// Get transaction data from view
			amount = view.getAmountField();
			String category = view.getCategoryField();

	          boolean isValidInput = validation.check(amount,category);
	          
	          if(isValidInput){
	              	// Create transaction object
	                Transaction t = new Transaction(amount, category);
	                // Call controller to add transaction
	                view.addTransaction(t);
	           }
		} catch (Exception ex) {
			validation.displayErrorMessage("Invalid Input: Please enter valid number between 0 and 1000");
		} 
    });

  }

}