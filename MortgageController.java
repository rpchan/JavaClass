package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;


public class MortgageController {

	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static final NumberFormat percent = NumberFormat.getPercentInstance();
	
	private Double loanDuration; //default 10 years
	
    @FXML
    private Slider loanDurationSlider;

    @FXML
    private TextField purchasePriceTextfield;

    @FXML
    private TextField downPaymentTextField;

    @FXML
    private TextField interestRateTextField;

    @FXML
    private TextField monthlyPaymentTextField;
    
    @FXML
    private Label loanDurationLabel;
      

    @FXML
    void calculateButtonPressed(ActionEvent event) {
    	try {
    		Double purchasePrice = Double.parseDouble(purchasePriceTextfield.getText());
    		Double downPayment = Double.parseDouble(downPaymentTextField.getText());
    		Double interestRate = Double.parseDouble(interestRateTextField.getText());
    		Double netPurchasePrice;
    		
    		Double tenYears = Double.valueOf(120);
    		Double twentyYears = Double.valueOf(240);
    		Double thirtyYears = Double.valueOf(360);
    		Double customYears = loanDurationSlider.getValue();
    		
    		interestRate = interestRate/100; //converts the input into a percentage
    		netPurchasePrice = purchasePrice - downPayment;
    		
    		Double monthlyPayment = (netPurchasePrice * interestRate/(1-(1/Math.pow(1 + interestRate, customYears))));
    		
            purchasePriceTextfield.setText(currency.format(purchasePrice));
            downPaymentTextField.setText(currency.format(downPayment));
            interestRateTextField.setText(percent.format(interestRate));
            monthlyPaymentTextField.setText(currency.format(monthlyPayment)); 
    	} //end of try method
    	
    	catch (NumberFormatException ex) {
            purchasePriceTextfield.setText("Enter amount");
            purchasePriceTextfield.selectAll();
            purchasePriceTextfield.requestFocus();
         } //catch the exceptions

    } //end of calculateButtonPressed method
    
    
    //called by FXMLLoader to initialize the controller
    public void initialize() {
    	
    	//listener for changes to number of years of loan
    	loanDurationSlider.valueProperty().addListener(
    		new ChangeListener<Number>() {
    			@Override
    			public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) 
    			{
    				loanDuration = Double.valueOf(newValue.intValue());
    				loanDurationLabel.setText(Double.toString(loanDuration)); 
    			} //end of changed method
    		} //end of ChangeListener
    	); //end of loanDurationSlider
    } //end of initialize method

} //end of class MortgageController


