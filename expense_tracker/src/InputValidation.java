import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/**
 * InputValidation class evaluates the input received through the User Interaction and verifying it with the rules specified
 * (Amount in given range and accepted categories list).
 * This class extends Frame and defines UI components to display the user inputs and error messages if any in the GUI.
 */

public class InputValidation extends Frame {
    // Declaring button field for submitting the user response
	private Button button;
    public static final double MIN_AMOUNT = 0;
    public static final double MAX_AMOUNT = 1000;
    public static final String[] CATEGORY_LIST = {"food", "travel", "bills", "entertainment", "other"};
    
    // Validating the input variables and Error handling
    public boolean check(double amount, String category) {
    	try {
    		boolean isValid = false;
            
            boolean categoryList = Arrays.asList(CATEGORY_LIST).contains(category.toLowerCase());
            
            if(category.isEmpty() || !categoryList){
            	throw new Exception("The entered category is not present in the list {food, travel, bills, entertainment, other}. Please check.");
            }
            else if(!(MIN_AMOUNT < amount && amount < MAX_AMOUNT)){
                throw new Exception("Kindly enter the amount from 0 to 1000 range");
            }else if(categoryList){
            	isValid = true;
            }
            
            if(!isValid) {
            	throw new Exception("Kindly try again with the same values");
            }
            return isValid;
    	}
        catch (Exception e) {
            displayErrorMessage(e.getMessage());
            return false;
        }
    }

    // To display error message to the user 
    public void displayErrorMessage(String error_message){
    	if(error_message.isEmpty()) {
    		error_message = "DEFAULT";
    	}
        String err_msg = error_message;
        setLayout(new GridLayout(2, 2));
        add(new Label(err_msg));
        button = new Button("OK");
        add(button);

        button.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent evt) {
        		dispose();
        		
            }
        });
        setTitle("Invalid data entered");
        setSize(400, 100);
        setVisible(true);
    } 
}