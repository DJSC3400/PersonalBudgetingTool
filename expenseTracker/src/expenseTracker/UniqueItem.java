package expenseTracker;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class UniqueItem extends LineItem{
	public double amount;//the instance amount of the price of an object
	private boolean isPositive; //weather the amount is negative or positive.
	public LocalDateTime purchaseTime;//when the user said they bought it
	
	UniqueItem(long ID, String name, double amount, String note, LocalDateTime purchaseTime, ArrayList<String> tags){
		setID(ID);
		setName(name);
		setAmount(amount);
		setPurchaseTime(purchaseTime);
		setNote(note);
		addTags(tags);
	}
	UniqueItem(String name, double amount, String note, LocalDateTime purchaseTime, ArrayList<String> tags){
		setName(name);
		setAmount(amount);
		setPurchaseTime(purchaseTime);
		setNote(note);
		addTags(tags);
	}
	UniqueItem(String name, double amount, String note, LocalDateTime purchaseTime, String tag){
		setName(name);
		setAmount(amount);
		setPurchaseTime(purchaseTime);
		setNote(note);
		addTags(tag);
	}
	
	UniqueItem(String name, double amount, String note, ArrayList<String> tags){
		this.purchaseTime = super.getInstanceTime();
		setName(name);
		addTags(tags);
		setNote(note);
		setAmount(amount);
	}
	UniqueItem(String name, double amount, String note, String tag){
		this.purchaseTime = super.getInstanceTime();
		setName(name);
		addTags(tag);
		setNote(note);
		setAmount(amount);
	}
	UniqueItem(String name, double amount, String note, LocalDateTime purchaseTime){
		this(name, amount, note, purchaseTime, SUPER_TAG);
	}
	UniqueItem(String name, double amount, ArrayList<String> tags, LocalDateTime purchaseTime){
		this(name, amount, SUPER_NOTE, purchaseTime, tags);
	}
	
	
	UniqueItem(String name, double amount, ArrayList<String> tags){
		this.purchaseTime = super.getInstanceTime();
		setName(name);
		addTags(tags);
		setAmount(amount);
	}
	UniqueItem(String name, double amount, LocalDateTime purchaseTime){
		this(name, amount, SUPER_NOTE, purchaseTime, SUPER_TAG);
	}
	UniqueItem(String name, double amount, String note){
		this.purchaseTime = super.getInstanceTime();
		setName(name);
		setNote(note);
		setAmount(amount);
	}
	UniqueItem(String name, double amount){
		this.purchaseTime = super.getInstanceTime();
		setName(name);
		setAmount(amount);
	}
	UniqueItem(String name){
		this.purchaseTime = super.getInstanceTime();
		setName(name);
		setAmount(SUPER_AMOUNT);
	}
	UniqueItem(double amount){
		this.purchaseTime = super.getInstanceTime();
		setAmount(amount);
	}
	UniqueItem(){
		this.purchaseTime = super.getInstanceTime();
		setAmount(SUPER_AMOUNT);
	}
	
	//--------begin-getter/setter-section---------
	public double getAmount(){
		if(this.getIsPositive()) return amount;
		else return amount*-1;
	}
	public void setAmount(double amount){
		if(amount>=0) {//in this setup, 0 is a positive number. 
			this.setIsPositive(true);
			this.amount = amount;
		}
		else {
			this.setIsPositive(false);
			this.amount = amount*-1;
		}
	}
	
	public boolean getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}
	
	public LocalDateTime getPurchaseTime() {
		return this.purchaseTime;
	}
	
	public String getPurchaseTimeString() {
		return purchaseTime.format(standard);
	}
	public String getPurchaseTimeString(DateTimeFormatter format) {
		return purchaseTime.format(format);
	}
	
	public void setPurchaseTime(LocalDateTime time){
		//does not check format
		this.purchaseTime = time;
	}
	
	public void setPurchaseTime(String time){
		//does not check format
		this.purchaseTime = LocalDateTime.parse(time, standard);
	}
	
	//--------end-getter/setter-section---------
	
	public boolean correctTimeFormat() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void repeatTemporalAmount(Calendar calendar, int temporalField, int frequency, int repetitions) {
		for (int i = 0; i < repetitions; i++) {
		    calendar.add(temporalField, frequency);
		}
	}
	
	public String toString() {//ID@time amount: Name;tags,tags,tags | note
		return String.format("%d|%s|%.2f|%s|%s|%s",getID(),getPurchaseTimeString(standard),getAmount(),getName(),getTagsString(),getNote());
	}
	
	public static UniqueItem buildUniqueItem(String uniqueString) {
		String[] uniqueItemData = uniqueString.split("|");
		
		long ID = Budget.toLong(uniqueItemData[0]);
		LocalDateTime time = LocalDateTime.parse(uniqueItemData[1], standard);
		double amount = Budget.toDouble(uniqueItemData[2]);
		String name = uniqueItemData[3];
		
		String[] tagsArray = uniqueItemData[4].split(",");
		ArrayList<String> tagsList = new ArrayList<String>();
		for(int i = 0; i<tagsArray.length; i++) {
			tagsList.add(tagsArray[i]);
		}
		
		String note = uniqueItemData[5];
		
		
		return new UniqueItem(ID,name, amount, note, time, tagsList);
	}
	
	
}
