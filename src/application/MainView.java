package application;


import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainView {
	
	private Stage stage;
	private DataView dataView;
	
	public MainView() {
		
		buildUI();
		
		
	}

	private void buildUI() {
		
		stage = new Stage(StageStyle.DECORATED);
		
	
		BorderPane root = new BorderPane();
		
		
		
		dataView = new DataView();
		
		
		
		root.setCenter(dataView);
		
		
		
		Scene scene = new Scene(root,400,400);
		
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		System.out.println("hej");
		stage.setTitle("Display CF values");
		stage.setScene(scene);
		stage.show();
	
		
	}

}
