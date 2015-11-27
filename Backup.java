import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;

public class Backup {
	private String _user;
	public Backup(String user){
		_user = user;
	}
	
	public void doit(){
		ReadFile fe = new ReadFile(_user);
		String q = System.getProperty("user.name");
		String path = "/Users/" + q + "/Documents/Shred_Nation/Profiles/" + _user + "/backup";
		File theDir = new File(path);
		if (!theDir.exists()) {
		 
		        theDir.mkdir();    
		     }
		
	Calendar cal = Calendar.getInstance();
		String time = Integer.toString(cal.get(Calendar.MONTH) + 1) +"-" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"-" + Integer.toString(cal.get(Calendar.YEAR)) +"-" + Integer.toString(cal.get(Calendar.HOUR)) +"-" + Integer.toString(cal.get(Calendar.MINUTE)) +"-" + Integer.toString(cal.get(Calendar.SECOND));
		
		path = path + "/" + time;
		File theDirr = new File(path);
		if (!theDirr.exists()) {
		 
		        theDirr.mkdir();    
		     }
		
		File file1 = new File(fe.getLoc());
		
		File file2 = new File("/Users/" + q + "/Documents/Shred_Nation/Profiles/" + _user + "/config.properties");
		File file11 = new File(path + "/file.ser");
		
		File file22 = new File(path + "/config.properties");
		try {
			Files.copy( file1.toPath(), file11.toPath());
			Files.copy( file2.toPath(), file22.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
