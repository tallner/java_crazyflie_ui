package application;

import crazyflie.CrazyflieModel;
import crazyflie.Logging;
import crazyflie.ParameterHandling;
import database.LoggerObject;
import databaseHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import se.bitcraze.crazyflie.lib.crazyradio.ConnectionData;
import se.bitcraze.crazyflie.lib.crazyradio.Crazyradio;
import javafx.scene.robot.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.scene.input.ScrollEvent;


public class DataView extends VBox {
	/*
	private TableView<String> table = new TableView<String>();
	private TableColumn<String, String> itemColumn;
	*/
	
	
	private Button btnCrazyConnect;
	private Button btnCrazyDisconnect;
	private Button btnCrazyLogStop;
	private Button btnCrazyLogStart;
	private Button btnReadParams;
	private Button btnWriteParam;
	private Button btnToDB;
	
	private TextField parameterName;
	private TextField parameterValue;

	
	private Logging myLogger;
	private ParameterHandling myParameterHandling;
	 
	private Robot myRobo;
	
	private LoggerObject myDBLogger;


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
        CrazyflieModel myCrazyflie = new CrazyflieModel(new ConnectionData(channel, datarate),"nyTråd");
		/*btnMouse = new Button("Mouse");
		btnMouse.setPrefWidth(100);
		*/
        
        // finns canvas i fx för att rita upp
		
		//user cursor
        final Circle circle = new Circle(180, Color.RED);
        circle.setCenterX(400);
        circle.setCenterY(400);
        circle.setCursor(Cursor.CLOSED_HAND);
        double xCent = circle.getCenterX();
        System.out.println(xCent);
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            	myCrazyflie.setCalibrationData((float) myRobo.getMouseX(), (float) myRobo.getMouseY());
            }
        });

        circle.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
             // circle.setCenterX(mouseEvent.getX());
            //  circle.setCenterY(mouseEvent.getY());
             //  System.out.println("X: "+myRobo.getMouseX() + ". Y: " + myRobo.getMouseY());
               
               
               myCrazyflie.setPitch(myRobo.getMouseY());
               myCrazyflie.setRoll(myRobo.getMouseX());
               //float factoredVal = ;
               
               /*
               pitch --> fram tillbaka, positiv höjer nosen dvs backar coptern
               roll --> sidled, positiv lyfter vänstra sidan dvs svänger höger
               yaw --> snurrar runt, positiv snurrar höger
               */
            }
        });
				
        
        circle.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
        	
        	long thrust=15000;
        	@Override
            public void handle(ScrollEvent event) {
                
                
                if (event.getEventType() == ScrollEvent.SCROLL) {
                	thrust += event.getDeltaY() > 0 ? 1000 : -1000;
                //	System.out.println(thrust);
                	
                	myCrazyflie.setThrust(thrust);
                }

            }
        });
        
        
        Text text = new Text("X");
        text.setBoundsType(TextBoundsType.VISUAL); 
        StackPane stack = new StackPane();
        stack.getChildren().addAll(circle, text);
        
		
		HBox hbox1 = new HBox();
		hbox1.setSpacing(10);
		hbox1.setPadding(new Insets(10,10,10,10));
		hbox1.getChildren().addAll(stack);
		hbox1.setAlignment(Pos.CENTER);
		
		
		
		
		btnCrazyConnect = new Button("Connect");
		btnCrazyConnect.setPrefWidth(100);
		btnCrazyConnect.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				myCrazyflie.start();
		    }
		});
		btnCrazyDisconnect = new Button("Disconnect");
		btnCrazyDisconnect.setPrefWidth(100);
		btnCrazyDisconnect.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				myCrazyflie.stop();
		    }
		});
		
		
		btnCrazyLogStart = new Button("LogStart");
		btnCrazyLogStart.setPrefWidth(100);
		btnCrazyLogStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				myLogger = new Logging(myCrazyflie.getCrazyflie());
				myLogger.start();
				
				//LogVals(val,Integer.toString(myLogger.testval));

		    }
		});
		
		btnCrazyLogStop = new Button("LogStop");
		btnCrazyLogStop.setPrefWidth(100);
		btnCrazyLogStop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				myLogger.stop();
		    }
		});
		
		HBox hbox2 = new HBox();
		hbox2.setSpacing(10);
		hbox2.setPadding(new Insets(0,10,10,10));
		hbox2.getChildren().addAll(
				btnCrazyConnect,
				btnCrazyDisconnect,
				btnCrazyLogStart,
				btnCrazyLogStop);
		hbox2.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		parameterName = new TextField();
		parameterName.setPromptText("Parameter name");
		parameterName.setTooltip(new Tooltip("Enter parameter name"));
				
		parameterValue = new TextField();
		parameterValue.setPromptText("Parameter value");
		parameterValue.setTooltip(new Tooltip("Enter parameter value"));
		
		btnReadParams = new Button("ReadPara");
		btnReadParams.setPrefWidth(100);
		btnReadParams.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myParameterHandling = new ParameterHandling(myCrazyflie.getCrazyflie());
				myParameterHandling.start();
		    }
		});
		
		btnWriteParam = new Button("WritePara");
		btnWriteParam.setPrefWidth(100);
		btnWriteParam.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myParameterHandling.setValue(parameterName.getText(), parameterValue.getText());
		    }
		});
		
		/*
		btnToDB = new Button("WriteToDB");
		btnToDB.setPrefWidth(100);
		btnToDB.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				myDBLogger = new LoggerObject(DatabaseHelper.DbConnect("crazylog"));
				myDBLogger.createLog("christian", 44, 44, 44, 44, 44, 44, 44, 44, 44);
		    }
		});*/
		
		HBox hbox3 = new HBox();
		hbox3.setSpacing(10);
		hbox3.setPadding(new Insets(0,10,10,10));
		hbox3.getChildren().addAll(				
				btnReadParams,				
				btnWriteParam,				
				parameterName,				
				parameterValue);
		hbox3.setAlignment(Pos.BOTTOM_CENTER);
		
		
		
		getChildren().addAll(hbox1,hbox2,hbox3);
		
		
	}

	
	
}
