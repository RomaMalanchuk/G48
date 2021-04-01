package models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyLogger {
	private static final MyLogger instance = new MyLogger();

	public String logname = "simplelog";
	protected String env = System.getProperty("user.dir");
	private static File logFile;
	
	public static MyLogger getInstance(){
		return instance;
	}
	
	public static MyLogger getInstance(String withName){
		instance.logname = withName;
		instance.createLogFile();
		return instance;
	}
	
	public void createLogFile(){
		//Determine if a logs directory exists or not.
		File logsFolder = new File(env + '/' + "logs");
		if(!logsFolder.exists()){
			//Create the directory 
			System.err.println("INFO: Creating new logs directory in " + env);
			logsFolder.mkdir();
			
		}

		//Get the current date and time
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   	Calendar cal = Calendar.getInstance();
	   	
	   	//Create the name of the file from the path and current time
		logname =  logname + '-' +  dateFormat.format(cal.getTime()) + ".log";
		MyLogger.logFile = new File(logsFolder.getName(),logname);
		try{
			if(logFile.createNewFile()){
				//New file made
				System.err.println("INFO: Creating new log file");	
			}
		}catch(IOException e){
			System.err.println("ERROR: Cannot create log file");
			System.exit(1);
		}
	}
	
	private MyLogger(){
		if (instance != null){
			throw new IllegalStateException("Cannot instantiate a new singleton instance of log");
		}
		this.createLogFile();
	}

	private static void _log(String message){
		try{
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		   	Calendar cal = Calendar.getInstance();
			FileWriter out = new FileWriter(MyLogger.logFile, true);
			out.write(String.format("%s %s", dateFormat.format(cal.getTime()), message).toCharArray());
			out.close();
		}catch(IOException e){
			System.err.println("ERROR: Could not write to log file");
		}
	}

	public static void log(String message){
		MyLogger.info(message);
	}

	public static void info(String message){
		MyLogger._log(String.format("[INFO] %s%n", message));
	}

	public static void error(String message){
		MyLogger._log(String.format("[ERROR] %s%n", message));
	}

	public static void debug(String message){
		if(MyLogger.isDebugEnabled()) {
		MyLogger._log(String.format("[DEBUG] %s%n", message));
	}
	}
	
	public static boolean isDebugEnabled() {
		return true;
	}
	
	
}