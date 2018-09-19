//package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {
                                
	public String readIt(String string) throws IOException {
		File file = new File(string);
    	FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        StringBuffer cBuf = new StringBuffer();
		try {
		    String line = null;
		    line = br.readLine();
		    while ((line = br.readLine()) != null) {
		    	try {
		        String[] bookup = line.split(",");
		        cBuf.append("\n");
		        cBuf.append(bookup[2]+" \t\t "+bookup[0]+"\t\t");
		    	}catch(Exception e) {}
		    }
		} catch (IOException x) {
		    System.err.println(x);
		} finally {
		    if (reader != null) 
		    	reader.close();
		}
		return cBuf.toString();
		}
	        
	        
}


