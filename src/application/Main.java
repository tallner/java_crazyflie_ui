package application;


import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main(String[] args) {
        launch(args);
      
    }
	 
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	new MainView();
    	
    	
    	
    }
    
  //System.exit(0) This will close all timers and threads inside the application
    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
        System.exit(0);
    }


    
}