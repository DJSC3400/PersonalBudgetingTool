package expenseTracker;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TestUserOperation {
	//static DateTimeFormatter formatDate01 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	//static DateTimeFormatter formatTime01 = DateTimeFormatter.ofPattern("hh:mm a");
	
	//static DateTimeFormatter combinedFormatter = new DateTimeFormatterBuilder().append(formatDate01).appendLiteral(' ').append(formatTime01).toFormatter();
	
    public static void main(String[] args) {
    	
    }
  
    
    
    public static void budgetTest() {
    	 //User johnDoe = new User();
         ArrayList<UniqueItem> item = new ArrayList<UniqueItem>();
         
         LocalDateTime todayRightNow = LocalDateTime.parse("Fri Mar 15 2024",LineItem.standard);
         UniqueItem effort = new UniqueItem("moreEffort", 4.20,todayRightNow);
         item.add(new UniqueItem());
         item.add(effort);
         Budget someStuff = new Budget("car",24.09,"hi",item);
         System.out.println(someStuff.budgetToString());
    }
    
    
    
    public static void saveUserDirectory() {
    	User johnDoe = new User();
    	User jimBob = new User("jimBob","password");
    	User pepPop = new User("pepPop","123456789");
    	User.saveUsersDirectory();
    }
    
    
    
    public static void testUserTimeConstruct() {
    	UniqueItem pizza = new UniqueItem("pizza",-6.99,"04-03-2024 12:34 AM");
    	UniqueItem noArgs = new UniqueItem();
    	System.out.println(noArgs.getPurchaseTimeString());
    	System.out.println(pizza.getPurchaseTimeString());
    }
    
    
    
    public static void gptTimeExample() {
        // Define a custom DateTimeFormatter using DateTimeFormatterBuilder
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("MMM dd yyyy") // Pattern for abbreviated month, day, and year
                .toFormatter(Locale.ENGLISH); // Use English locale for month names
        
        // Attempt to parse the string "Mar 15 2024" using the custom formatter
        LocalDateTime yesterday = LocalDateTime.parse("Mar 15 2024", formatter);
        
        // Print the parsed LocalDateTime object
        System.out.println("Parsed LocalDateTime: " + yesterday);
    }
    
    
    
    public static void myTimeWork() {//still full of errors
    	DateTimeFormatter monthDayYear = DateTimeFormatter.ofPattern("MMM dd yyyy", Locale.ENGLISH);

    	// Define a custom DateTimeFormatter using DateTimeFormatterBuilder
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("MMM dd yyyy") // Pattern for abbreviated month, day, and year
                .toFormatter(Locale.ENGLISH); // Use English locale for month names
        
    	
    	LocalDateTime yesterday = LocalDateTime.parse("Mar 15 2024", formatter);
    	UniqueItem pizza = new UniqueItem("pizza",-6.99, yesterday);
    	//UniqueItem noArgs = new UniqueItem();
    	//System.out.println(noArgs.getPurchaseTimeString());
    	
    	System.out.println(pizza.getPurchaseTimeString());
    	System.out.println(yesterday.format(formatter));
    }
    
    
    
    public static void dateTimeExperiment1() {
		Scanner jose = new Scanner(System.in);// Someone has got to do it. Might as well be jose.
		LocalDate dateOfPlan;

		LocalTime firstMeet, lastMeet;
		
		System.out.print("Please enter in the form \"dd-MM-yyyy\" . \nWhat is the date of your plan? ");
        dateOfPlan = LocalDate.parse(jose.nextLine(), LineItem.formatDate01); 
        
		
        System.out.printf("\nPlease enter the time in the form \"hh:mm AM/PM\" . \n");
        System.out.print("Start time of the first apointment: ");
        firstMeet = LocalTime.parse(jose.nextLine(),LineItem.formatTime01); //The first appointment of the day
        System.out.print("End time of the last apointment: ");
        lastMeet = LocalTime.parse(jose.nextLine(),LineItem.formatTime01); //The first appointment of the day
        
        System.out.println(dateOfPlan);
        System.out.println(firstMeet);
        System.out.println(lastMeet);
        
        jose.close();
        
    }

    
    public static void dateTimeExperiment2() {
		Scanner jose = new Scanner(System.in);// Someone has got to do it. Might as well be jose.
		LocalDate dateOfPlan = LocalDate.now();

		LocalTime purchaseTime = LocalTime.now();
		String name = "pizza";
		Double price = -6.99;
		
		/*
		System.out.print("Please enter a name:");
		name = jose.nextLine();
		
		System.out.print("Please enter a price:");
		price = jose.nextDouble();
		*/
		boolean getDateRight = false;
		while(!getDateRight) {
			try {
				System.out.printf("Please enter in the form \"dd-MM-yyyy\" . \nWhat day did you get %s? ",name);
		        dateOfPlan = LocalDate.parse(jose.nextLine(), LineItem.formatDate01); 
		        getDateRight = true;
			}catch(DateTimeParseException e) {
				getDateRight = false;
			}
		}
		
		boolean getTimeRight = false;
		while(!getTimeRight) {
			try {
				System.out.printf("\nPlease enter the time in the form \"hh:mm AM/PM\" . \n");
		        System.out.printf("When did you get %s? ",name);
		        purchaseTime = LocalTime.parse(jose.nextLine(),LineItem.formatTime01); //The first appointment of the day
		        getTimeRight = true;
			}catch(DateTimeParseException e) {
				getTimeRight = false;
			}
		}
        
		
        
        LocalDateTime dateTime = dateOfPlan.atTime(purchaseTime);
        
        UniqueItem niceItem = new UniqueItem(name,price,dateTime);
        
        System.out.println("The name:"+name);
        System.out.println("The price:"+price);
        System.out.println("The date and time:"+dateTime.toString());
        System.out.println(niceItem.toString());
        
        jose.close();
        
    }
    
}

































