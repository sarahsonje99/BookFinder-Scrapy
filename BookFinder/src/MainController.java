//import Crawler.*;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController {
	
	Parent root2,root3;
	Scene scene2,scene3;
	public Stage stage;
	
	fileReader filereader = new fileReader();
	readcrawl crawler = new readcrawl();
	
	@FXML
	Button search,search1;
	@FXML
	TextField searchString;	
	@FXML
	ScrollPane scrollpane;
	

		
	public void clickStart() {
		
		stage = (Stage)search.getScene().getWindow();
		
		try {
			root2 = FXMLLoader.load(getClass().getResource("fxml2.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scene2 = new Scene(root2,700,600);
		stage.setScene(scene2);
		stage.show();
	}
	
	public void goToScene2(ActionEvent e){
		clickStart();
	}
	
	
	public void goToExitWindow(ActionEvent e) {
		stage = (Stage)search.getScene().getWindow();
		try {
			root3 = FXMLLoader.load(getClass().getResource("exitWindow.fxml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scene3 = new Scene(root3,700,600);
		stage.setScene(scene3);
		stage.show();
	}
		
	
	public void exitSearch() {
		stage = (Stage)search.getScene().getWindow();
		stage.close();
	}
	
	public void AmazonSearch(ActionEvent e) throws IOException {
		stage = (Stage)search1.getScene().getWindow();
		Text t = new Text();
		t.setText("");
		scrollpane.setContent(t);
		crawler.AmazonCrawl(searchString.getText());
		//use 'searchString.getText()' as keyphrase
		try{
		t.setText(filereader.readIt("/home/shloka/Desktop/crawler/opAmazon.csv"));
		scrollpane.setContent(t);
		}catch(Exception e1) {System.out.println(e1);}
						
	}
	
	public void FlipKartSearch(ActionEvent e) throws IOException {
		stage = (Stage)search1.getScene().getWindow();
		Text t = new Text();
		t.setText("");
		scrollpane.setContent(t);
		crawler.FlipkartCrawl(searchString.getText());
		//use 'searchString.getText()' as keyphrase
		try{
		t.setText(filereader.readIt("/home/shloka/Desktop/crawler/opFlipkart.csv"));
		scrollpane.setContent(t);
		}catch(Exception e1) {System.out.println(e1);}
						
	}
	
	
	public void eBaySearch(ActionEvent e) throws IOException {
		stage = (Stage)search1.getScene().getWindow();
		Text t = new Text();
		t.setText("");
		scrollpane.setContent(t);
		crawler.eBayCrawl(searchString.getText());
		//use 'searchString.getText()' as keyphrase
		try{
		t.setText(filereader.readIt("/home/shloka/Desktop/crawler/opEbay.csv"));
		scrollpane.setContent(t);
		}catch(Exception e1) {System.out.println(e1);}
						
	}
	
	//read to tableview
	
	
	
	
	
	

}
