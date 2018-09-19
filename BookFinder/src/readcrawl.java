//import jython.*;
import java.io.*;
public class readcrawl {

	
	    public void AmazonCrawl(String key){
	    	    try {
	                Process p = Runtime.getRuntime().exec("/home/shloka/Desktop/Amazonshell.sh "+key);
	                BufferedReader in = new BufferedReader(new InputStreamReader(
	                        p.getInputStream()));
	                System.out.println(in.readLine());
	            } catch (Exception e) { e.printStackTrace(); }
	    }  
	    
	    public void FlipkartCrawl(String key){
    	    try {
                Process p = Runtime.getRuntime().exec("/home/shloka/Desktop/Flipkartshell.sh "+key);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
                System.out.println(in.readLine());
            } catch (Exception e) { e.printStackTrace(); }
    }  
	    public void eBayCrawl(String key){
    	    try {
                Process p = Runtime.getRuntime().exec("/home/shloka/Desktop/Ebayshell.sh "+key);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
                System.out.println(in.readLine());
            } catch (Exception e) { e.printStackTrace(); }
    }  
	    
	    
	
}