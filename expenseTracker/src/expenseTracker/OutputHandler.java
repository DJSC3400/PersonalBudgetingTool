package expenseTracker;

import java.io.IOException;

public class OutputHandler {
	
	private String PATH = "";

	public static void main(String[] args) {
		
	}
	
	OutputHandler(){
		
	}
	
	OutputHandler(User u){
		
	}
	
	OutputHandler(String filePath){
		setPath(filePath);
	}
	
	private void initializeDirectory() {
		//Checks if the directory is already made, 
		//	if not made, makes directory and sets file path
		//	if made, sets path to directory

	}
	
	private void createDirectory(User u) {
		//turns user name and user number into a folderName
		//calls createDirectory(folderName)
	}
	
	private void createDirectory(String directoryName) {
		//
	}
	
	private void setPath(String PATH) {
		this.PATH = PATH;
	}
	
	private String getPath() {
		return PATH;
	}
	
	void saveToFile() {
		//https://www.youtube.com/watch?v=JhNPDjmZ-9s&ab_channel=TechnicalSpark
		//The above video is a set of commands that allow us to directly save text from the command prompt.
		
	}
	
	void printFromFile(){
		//https://www.youtube.com/watch?v=ScUJx4aWRi0&ab_channel=CodingwithJohn
		//The buffered writer object will help us do things.
	}
	
	void openTerminal() {
		//https://learn.microsoft.com/en-us/windows-server/administration/windows-commands/windows-commands
		//This does open a Command Prompt which is neat, but exec is deprecated and I don't know what does well enough to replace it. 
		Process p = null;
		try {
			p = Runtime.getRuntime().exec("cmd /c start cmd.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void printToTerminal(String s){
		System.out.println(s);
	}
	
	void startDisplay() {
		//This prints the description of the program 
	}
	
}
