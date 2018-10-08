import java.io.*;
public class azain {

	public static void main(String[] args) {
		
		    try {
		        Process p = Runtime.getRuntime().exec("cd crawler && scrapy crawl amazon -o output.csv");
		        BufferedReader in = new BufferedReader(new InputStreamReader(
		                p.getInputStream()));
		        System.out.println(in.readLine());
		    } catch (Exception e) {
		    }
		}

		


	}



