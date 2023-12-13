package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLayoutStackPane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		
		Scene principal = new Scene(new TesteStackPane(), 800, 600);
		
		primaryStage.setScene(principal);
		primaryStage.setTitle("Gerenciador de Layout StackPane");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
}
