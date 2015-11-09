import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class WriteFile {
	
	private String _user;
	private String _album;
	private String _loc;
	private String _use;
	private String _future;
	private String _change;
	public WriteFile(String user,String loc, String use, String album ,String future , String change){
		_user = user;
		_loc = loc;
		_use = use;
		_album = album;
		_future = future;
		_change = change;

	
	}
	
	
public void Write(){
	try {
		Properties properties = new Properties();
		properties.setProperty("loc", _loc);
		properties.setProperty("use", _use);
		properties.setProperty("albums", _album);
		properties.setProperty("future", _future);
		properties.setProperty("changes", _change);
		String q = System.getProperty("user.name");
		File file = new File("/Users/" + q +"/Documents/Shred_Nation/Profiles/" + _user + "/Config.properties");
		FileOutputStream fileOut = new FileOutputStream(file);
		properties.store(fileOut, "File");
		fileOut.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
	
	
}