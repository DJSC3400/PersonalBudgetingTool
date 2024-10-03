package expenseTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;


public abstract class LineItem {//this needs to be abstract as it is the metadata wrapper for its extensions. 
	//public Calendar superCalendar = new GregorianCalendar();
	// weekday letterMonth numDay twelveHour:minute am/pm year("EEE LLL dd hh:mm a yyyy")
	static DateTimeFormatter formatDate01 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	static DateTimeFormatter formatTime01 = DateTimeFormatter.ofPattern("hh:mm a");
	
	static DateTimeFormatter standard = new DateTimeFormatterBuilder()
            .append(formatDate01)
            .appendLiteral(' ')
            .append(formatTime01)
            .toFormatter();
	//public static DateTimeFormatter standard = DateTimeFormatter.ofPattern("LLL dd yyyy", Locale.ENGLISH);	// weekday letterMonth numDay year
	public String name = SUPER_NAME;//name of the item  
	public String note = SUPER_NOTE;//any notes on the item
	public static ArrayList<String> allTags= new ArrayList<String>();//all the tags that every item has
	private ArrayList<String> individualTags= new ArrayList<String>();//any tags the user says they have
	//Initialized in super
	private static LocalDateTime instanceTime;//when it gets made
	static long COUNT; //the number of items. Used for making the ID.
	long ID;//identification tag 
	
	//Initialized in Unique
	public static String SUPER_TAG = "user";
	public static double SUPER_AMOUNT = 0.0;
	public static String SUPER_NOTE = "";
	public static String SUPER_NAME = "UniqueItem"+COUNT;
	
	
	
	LineItem(){
		instanceTime = LocalDateTime.now();//when it gets made
		COUNT++; //the number of items. Used for making the ID.
		ID = COUNT;//identification tag.
	}
	
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		name = name.trim();
		this.name = name;
	}
	
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public long getID() {
		return this.ID;
	}
	void setID(long ID) {
		this.ID = COUNT;
	}
	
	public static boolean isValidID(long ID) {
		if((ID<=COUNT)&&(ID>0)) return true;
		return false;
	}
	
	public ArrayList<String> getTags() {
		return individualTags;
	}
	public String getTagsString() {
		String tagsString = "";
		for(String t: individualTags) {
			tagsString += t + ", ";
		}
		return tagsString;
	}
	public boolean hasTag(String tag) {
		if(individualTags.contains(tag)) {
			return true;
		}
		return false;
	}
	public void addTags(String tag) {
		if(!allTags.contains(tag)) {
			allTags.add(tag);
		}
		if(!hasTag(tag)) this.individualTags.add(tag);
	}
	public void addTags(ArrayList<String> tags) {
		for(String tag: tags) addTags(tag);
	}
	
	public void removeTag(String tag) {
		if(hasTag(tag)) this.individualTags.remove(tag);
	}
	
	
	public static LocalDateTime getInstanceTime() {
		return instanceTime;
	}
	public static String getInstanceTimeString() {
		return instanceTime.format(standard);
	}
	public static String getInstanceTimeString(DateTimeFormatter format) {
		return instanceTime.format(format);
	}
	
	
	
}