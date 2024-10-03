package expenseTracker;

import java.awt.geom.Arc2D.Double;

public class ExpandingItem extends UniqueItem {
	//Things that apply for both loans and assets
	double fullAmount; //the principle
	boolean isFixed;//true if the interest rate is fixed.
	double intrestRate; //the fixed interest rate
	double expectedRate; //the expected value of the rate
	double rateVariance; //the amount the rate may change
	boolean isCompounding;//Does it compound?
	double compoundingRate; //How often does it compound?(maybe this should be an array of strings)
	boolean doesForecast;//true if you want to reveal the future valuation
	double forecastDuration;//the length of time you want to forecast to
	
	//Things that apply to loans only
	boolean isSubsidized;//If the loan is subsidized.
	double subsidizedUntil;//The period of time the loan is subsidized. 
	double duration; //or loan term: the expected payoff date on a regular payment
	double occurrence; //the interval of the regular payoff occurrence
	int occurrenceCount;//the total number of expected payments. duration/occurrence
	boolean isTruant;//for estimates: if the user is truant
	double expectedTruancy;//the amount of late payments
	double varianceTruancy;//the amount the lateness varies. 
	
	//items with actual dollar value
	double amountPayed;//total amount payed
	double interestPayed;//full amount of interest payed
	double interestPayedInstance;//The amount of interest payed in one regular payment
	double principalPayed;//full amount of principle payed
	double principalPayedInstance;//The amount of principal payed in one regular payment
	double amountRemaining;//or current balance: the amount left to pay
	
	
	ExpandingItem(){
		
	}
	
	public double getFullAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setFullAmount(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getIsFixed() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setIsFixed(boolean bool) {
		// TODO Auto-generated method stub
		
	}
	
	public double getIntrestRate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setIntrestRate(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public double getExpectedRateRate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setExpectedRate(double amount) {
		// TODO Auto-generated method stub
		
	}

	public boolean getIsCompounding() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setIsCompounding(boolean bool) {
		// TODO Auto-generated method stub
		
	}
	
	public double getCompoundingRate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setCompoundingRate(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getDoesForecast() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setDoesForecast(boolean bool) {
		// TODO Auto-generated method stub
		
	}
	
	public double getForecastDuration() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setForecastDuration(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	//----------Apply-only-to-loans------------
	
	public boolean getIsSubsidized() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setIsSubsidized(boolean bool) {
		// TODO Auto-generated method stub
		
	}

	public double getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setDuration(double amount) {
		// TODO Auto-generated method stub
		
	}

	public double getOccurrance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setOccurrance(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public int getOccurranceCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setOccurranceCount(int amount) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getIsTruant() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void setIsTruant(boolean bool) {
		// TODO Auto-generated method stub
		
	}
	
	public double getExpectedTruancy() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setExpectedTruancy(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public double getVarianceTruancy() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setVarianceTruancy(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	//----------Actual-dollar-amount------------
	
	public double getAmountPayed() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setAmountPayed(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public double getInterestPayed() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setInterestPayed(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public double getInterestPayedInstance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setInterestPayedInstance(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public double getPrincipalPayed() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setPrincipalPayed(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	public double getPrincipalPayedInstance() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setPrincipalPayedInstance(double amount) {
		// TODO Auto-generated method stub
		
	}
	public double getAmountRemaining() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setAmountRemaining(double amount) {
		// TODO Auto-generated method stub
		
	}

	//----------Getters-and-Setters-Complete------------
}
