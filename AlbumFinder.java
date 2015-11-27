
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.scene.control.TextField;



public class AlbumFinder{

	private TextField _band;
	private TextField _album;
	private String _user;
	private ArrayList<String> list;
	
	public AlbumFinder(TextField band, TextField album, String user){
		_user = user;
		_band = band;
		_album = album;
	
		
	}

	public ArrayList<String> findMusic() {
		ReadFile fe = new ReadFile(_user);
		
		if(fe.getUse().substring(1,2).equals("1")){
				

				String query = "google play" + " \"" + _band.getText() + " " + _album.getText() + " \"";
				  ArrayList<String> result = new ArrayList<String>();
					String request = "https://www.google.com/search?q=" + query + "&num=20";
					
				 
					try {
				 
						// need http protocol, set this as a Google bot agent :)
						Document doc = Jsoup
							.connect(request)
							.userAgent(
							  "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
							.timeout(5000).get();
				 
						// get all links
						Elements links = doc.select("a[href]");
						
						
						for (Element link : links) {
							
							String temp = link.attr("href");
								
							if(temp.startsWith("/url?q=") && temp.contains("play.google.com")){
				                                //use regex to get domain name
								//System.out.println("\nlink : " + link.attr("href"));
								result.add(link.attr("href"));
							}
						}
				
				String ans = result.get(0);
				ans = result.get(0).substring(7);
				int hold = 0;
				while(ans.charAt(hold) != '&'){
					hold = hold + 1;
				}
				ans = ans.substring(0,hold);
				
				
				int qqq = 0;
				for(int i = 0; i < ans.length(); i ++){
					
					if(ans.charAt(i) == '%'){
						qqq = i;
						break;
					}
					
				}
				String clone = ans;
				
				
				ans = ans.substring(0,qqq) + "?id=";
				
				clone = clone.substring(qqq + 6, qqq + 35);
				clone = clone.substring(2) + "&hl=en";
				ans = ans + clone;	
				
							request = ans;
				 doc = Jsoup
						.connect(request)
						.userAgent(
						  "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
						.timeout(5000).get();
				
				ArrayList<String> fans = new ArrayList<String>();
			
			
				

			try{
			for(int y = 0; y < 100; y++){
				fans.add(doc.select("div.title").get(y).text());
				
			}
			}catch(java.lang.IndexOutOfBoundsException r){
				
			}
			
			for(int p = 0; p < fans.size(); p++){
				if(fans.get(p).equals("Genres")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Total length")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Tracks")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Released")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Label")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("File type")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Access type")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Internet connection")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Playback information")){
					fans.remove(p);
				}
				
				if(fans.get(p).equals("Report")){
					fans.remove(p);
				}
				
				
				
				
			}

			
		


				
			
			list = fans;
				
				
			
			
					} catch (IOException e) {
					
						ArrayList<String> finan = new ArrayList<String>();
						return finan;
					} catch (StringIndexOutOfBoundsException e1){
						
						ArrayList<String> finan = new ArrayList<String>();
						return finan;
					} catch (IndexOutOfBoundsException e2){
						
						ArrayList<String> finan = new ArrayList<String>();
						return finan;
					}
			
		} else{
			ArrayList<String> finan = new ArrayList<String>();
		
			return finan;
			
		}
		return list;
		
	
		
	}

}
