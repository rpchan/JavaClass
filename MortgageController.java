package application;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;


public class MortgageController {

	private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
	private static final NumberFormat percent = NumberFormat.getPercentInstance();
	
	private Double loanDuration;
	
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
    private TextField monthlyPmt10TextField;

    @FXML
    private TextField monthlyPmt20TextField;

    @FXML
    private TextField monthlyPmt30TextField;
    
    @FXML
    private Label loanDurationLabel; //default label is set to 10 years
      

    @FXML
    void calculateButtonPressed(ActionEvent event) {
    	try {
    		Double purchasePrice = Double.parseDouble(purchasePriceTextfield.getText());
    		Double downPayment = Double.parseDouble(downPaymentTextField.getText());
    		Double interestRate = Double.parseDouble(interestRateTextField.getText());
    		Double netPurchasePrice;
    		Double monthlyInterestRate;
    		
    		monthlyInterestRate = interestRate/1200; //annual rate into monthly rate
    		netPurchasePrice = purchasePrice - downPayment;
    		
    		Double tenYears = Double.valueOf(120);
    		Double twentyYears = Double.valueOf(240);
    		Double thirtyYears = Double.valueOf(360);
    		Double customYears = loanDurationSlider.getValue()*12;
    		
    		Double monthlyPayment = (netPurchasePrice * monthlyInterestRate/(1-(1/Math.pow(1 + monthlyInterestRate, customYears))));
    		Double monthlyPmt10 = (netPurchasePrice * monthlyInterestRate/(1-(1/Math.pow(1 + monthlyInterestRate, tenYears))));
    		Double monthlyPmt20 = (netPurchasePrice * monthlyInterestRate/(1-(1/Math.pow(1 + monthlyInterestRate, twentyYears))));
    		Double monthlyPmt30 = (netPurchasePrice * monthlyInterestRate/(1-(1/Math.pow(1 + monthlyInterestRate, thirtyYears))));
    		
            purchasePriceTextfield.setText(currency.format(purchasePrice));
            downPaymentTextField.setText(currency.format(downPayment));
            interestRateTextField.setText(percent.format(interestRate/100));
            monthlyPaymentTextField.setText(currency.format(monthlyPayment)); 
            monthlyPmt10TextField.setText(currency.format(monthlyPmt10));
            monthlyPmt20TextField.setText(currency.format(monthlyPmt20));
            monthlyPmt30TextField.setText(currency.format(monthlyPmt30));
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


