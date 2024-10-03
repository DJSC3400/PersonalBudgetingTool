package expenseTracker;



public class Category extends Budget {
	Double goalPrice;
	
	Category(Double goalPrice, String name, String note){
		super(name, note);
		setGoalPrice(goalPrice);
	}
	Category(Double goalPrice, String name){
		this(goalPrice, name, "");
	}
	Category(String name){
		this(0.0, name, "");
	}
	Category(Double goalPrice){
		this(goalPrice, LineItem.SUPER_TAG, "");
	}
	Category(){
		this(0.0, LineItem.SUPER_TAG, "");
	}
	
	public void setGoalPrice(Double goalPrice) {
		this.goalPrice = goalPrice;
	}
	
	
	public static Double setGoalPrice(String s) {
		return Budget.toDouble(s);
	}
	
	
	public Double getGoalPrice() {
		return goalPrice;
	}
	
	
	public String getGoalPriceString() {
		return goalPrice.toString();
	}
	
	public 	void/*time*/ getGoalDuration() {
		//return time
	}
	
	public void  setGoalDuration() {
		//return time
	}
	
	public String categoryToString() {
		StringBuilder s = new StringBuilder();
		s.append(String.format("%s%n%.2f%n%s%n",this.getName(), this.goalPrice,this.getNote()));
		s.append(String.format("BeginArrayList%n"));
		s.append(String.format("%n"));
		return s.toString();
		}
}
