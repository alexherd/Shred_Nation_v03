import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ReadFile {
	private String _user;
	
	public ReadFile(String user) {
		_user = user;
	}
	
	public String getFuture(){
		String value = "hi";
		try {
			
				
			
			String q = System.getProperty("user.name");

			File file = new File("/Users/" + q +"/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			
			properties.load(fileInput);
			fileInput.close();
			
			Enumeration enuKeys = properties.keys();
			
				String key = (String) enuKeys.nextElement();
				value = properties.getProperty(key);
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	
	public String getUse(){
		String value = "hi";
		try {
			
			//use is just a string for 10 options per char ex 110, this is for options such as if char 1 is 0 then the user never loged on before, if 1 they have been on before. If char 2 is 0 autofind is off, if 1 then its on etc... list below
			//use 1: 1 if user has logged on before, 0 if not
			//use 2: 1 if autofind is on, 0 if not
			//use 3: Background changing
			
			
			String q = System.getProperty("user.name");

			
			File file = new File("/Users/" + q +"/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			
			Enumeration enuKeys = properties.keys();
			
				String key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				value = properties.getProperty(key);
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	public String getAlbum(){
		String value = "hi";
		try {
			String q = System.getProperty("user.name");

			File file = new File("/Users/" + q +"/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
		
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			
			Enumeration enuKeys = properties.keys();
			
				String key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				value = properties.getProperty(key);
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	public String getChange(){
		String value = "hi";
		try {
			String q = System.getProperty("user.name");

			File file = new File("/Users/" + q +"/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
		
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			
			Enumeration enuKeys = properties.keys();
			
				String key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				value = properties.getProperty(key);
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	public String getLoc(){
		String value = "hi";
		try {
			String q = System.getProperty("user.name");

			File file = new File("/Users/" + q +"/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
		
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			
			Enumeration enuKeys = properties.keys();
			
				String key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				key = (String) enuKeys.nextElement();
				value = properties.getProperty(key);
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return value;
	}
	
	
}