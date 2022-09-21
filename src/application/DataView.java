package application;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import crazyflie.CrazyflieModel;
import crazyflie.MotorRampExample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.LongStringConverter;
import se.bitcraze.crazyflie.lib.crazyflie.Crazyflie.State;
import se.bitcraze.crazyflie.lib.crazyradio.ConnectionData;
import se.bitcraze.crazyflie.lib.crazyradio.Crazyradio;
import javafx.scene.robot.*;
import javafx.scene.shape.Circle;
import javafx.scene.input.ScrollEvent;


public class DataView extends VBox {
	/*
	private TableView<String> table = new TableView<String>();
	private TableColumn<String, String> itemColumn;
	
	private TextField orderDate;
	*/
	private Button btnCrazyConnect;
	private Button btnCrazyDisconnect;
/*	private Button btnFile;
	private Button btnMouse;
	
	private FileChooser fileChooser;*/
	
	private Robot myRobo;
//	private ScrollPane myScroll = new ScrollPane();

	public DataView() {
		BuildUI();
	}

	private void BuildUI() {
	/*	
		table.setEditable(true);
		
		itemColumn = new TableColumn<String, String>("Item");
		itemColumn.setCellValueFactory(new PropertyValueFactory<String, String>("item"));
		itemColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		table.getColumns().add(itemColumn);
		
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.setPrefHeight(1000);
		
		orderDate = new TextField();
		orderDate.setPromptText("Date MM/dd/yyyy");
		Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
		*/
		myRobo = new Robot();
		
		int channel = 80;
        int datarate = Crazyradio.DR_2MPS;
        CrazyflieModel consoleExample = new CrazyflieModel(new ConnectionData(channel, datarate),"nyTråd");
		/*btnMouse = new Button("Mouse");
		btnMouse.setPrefWidth(100);
		*/
		
		//user cursor
        final Circle circle = new Circle(100, Color.RED);
        circle.setCenterX(400);
        circle.setCenterY(400);
        circle.setCursor(Cursor.CLOSED_HAND);
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });

        circle.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               circle.setCenterX(mouseEvent.getX());
               circle.setCenterY(mouseEvent.getY());
               System.out.println("X: "+myRobo.getMouseX() + ". Y: " + myRobo.getMouseY());
               
                
            }
        });
				
        
        circle.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
        	
        	long thrust=25000;
        	@Override
            public void handle(ScrollEvent event) {
                
                
                if (event.getEventType() == ScrollEvent.SCROLL) {
                	thrust += event.getDeltaY() > 0 ? 1000 : -1000;
                	System.out.println(thrust);
                	
                	consoleExample.rampMotors(thrust);
                	
                	/*
                	
                	int channel = 80;
    		        int datarate = Crazyradio.DR_2MPS;
    		        MotorRampExample motorRampExample = new MotorRampExample(
    		        		new ConnectionData(channel, datarate));*/
//    		        		"nyTråd");
    		        //consoleExample.start();
                }
                    
                
               // System.out.println("skrållar");
            }
        });
        
		
		HBox hbox1 = new HBox();
		hbox1.setSpacing(10);
		hbox1.setPadding(new Insets(10,10,10,10));
		hbox1.getChildren().addAll(circle);
		hbox1.setAlignment(Pos.CENTER);
		
		
		
		
		btnCrazyConnect = new Button("Connect");
		btnCrazyConnect.setPrefWidth(100);
		btnCrazyConnect.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
		        consoleExample.start();
		    }
		});
		btnCrazyDisconnect = new Button("Disconnect");
		btnCrazyDisconnect.setPrefWidth(100);
		btnCrazyDisconnect.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
		        consoleExample.stop();
		    }
		});
		/*
		
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
        		new FileChooser.ExtensionFilter("All Files", "*.*"),
        		new FileChooser.ExtensionFilter("CSV", "*.csv"),
        		new FileChooser.ExtensionFilter("JSON", "*.json")	            		
        		);
		
		btnFile = new Button("Open");
		btnFile.setPrefWidth(100);		
		btnFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				File selectedFile = fileChooser.showOpenDialog(null);
	            //readItemsFromFile(selectedFile.getAbsolutePath());  
			}
		});
		*/
		HBox hbox2 = new HBox();
		hbox2.setSpacing(10);
		hbox2.setPadding(new Insets(0,10,10,10));
		hbox2.getChildren().addAll(btnCrazyConnect,btnCrazyDisconnect);
		hbox2.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		
		getChildren().addAll(hbox1,hbox2);
		
		
	}
	
	/*
	public static Thread connectToCF() {
        Thread newThread;
        newThread.setDaemon(true);
        newThread = new Thread(() -> {
        	int channel = 80;
	        int datarate = 2;//Crazyradio.DR_250KPS;
	        

	        ConsoleExample consoleExample = new ConsoleExample(new ConnectionData(channel, datarate),"");
	        
	        
        });

        return newThread;
    }
	*/
	
}
