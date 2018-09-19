
import java.jython;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root1 = FXMLLoader.load(getClass().getResource("fxml1.fxml"));
			Scene scene1 = new Scene(root1,700,600);
			primaryStage.setTitle("BookFinder");
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}
		
			
	public static void main(String[] args) {
		try {
		launch(args);
		}catch(Exception e) {
			System.out.println("launch issue");
		}
			}
}
