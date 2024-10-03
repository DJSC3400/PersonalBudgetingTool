package expenseTracker;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Budget  {
	private String name;
	private ArrayList <UniqueItem> items = new ArrayList<UniqueItem>();
	private double total;
	private String note;
	//private time timeStamp;
	
	
	Budget(String name, double total, String note, ArrayList<UniqueItem> items){
		setName(name);
		setNote(note);
		this.items = items;
		this.total = total;
		setCount();
	}
	
	Budget(String name, String note){
		setName(name);
		setNote(note);
		this.total = 0.0;
		setCount();
	}
	Budget(String name){
		this(name, "");
	}
	Budget(){
		this("NoNameBudget", "");	
	}
	
	private void setCount() {
		
		if(items.isEmpty()) {
			LineItem.COUNT = 0;
		}else {
			LineItem.COUNT = items.size();
	  }
	}
	
	public int getSize(int size) {
		return items.size();
		}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String new_Note) {
		this.note = new_Note;
	}
	
	public boolean validTags(UniqueItem item2) {
		if(LineItem.allTags.containsAll(item2.getTags())) {
			return true;
		}
		return false;
	}
	public boolean validID(long ID) {
		for(UniqueItem currentItem : items) {
			if(currentItem.getID() == ID) return true;
		}
		return false;
	}
	public boolean validateOneTag(String tag) {
		if(LineItem.allTags.contains(tag)) return true;
		else return false;
	}
	
	public ArrayList<UniqueItem> getItems() {
		return this.items;
	}
	
	public LineItem getItem(Long ID) {
		if(LineItem.isValidID(ID))
			for(LineItem item : items) {
				if(item.getID() == ID) return item;
			}
		return null;
	}
	
	public void setItem(UniqueItem item) {
		items.add(item);
	}
	
	public void removeItem(long ID) {
		for(LineItem item : items) {
			if(item.getID() == ID) items.remove(item);
		}
	}
	
	public ArrayList<UniqueItem> searchItems(String searchWord) {
		ArrayList <UniqueItem> matchList = new ArrayList<UniqueItem>();
		for(UniqueItem item : items) {
			if(item.getName() == searchWord) matchList.add(item);
		}
		return matchList;
	}
	
	public Double getTotal() {
		return this.total;
	}
	
	public void setTotal() {
		Double sum = 0.0;
		for(UniqueItem item : items) {
			sum += item.getAmount();
		}
		total = sum;
	}

	
	public Double getAverage() {
		if(items.isEmpty()) {
			return null;
		}
		else {
			Double average = getTotal()/items.size();
			return average;
		}
	
	}
	
	public void exportToCSV(){
		
	}
	//////////////////////////////////////////////////////////////////////

	public String budgetToString() {
		StringBuilder s = new StringBuilder();
		s.append(String.format("%s%n%f%n%s%n", this.name, this.total, this.note));
		s.append(String.format("BeginArrayList%n"));
		for(UniqueItem item : items) {
			s.append(item.toString());
			s.append(String.format("%n"));
		}
		
		return s.toString();
	}
	
	public void budgetToFile() {
		StringBuilder s = new StringBuilder();
		String fileName = String.format("%s.txt", this.name); // Name of the text file to create
		s.append(String.format("%s%n%f%n%s%n",this.name, this.total,this.note));
		s.append(String.format("BeginArrayList%n"));
		for(UniqueItem item : items) {
			s.append(item.toString());
			s.append(String.format("%n"));
		}
		String budgetPath = User.getMainDirectoryName() + "\\" + this.getName();
		User.createTextFile(budgetPath,fileName);
		User.stringToFile(s.toString(),fileName);
	}
	
	
	
	public static Budget loadBudgetFromFile(String username) {
		
		String filePath = String.format("%s.txt", username);
        
        try {
			String content = User.readContent(filePath);
			Budget currentBudget = buildBudget(content);
			System.out.println("Content read from the file:\n" + content);
			return currentBudget;
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static Budget buildBudget(String fileString) {//this reverses budgetToString
		String[] lines = fileString.split("\\r?\\n");
		ArrayList<UniqueItem> currentItems = new ArrayList<UniqueItem>();
		
		for(int i = 3;i<lines.length;i++) {
			currentItems.add(UniqueItem.buildUniqueItem(lines[i]));
		}
		
		Budget currentBudget = new Budget(lines[0],toDouble(lines[1]),lines[2],currentItems);
		return currentBudget;
	}
	
	
	
 	public static double toDouble(String s) {
		double value = 0.0;
		int place = 1;
		boolean hasDecimal = false, isNegative = false;
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) == '-')) {
				isNegative = true; 
			}
			else if(s.charAt(i) == '.') { 
				hasDecimal = true; 
			}
			else if(!hasDecimal) {
				value *= 10;
				value += digitCharToInt(s.charAt(i));
			}
			else if(hasDecimal) {
				place *= 10;
				value += ( (double) digitCharToInt(s.charAt(i)))/place;
				
			}
		}
		if(isNegative) return value*(-1);
		else return value;
	}
	
 	public static long toLong(String s) {
		long value = 0;
		
		for(int i = 0; i < s.length(); i++) {
			value *= 10;
			value += digitCharToInt(s.charAt(i));
		}
		return value;
	}
 	
	public static boolean isDouble(String s) {
		int checkSum = 0;
		boolean hasPoint = false;
		for(int i = 0; i<s.length(); i++) {
			if((s.charAt(i) == '-')&&(i==0)) checkSum++;
			if((s.charAt(i)>47)&&(s.charAt(i)<=57)) checkSum++;
			if((s.charAt(i) == '.')&&(!hasPoint)){
				checkSum++;
				hasPoint = true;
			}
			
		}
		if(s.length() == checkSum) return true;
		return false;
	}
	
	public static int digitCharToInt(char c) {
		if(c==48) return 0;
		if(c==49) return 1;
		if(c==50) return 2;
		if(c==51) return 3;
		if(c==52) return 4;
		if(c==53) return 5;
		if(c==54) return 6;
		if(c==55) return 7;
		if(c==56) return 8;
		if(c==57) return 9;
		return 0;
	}

	

	
	
	
}