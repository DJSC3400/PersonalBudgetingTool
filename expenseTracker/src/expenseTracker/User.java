package expenseTracker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {
	public static String mainDirectoryName;
	public String currentDirectory = String.format("%s\\%s",mainDirectoryName,this.getUsername());
	public static boolean isInitalized = false;
	static ArrayList<String> userList = new ArrayList<String>();
	private static ArrayList<String> passwordList = new ArrayList<String>();
	
	private String password;
	private String username;
	private String userDirectory;
	Budget mainUserBudget;
	

	
	User(String username, String password){
		setMainDirectoryName();
		loadUsersDirectory();
		setUsername(username);
		setPassword(password);
			
		setUserDirectory(username);
			createDirectory(username);
		this.mainUserBudget = new Budget(username,"This is the main budget. All of this users transactions are recorded here");
	}
	
	
	User(){
		this("John Doe","unsafePassword");
	}
	
	private void setUserDirectory(String username) {
		userDirectory = String.format("%s//%s", mainDirectoryName,username);
	}
	public String getUserDirectory() {
		return this.userDirectory;
	}
	
	public void setUsername(String username){
		if(isUniqueUsername(username)) { 
			this.username = username;
			userList.add(username);
		}
		//else output.printToTerminal("The username " + username + " is already in use.");
	}
	
	protected String getUsername() {
		return username;
	}
	
	public void setPassword(String password){
		this.password = password;
		passwordList.add(password);
	}
	
	private String getPassword() {
		return password;
	}
	
	public static boolean validatePassword(String username, String password) {// turns the user input into a case in a case switch block
		String truePassword = null;
		for(String aUser : User.userList) {
			if(aUser.matches(username)) {
				truePassword = passwordList.get(User.userList.indexOf(username));//The index of the username and password are assumed to be the same
			}
		}
		if((truePassword != null)&&(password.matches(truePassword))) return true;
		else return false;
	}
	
	//-----------user-managing-----------------
	
	public static boolean isUniqueUsername(String username) {
		if(!userList.contains(username)) { 
			return true;
		}
		else return false;
	}
	
	//-----------file-managing-----------------
	
	public boolean directoryExists(String directoryName) {
		return false;
	}
	
	
	//This one creates a subDirectory named "directory"
	public static void createDirectory(String directory) {
        String userDirectory = String.format("%s//%s", mainDirectoryName,directory);
        Path directoryPath = Paths.get(userDirectory);
        try {
            // Check if the directory already exists
            if (!Files.exists(directoryPath)) {
                // Create the master directory
                Files.createDirectory(directoryPath);
                System.out.println("createDirectory: Directory created successfully: " + directoryPath);
            } else {
                System.out.println("createDirectory: Directory already exists: " + directoryPath);
            }
        } catch (IOException e) {
            System.err.println("createDirectory: Error creating directory: " + e.getMessage());
            e.printStackTrace();
        }	
	}
	
	
//This checks to see if the "folder" exists within the main directory
	public static boolean internalFolderExists(String folder) {
    	String programHome = String.format("%s\\%s",getMainDirectoryName(),folder);// Get the current user's home directory
        File internalFolder = new File(programHome); // Create a File object representing the desktop directory
        
        if (internalFolder.exists()) return true;// Check if the directory exists
        else return false;
    }
	
//This checks to see if the user home is a valid location
	public static boolean userHomeExists() {
    	String userHome = System.getProperty("user.home");// Get the current user's home directory
        File userDirectory = new File(userHome); // Create a File object representing the desktop directory
        
        if (userDirectory.exists()) return true;// Check if the directory exists
        else return false;
    }
	
	public static void setMainDirectoryName(){
		String userHome = System.getProperty("user.home");// Get the current user's home directory
        String userPath = userHome + "\\eclipse-workspace\\expenseTracker\\userData";// Windows desktop directory path
		System.out.println("setMainDirectoryName: "+userPath);
        mainDirectoryName = userPath;
	}
	public static String getMainDirectoryName(){
		return mainDirectoryName;
	}
    
    public static boolean OSisWindows() {
    	String os = System.getProperty("os.name").toLowerCase();// Check if the operating system is Windows
        
        if (os.contains("win")) return true;
        else return false;
    }
    
    public static void init() {//this is used in the main
    	if(OSisWindows() && userHomeExists()) {
    		//Initialize unique main directory
    		setMainDirectoryName();
            // Specify the path for the master directory
            Path mainDirectoryPath = Paths.get(mainDirectoryName);
            try {
                // Check if the directory already exists
                if (!Files.exists(mainDirectoryPath)) {
                    // Create the master directory
                    Files.createDirectory(mainDirectoryPath);
                    System.out.println("createThisDirectory says: Master directory created successfully: " + mainDirectoryPath);
                    isInitalized = true;
                } else {
                    System.out.println("createThisDirectory says: Master directory already exists: " + mainDirectoryPath);
                }
            } catch (IOException e) {
                System.err.println("createThisDirectory says: Error creating master directory: " + e.getMessage());
                e.printStackTrace();
            }	
    	}
    	else System.out.printf("init: This program is only equipt to run in on Windows operating system with a desktop.%n");
    }
	
	
	
	
	
	
	public static void createTextFile(String directory, String fileName) {//where does it get created?
        try {
            File file = new File(directory, fileName);
            if (file.createNewFile()) {
                System.out.println("createTextFile: Text file created: " + file.getAbsolutePath());
            } else {
                System.out.println("createTextFile: Text file already exists.");
            }
        } catch (IOException e) {
            System.err.println("createTextFile: Error creating file: " + e.getMessage());
        }
    }
	
	public static void stringToFile(String content, String fileName) {
		// Write the string content to the text file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
		   writer.write(content);
		   System.out.println("stringToFile: String successfully written to " + fileName);
		} catch (IOException e) {
		    System.err.println("stringToFile: Error writing to file: " + e.getMessage());
		}
	}

	public static String readContent(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } 
	 return contentBuilder.toString();
}
	
	
	
	

	
	public static void saveUsersDirectory() {
		createDirectory("users");
		String usersListString = userList.toString();
		String passwordListString = passwordList.toString();
		String usersFileString = String.format("%s%n%s", usersListString, passwordListString);
		createTextFile(User.getMainDirectoryName(),"users");
		stringToFile(usersFileString, "users.txt");
	}
	
	public static void loadUsersDirectory() {
		if(internalFolderExists("users")) {
			String usersDirectory = String.format("%s\\users\\users.txt",mainDirectoryName);
			try {
				String userData = readContent(usersDirectory);
				parseToUserArray(userData);
				System.out.println("Content read from the file:\n" + userData);
			
			} catch (IOException e) {
				System.out.println("An error occurred: " + e.getMessage());
				e.printStackTrace();
			
			}
		}
		
		
	}
		
		
		private static void parseToUserArray(String fileString) {//this reverses budgetToString
			String[] lines = fileString.split("\\r?\\n");
			StringBuilder s = new StringBuilder();
			ArrayList<String> currentUsername = new ArrayList<String>();
			ArrayList<String> currentPasswords = new ArrayList<String>();
			
			
			
				
			if((fileString != null)&&(lines.length==2)) {//changes since due date: now checks to avoid null case.
				String userListString = lines[0]; 
				String userPasswordString = lines[1];
				for(int i = 1; i<userListString.length(); i++) {//start at 1 to skip bracket
					if((userListString.charAt(i) == ',')||(userListString.charAt(i) == ']')) {
						currentUsername.add(s.toString());
						s.setLength(0);
					}
					else s.append(userListString.charAt(i));
				}
				
				for(int i = 1; i<userPasswordString.length(); i++) {//start at 1 to skip bracket
					if((userPasswordString.charAt(i) == ',')||(userPasswordString.charAt(i) == ']')) {
						currentPasswords.add(s.toString());
						s.setLength(0);
					}
					else s.append(userPasswordString.charAt(i));
				}
				
			}
			
			userList = currentUsername;
			passwordList = currentPasswords;
			
		}
	
}
	