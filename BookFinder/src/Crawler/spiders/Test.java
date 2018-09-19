package Crawler;
import java.io.*;
public class Test {
	public static void searchAmazon(String keyword)
	{
		try 
		{
			//String keyword="Engineering Mathematics";
		
			
        	Process p = Runtime.getRuntime().exec("scrapy crawl amazon -o opAmazon.csv -a category="+keyword);
        	BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        	System.out.println(in.readLine());
        	
        	
    	} catch (Exception e) 
    	{
    		System.out.println("Error in searching Amazon crawler");
    	}
	}

	
	public static void searhFlipKart(String keyword)
	{
		try 
		{
        	Process p = Runtime.getRuntime().exec("scrapy crawl flipkart -o opFlipKart.csv -a category="+keyword);
        	BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        	System.out.println(in.readLine());
    	} catch (Exception e) 
    	{
    		System.out.println("Error in searching FlipKart crawler");
    	}
	}
	public static void searhEbay(String keyword)
	{
		try 
		{
        	Process p = Runtime.getRuntime().exec("scrapy crawl ebay -o opEbay.csv -a category="+keyword);
        	BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        	System.out.println(in.readLine());
    	} catch (Exception e) 
    	{
    		System.out.println("Error in searching ebay crawler");
    	}
	}

}
