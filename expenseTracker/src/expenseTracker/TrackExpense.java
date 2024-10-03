package expenseTracker;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TrackExpense {
	//public static DateTimeFormatter standard = DateTimeFormatter.ofPattern("EEE LLL dd hh:mm a yyyy");
	 static String mainMenu = String.format("Program Menu: %n" +
			 "Enter \"quit\" to Quit program %n" +
			 "Enter \"help\" to view Help %n" +
			 "Enter \"new\" to make a New item %n" +
			 "Enter \"edit\" to edit a line item %n" +
			 "Enter \"delete\" to delete a line item %n" +
			 "Enter \"display\" to display the budget %n" +
			 "Enter \"search\" to search for a line item %n" + 
			 "Enter \"home\" to return Home %n" +
			 "Enter \"log out\" to Log Out %n" );	 
	 static String helpMainMenu = String.format("Help with Program Menu: %n" +
			 "Enter \"quit\" to Quit program %n"+ 
			 "       Quit ends the program, saves the current item, and logs the user out.%n" +
			 "Enter \"help\" to view Help %n" +
			 "       Help prints out the menu you are currently in with descriptions of each option written %n" +
			 "       below the original command.%n" +
			 "Enter \"new\" to make a New item %n" +
			 "       New helps create a new line item. First, it asks which type of item you would like.%n" +
			 "       Then, it will ask the user for the name, amount, purchase time, and other information.%n" +
			 "       If a field is left empty, it will be automatically filled with the default information.%n" +
			 "Enter \"edit\" to edit a line item %n" +
			 "       Edit will change a line item. It will prompt you to enter an ID. Then it will ask you for%n" +
			 "       each field. If you leave it empty, it will remain the same. If you input anyting, it will%n" +
			 "       appear as entered.%n" +
			 "Enter \"delete\" to delete a line item %n" +
			 "       Delete will remove an item from the budget and all its categories. You will be asked %n" +
			 "       if you want to delete one single item, or a category. Then you will be prompted for%n" +
			 "       the ID of the line item to delete or the name of the category you to delete.%n" +
			 "Enter \"display\" to display the budget %n" +
			 "       Display will show the options of budgets and categories to display, and ask you to choose%n" +
			 "       one. Then it will ask you for a start time, and end time. Then it will print all the line%n" +
			 "       items between the times.%n" +
			 "Enter \"search\" to search for a line item %n" + 
			 "       Search will prompt for a search phrase. Then it will return any thing that contains %n" +
			 "       the search phrase, and displays that on the screen, from newest to oldest.%n" +
			 "Enter \"home\" to return Home %n" +
			 "       Home will exit and return to the main program menu. If an element is bieng edited then it%n" +
			 "       will be saved with defaults filled in.%n" +
			 "Enter \"log out\" to Log Out %n"+
			 "       Log Out will log out the current user, and display the login fields.%n" +
			 "" );

	 static String newItemMenu = String.format("New Item Menu: %n" +
			 "Enter \"quit\" to Quit program %n" +
			 "Enter \"help\" to view Help %n" +
			 "Enter \"u\" or \"unique\" to make a unique item %n" +
			 "Enter \"r\" or \"repeating\" to make a repeating item %n" +
			 "Enter \"e\" or \"expanding\" to make a  item %n"+
			 "Enter \"home\" to return Home %n" +
			 "Enter \"log out\" to Log Out %n");
	 static String newItemHelpMenu = String.format("New Item Help Menu: %n" +
			 "Enter \"quit\" to Quit program %n"+ 
			 "       Quit ends the program, saves the current item, and logs the user out.%n" +
			 "Enter \"help\" to view Help %n" +
			 "       Help prints out the menu you are currently in with descriptions of each option written %n" +
			 "       below the original command.%n%n" +
			 
			 "Enter \"u\" or \"unique\" to make a unique item %n" +
			 "       U or Unique will make a single unique transaction.%n"+
			 "       You will be asked for a%n"+
			 "           Name: The name of your transaction ex. \"Pizza\" or \"John payed me back\"%n"+
			 "           Amount: The amount gained or lost ex. \"-7.99\" or \"20\"%n"+
			 "       You will opptionally be able to add%n"+
			 "           PurchaseTime: The time you made the transaction ex. \"Wed Feb 07 12:34 pm 2024\" %n"+
			 "                         The time is format specific and requires a three letter day, %n"+
			 "                         a three letter month, a day of the month, a standard time, am/pm, %n"+
			 "                         and the year.%n"+
			 "           Note: The place for added detail ex. \"OMG so fun!\" or \"Literally Anything AlphaNumeric\"%n"+
			 "           Tags: The tags feature allows for items to be grouped ex. \"food\" or \"car\"%n"+
			 "                 You can have any number of unique tags on any item accept your username. %n"+
			 "                 You can then access groups of taged items through the category display option. %n"+
			 "Enter \"r\" or\"repeating\" to make a repeating item %n" +
			 "       R or Repeating will make a transaction repeat over.%n"+
			 "Enter \"e\" or\"expanding\" to make a  item %n%n"+
			 
			 "Enter \"home\" to return Home %n" +
			 "       Home will exit and return to the main program menu. If an element is bieng edited then it%n" +
			 "       will be saved with defaults filled in.%n" +
			 "Enter \"log out\" to Log Out %n"+
			 "       Log Out will log out the current user, and display the login fields.%n"
			 );
	 
	 static String editMenu = String.format("Edit Item Menu: %n" +
			"Upon entering Edit you will be asked for an ID%n"+
			"If you do not know the ID, you can use Search to find it.%n"+
			"Once you have entered a valid ID, it will ask you for information %n"+
			"about the item in question. If you want an entry to stay the same, %n"+
			"hit \"enter\". Otherwise, type the apropriate answer in each field. %n"+
			 "");
	 static String editHelpMenu = String.format("Edit Item Help Menu: %n" +
			"Enter \"quit\" to Quit program %n"+ 
			"       Quit ends the program, saves the current item, and logs the user out.%n" +
			"Enter \"help\" to view Help %n" +
			"       Help prints out the menu you are currently in with descriptions of each option written %n" +
			"       below the original command.%n%n" +
			
			//Stuff the menu is actually about
			
			"Enter \"home\" to return Home %n" +
			"       Home will exit and return to the main program menu. If an element is bieng edited then it%n" +
			"       will be saved with defaults filled in.%n" +
			"Enter \"log out\" to Log Out %n"+
			"       Log Out will log out the current user, and display the login fields.%n"
			);

	 static String deleteMenu = String.format("Delete Item Menu: %n" +
			"To Delete an item you will be asked for an item ID%n"+
			"If you do not know the ID, you can use Search to find it.%n"+
			"Once you have entered a valid ID, it will confirm that you want %n"+
			"to delete the item in question. If you say \"yes\", the item will be removed %n"+
			"from all budgets and categories. Otherwise, say \"no\". You will be returned Home. %n"+
			"automatically. %n"+
			"");
	 static String deleteHelpMenu = String.format("Delete Item Help Menu: %n" +
				"Enter \"quit\" to Quit program %n"+ 
				"       Quit ends the program, saves the current item, and logs the user out.%n" +
				"Enter \"help\" to view Help %n" +
				"       Help prints out the menu you are currently in with descriptions of each option written %n" +
				"       below the original command.%n%n" +
				
				//Stuff the menu is actually about
				
				"Enter \"home\" to return Home %n" +
				"       Home will exit and return to the main program menu. If an element is bieng edited then it%n" +
				"       will be saved with defaults filled in.%n" +
				"Enter \"log out\" to Log Out %n"+
				"       Log Out will log out the current user, and display the login fields.%n");
	 
	 static String displayMenu = String.format("Display Budget Menu: %n"+
			 "To Display the budget you will be asked for a %n" +
			 "       Date: The furthest back you wish to see ex. \"Mon Jan 01 12:00 am 2024\" %n" +
			 "       Category: The specific group you wish to see. ex. \"Main\" or \"food\" %n" +
			 "Once this information has been provided, a chronological list of all the transactions %n"+
			 "recorded in the budget from oldest to newest will be shown. Then the total and average %n"+
			 "will then be displayed.%n" +
			 "");
	 static String displayHelpMenu = String.format("Display Budget Help Menu: %n" +
				"Enter \"quit\" to Quit program %n"+ 
				"       Quit ends the program, saves the current item, and logs the user out.%n" +
				"Enter \"help\" to view Help %n" +
				"       Help prints out the menu you are currently in with descriptions of each option written %n" +
				"       below the original command.%n%n" +
				
				//Stuff the menu is actually about
				
				"Enter \"home\" to return Home %n" +
				"       Home will exit and return to the main program menu. If an element is bieng edited then it%n" +
				"       will be saved with defaults filled in.%n" +
				"Enter \"log out\" to Log Out %n"+
				"       Log Out will log out the current user, and display the login fields.%n");
	 
	 static String searchMenu = String.format("Search Budget Menu: %n"+
			 "To Search the budget, you will be prompted to enter a search term.%n"+
			 "If the search term you provided is contined in the name of any budget item,%n"+
			 "it will be displayed from oldest to newest. Otherwise, it will print %n"+
			 "\"Nothing matches your search.\"%n"+
			 "");
	 static String searchHelpMenu = String.format("Search Budget Help Menu: %n" +
				"Enter \"quit\" to Quit program %n"+ 
				"       Quit ends the program, saves the current item, and logs the user out.%n" +
				"Enter \"help\" to view Help %n" +
				"       Help prints out the menu you are currently in with descriptions of each option written %n" +
				"       below the original command.%n%n" +
				
				//Stuff the menu is actually about
				
				"Enter \"home\" to return Home %n" +
				"       Home will exit and return to the main program menu. If an element is bieng edited then it%n" +
				"       will be saved with defaults filled in.%n" +
				"Enter \"log out\" to Log Out %n"+
				"       Log Out will log out the current user, and display the login fields.%n");
	 
	 
	 static String currentMenu = helpMainMenu; //The menu that the user is currently looking at.
	 static boolean programMenuRuns = true;//This is the condition for the menu while loop
	 static boolean subMenuCommand = true;//If the user issues a command from a menu that is not the main menu, this will 
	 static boolean newUser = false;//If the user issues a command from a menu that is not the main menu, this will 
	 
	 
	 static User currentUser;
	 static Budget currentBudget;
	 
	 
	 public static void main(String[] args) {
		 
		User.init();//check to see if the os and user home exists, then creates that main directory path
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Welcome to the Expense Tracker!%n"); 
		currentUser = loginProtocol(input);//this also updates static newUser
		
		
		if(newUser) {
			currentBudget = new Budget(currentUser.getUsername());
			String userBudgetFilePath = String.format("%s//%s.txt", currentUser.getUserDirectory(),currentUser.getUsername());
			File file = new File(userBudgetFilePath);
			
		}
		else {
			currentBudget = Budget.loadBudgetFromFile(currentUser.getUsername());
		}
		
		
		String choice = "home";
		while(programMenuRuns) {
			
			if(subMenuCommand) {
				subMenuCommand = false;
			}
			else {
				System.out.printf("Please input a command: ");
				choice = input.nextLine();
				System.out.printf("%n%n");
		        choice = choice.strip();
		        choice = choice.toLowerCase();
			}
			
	        switch (choice) {
	            case "quit": //quit case 
	            	programMenuRuns = false;
	            	//prints a goodbye message
	            	System.out.printf("Thank you for using the Expense Tracker!");
	            	break;//Skips all other cases
	            	
	            case "help": //help case
	            	System.out.print(currentMenu);
	            	break;//Skips all other cases
	            	
	            case "new": //new case
	            	currentMenu = newItemHelpMenu;
	            	choice = newItemProtocol(input);
	            	break;//Skips all other cases
	            	
	            case "edit": //needs user input check
	            	currentMenu = editHelpMenu;
	            	System.out.print(editMenu);
	            	System.out.println("Please input the ID for the item you want to edit.");
	            	System.out.print("Please input an ID: ");
					String userLong = input.nextLine();//needs user input check
	            	long ID = Budget.toLong(userLong);
	            	if(currentBudget.validID(ID)) editItemByID(input, ID);
	            	else System.out.println("Invalid ID");
	            	break;//Skips all other cases
	            
	            case "delete": 
	            	currentMenu = deleteHelpMenu;
	            	System.out.print(deleteMenu);
	            	System.out.println("Please input the ID for the item you want to delete.");
	            	System.out.printf("Please input an ID: ");
					userLong = input.nextLine();
	            	ID = Budget.toLong(userLong);
	            	if(currentBudget.validID(ID)) currentBudget.removeItem(ID);
	            	else System.out.println("Invalid ID");
	            	break;//Skips all other cases
	            	
	            case "display":  
	            	currentMenu = displayHelpMenu;
	            	//System.out.print(displayMenu);
	            	//displayProtocol(input);
	            	System.out.println( currentBudget.budgetToString() );
	            	break;//Skips all other cases
	            	
	            case "search": 
	            	currentMenu = searchHelpMenu;
	            	System.out.println("Please input the name for the item you want to search for.");
	            	System.out.printf("Please input a name: ");
	            	String searchWord = input.nextLine();
	            	ArrayList <UniqueItem> matchList =currentBudget.searchItems(searchWord);
	            	System.out.println(matchList.toString());
	            	break;//Skips all other cases
	            	
	            case "home": 
	            	currentMenu = helpMainMenu;
	            	System.out.print(mainMenu);
	            	break;//Skips all other cases
	            	
	            case "log out": 
	            	currentMenu = helpMainMenu;//logout help menu
	            	logOutProtocol(currentUser, currentBudget);
	            	System.out.printf("%s has been logged out.%n",currentUser.getUsername());
	            	currentUser = loginProtocol(input);
	            	currentBudget(currentUser.getUsername());
	            	break;//Skips all other cases
	            	
	            default: 
	            	System.out.printf("Sorry, \"%s\" is not a valid menu option.%n"
	            			+ "Please input a valid menu option.%n%n",choice);
	            	System.out.println(mainMenu);
	            	break;//Skips all other cases
	                     }
				}
		
		logOutProtocol(currentUser, currentBudget);
		//check for all directories
		//save to each directory
        }	    
	 
	 
	 
	 
	 
	





	/**
	 * Repeated Yes or No question.
	 * 
	 * @param prompt: the yes or no question you want to ask
	 * @param Yes: the string that returns a true
	 * @param No: the string that returns a false
	 * @return true for Yes, false for No
	 */
	public static boolean recurringYNQ(String prompt, String Yes, String No,  Scanner ui) {
		boolean answer = false;
		System.out.print(prompt);
		String currentInput = ui.nextLine();
		if(currentInput.matches(Yes)) {
			answer = true;
			return answer;
		}
		else if(currentInput.matches(No)) {
			answer = false;
			return answer;
		}
		else {
			System.out.printf("You must input either \"%s\" or \"%s\".%n",Yes,No);
			answer = recurringYNQ(prompt,Yes,No,ui);
		}
		return answer;
		
	}
	
	public static boolean recurringYNQ(String prompt, String[] Yes, String[] No,  Scanner ui) {
		boolean answer = false;
		System.out.print(prompt);
		String currentInput = ui.nextLine();
		for(int i = 0; i<Yes.length;i++) {
			if(currentInput.matches(Yes[i])) {
				answer = true;
				return answer;
			}
		}
		
		for(int i = 0; i<Yes.length;i++) {
			if(currentInput.matches(No[i])) {
				answer = false;
				return answer;
			}
		}
		
		{
			System.out.printf("You must input either \"%s\" or \"%s\".%n",Yes,No);
			answer = recurringYNQ(prompt,Yes,No,ui);
		}
		return answer;
		
	}
	
	
	public static User loginProtocol(Scanner input) {
		//User.loadUsersDirectory();
		if(recurringYNQ("Are you a New User? ", "yes", "no",  input)) {//new user
			newUser = true;
			System.out.printf("Hello new user!%n");
			String username, password, passwordMatch;
			do { 
				System.out.printf("Enter a new username here:");
				username = input.nextLine();
				if(!User.isUniqueUsername(username))System.out.printf("That username is already in use.");
			}while(!User.isUniqueUsername(username)); 
			
			do { 
				System.out.printf("Enter a new password here:");
				password = input.nextLine();
				System.out.printf("Enter the same password here:");
				passwordMatch = input.nextLine();
				if(!password.matches(passwordMatch))System.out.printf("The passwords to not match.");
			}while(!password.matches(passwordMatch)); 
			
			User currentUser =  new User(username,password);
			User.createDirectory(currentUser.getUsername());
			return currentUser;
		}
		else {// returning user
			newUser = false;
			System.out.printf( "Your privacy is important to us. %n"
					+ "Plese enter Username and Password,%n"
					+ "Username:");
			String username = input.nextLine();
			System.out.printf("Password:");
			String password = input.nextLine();
			for(int i = 0; i<2;i++) {
				if(User.validatePassword(username,password)) {
					System.out.printf("%n%n");
					
					User currentUser =  new User(username,password);
					User.createDirectory(currentUser.getUsername());
					return currentUser;
				}
				else {
					System.out.printf("Sorry, that is incorrect.%nPassword:");
					password = input.nextLine();
				}
			}
			System.out.printf("%nUnfortunatley, you have been kicked out. %nGoodbye.%n%n");
			programMenuRuns = false;
			return new User();
		}
	}
		
	
	public static String newItemProtocol(Scanner input) {
		boolean makingNewItem = true;
		String subMenuCommandString = null;
		while(makingNewItem) {	
			System.out.print(newItemMenu);
			
			System.out.printf("Please input a command: ");
			String choice = input.nextLine();
			System.out.printf("%n%n");
			choice = choice.strip();
			choice = choice.toLowerCase();
			
			switch (choice) {
            case "quit": //quit case 
            	makingNewItem = false;
            	subMenuCommandString = "quit";
            	subMenuCommand = true;
            	break;//Skips all other cases
            	
            case "help": //help case
            	System.out.print(currentMenu);
            	break;//Skips all other cases
            	
            case "u": //case "u" and case "unique" are the same
            	currentMenu = newItemHelpMenu;
            	System.out.printf("You have chosen to make a \"unique item\".%n");
            	newUniqueItemSetUp(input);
            	break;//Skips all other cases
            
            case "unique": 
            	currentMenu = newItemHelpMenu;
            	System.out.printf("You have chosen to make a \"unique item\".");
            	newUniqueItemSetUp(input);
            	break;//Skips all other cases
            	
            case "r":  
            	currentMenu = newItemHelpMenu;
            	System.out.println("Unfortunatley, this option remains unimplemented.");
            	break;//Skips all other cases
            	
            case "routine": 
            	currentMenu = newItemHelpMenu;
            	System.out.println("Unfortunatley, this option remains unimplemented.");
            	break;//Skips all other cases
            	
            case "e": 
            	currentMenu = newItemHelpMenu;
            	System.out.println("Unfortunatley, this option remains unimplemented.");
            	break;//Skips all other cases
            	
            case "expanding": 
            	currentMenu = newItemHelpMenu;
            	System.out.println("Unfortunatley, this option remains unimplemented.");
            	break;//Skips all other cases
            	
            case "home": 
            	makingNewItem = false;
            	subMenuCommandString = "home";
            	subMenuCommand = true;
            	break;//Skips all other cases
            	
            case "log out": 
            	makingNewItem = false;
            	subMenuCommandString = "log out";
            	subMenuCommand = true;
            	break;//Skips all other cases
            	
            default: 
            	System.out.printf("Sorry, \"%s\" is not a valid menu option.%n"
            			+ "Please input a valid menu option.%n%n");//needs a name
            	System.out.print(newItemMenu);
            	break;//Skips all other cases
            }
		
		}
		return subMenuCommandString;
		
	}
	
	public static void newUniqueItemSetUp(Scanner input) {//illegal characters filter for name and note and tag
		//Get new name for item
    	System.out.printf("Please input a name: ");
		String newName = input.nextLine();
		System.out.printf("%n");
		newName = newName.strip();
		
		//Get new amount for item
		String stringAmount = null;
		double newAmount = LineItem.SUPER_AMOUNT;
		do{
			System.out.printf("Please input an amount: ");
			stringAmount = input.nextLine();
			System.out.printf("%n");
			if(Budget.isDouble(stringAmount)) {
				newAmount = Budget.toDouble(stringAmount);
			}
			else System.out.printf("Enter a number as a decimal or negative number.%nNo other special characters allowed.%n");
		}while(!Budget.isDouble(stringAmount)); 
		
		//Get optional new note for item
		String newNote = null;
		if(recurringYNQ("Would you like to add a note? ", "yes", "no", input)) {
			System.out.printf("Please write a note: ");
			newNote = input.nextLine();
			System.out.printf("%n");
		}
		
		//Get optional new purchase time for item
		LocalDateTime newPurchaseTime = dateTimeProtocol(input, newName);
		
		//get optional new tags for item
		ArrayList<String> newTags = new ArrayList<String>();
		while(recurringYNQ("Would you like to add a new tag?", "yes", "no", input)) {
			System.out.printf("Please input a new tag: ");
			String newTag = input.nextLine();
			System.out.printf("%n");
			newTags.add(newTag);
		}
		
		//check nullity of optional items and instantiate new Unique Item
		UniqueItem newItem = new UniqueItem();
		if((newNote == null) && (newPurchaseTime == null) && (newTags.isEmpty())) newItem = new UniqueItem(newName, newAmount);
		else if((newNote != null) && (newPurchaseTime != null))   newItem = new UniqueItem(newName, newAmount, newTags);
		else if((newNote != null) && (newTags.isEmpty()))         newItem = new UniqueItem(newName, newAmount, newPurchaseTime);
		else if((newTags.isEmpty()) && (newPurchaseTime != null)) newItem = new UniqueItem(newName, newAmount, newNote);
		else if((newNote != null))         newItem = new UniqueItem(newName, newAmount, newTags, newPurchaseTime);
		else if(newPurchaseTime != null)   newItem = new UniqueItem(newName, newAmount, newNote, newTags);
		else if(newTags.isEmpty())         newItem = new UniqueItem(newName, newAmount, newNote, newPurchaseTime);
		else newItem = new UniqueItem(newName, newAmount, newNote, newPurchaseTime, newTags);
    	
    	
    	//load new item to master budget
    	currentBudget.setItem(newItem);
    	System.out.println("New Item Setup Complete!");
    	System.out.println();
	}
	
	public static LocalDateTime dateTimeProtocol(Scanner jose, String name) {
		// Someone has got to do it. Might as well be jose.
		LocalDate dateOfPlan = LocalDate.now();

		LocalTime purchaseTime = LocalTime.now();
		
		while(recurringYNQ("Would you like to update the date for your transaction? ", "yes", "no",  jose)) {
			try {
				System.out.printf("Please enter in the form \"dd-MM-yyyy\" . \nWhat day did you get %s? ",name);
		        dateOfPlan = LocalDate.parse(jose.nextLine(), LineItem.formatDate01); 
		        System.out.println("Date updated sucessfully.");
			}catch(DateTimeParseException e) {
				System.out.println("Sorry, that was the wrong format.");
			}
		}
		
		while(recurringYNQ("Would you like to update the time for your transaction? ", "yes", "no",  jose)) {
			try {
				System.out.printf("\nPlease enter the time in the form \"hh:mm AM/PM\" . \n");
		        System.out.printf("When did you get %s? ",name);
		        purchaseTime = LocalTime.parse(jose.nextLine(),LineItem.formatTime01); //The first appointment of the day
		        System.out.println("Time updated sucessfully.");
			}catch(DateTimeParseException e) {
				System.out.println("Sorry, that was the wrong format.");
			}
		}
        
		LocalDateTime dateTime = dateOfPlan.atTime(purchaseTime);
        return dateTime;
       
    }
	
	public static void editItemByID(Scanner input, long ID) {
		UniqueItem currentItem = (UniqueItem) currentBudget.getItem(ID);	
		//Get new name for item
		if( recurringYNQ("Would you like to change the name?", "yes", "no", input)) {
			System.out.printf("Please input a name: ");
			String newName = input.nextLine();
			System.out.printf("%n");
			newName = newName.strip();
			currentItem.setName(newName);
		}
    	
		
		if(recurringYNQ("Would you like to change the amount?", "yes", "no", input)) {
			//Get new amount for item
			String stringAmount = null;
			double newAmount = 0;//needs re-thinking
			do{
				System.out.printf("Please input an amount: ");
				stringAmount = input.nextLine();
				System.out.printf("%n");
				if(Budget.isDouble(stringAmount)) {
					newAmount = Budget.toDouble(stringAmount);
				}
				else System.out.printf("The amount gained or lost must be a number, with an optional decimal or negative.%n");
			}while(!Budget.isDouble(stringAmount)); 
			currentItem.setAmount(newAmount);
		}
		
		
		//Get optional new note for item
		String newNote = null;
		if(recurringYNQ("Would you like to replace the note?", "yes", "no", input)) {
			System.out.printf("Please write a note: ");
			newNote = input.nextLine();
			System.out.printf("%n");
		}
		currentItem.setNote(newNote);
		
		
		currentItem.setPurchaseTime(dateTimeProtocol(input, currentUser.getUsername()));
		
		
		while(recurringYNQ("Would you like to remove any tags?", "yes", "no", input)) {
			System.out.printf("Please input tag to remove: ");
			String newTag = input.nextLine();
			System.out.printf("%n");
			currentItem.removeTag(newTag);
		}
		
		//get optional new tags for item
		ArrayList<String> newTags = new ArrayList<String>();
		while(recurringYNQ("Would you like to add a new tag?", "yes", "no", input)) {
			System.out.printf("Please input a new tag: ");
			String newTag = input.nextLine();
			System.out.printf("%n");
			newTags.add(newTag);
		}
		

	}

	private static void currentBudget(String username) {
		//TODO need implementation
		System.out.printf("Hello %s, here is your main budget.%n%n", username);
		//one month of the main budget gets printed
	}

	public static void displayProtocol(Scanner input) {
		LocalDateTime newPurchaseTime = null;
		boolean addedTimeCorrectly = false;
		while(!addedTimeCorrectly) {
	    	System.out.println("Please input oldest transaction date you wish to see.");    	
	    	System.out.printf("Reminder: You must input the time in the format %n%s%n", LineItem.standard.toString());
			System.out.printf("Please input a time: ");
			String newTimeString = input.nextLine();
			System.out.printf("%n");
			try {
	            // Attempt to parse the string into a LocalDateTime object
				newPurchaseTime = LocalDateTime.parse(newTimeString, LineItem.standard);
	            System.out.println("String matches the pattern: " + LineItem.standard);
	            System.out.println("Parsed LocalDateTime: " + newPurchaseTime);
	            addedTimeCorrectly = true;
	        } catch (DateTimeParseException e) {
	            // Parsing failed, string does not match the pattern
	            System.out.println("String does not match the pattern: " + LineItem.standard);
	            addedTimeCorrectly = false;
	        }
    	
		}
	}
	
	public static void logOutProtocol(User currentUser, Budget currentBudget){
		User.saveUsersDirectory();
		currentBudget.budgetToFile();
	}	
}



