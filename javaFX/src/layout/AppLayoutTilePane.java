package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppLayoutTilePane extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		
		Scene principal = new Scene(new TesteTilePane(), 800, 600);
		
		primaryStage.setScene(principal);
		primaryStage.setTitle("Gerenciador de Layout TilePane");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
}
