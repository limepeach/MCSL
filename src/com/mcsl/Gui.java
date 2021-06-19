package com.mcsl;

//import jfxtras.styles.jmetro.JMetro;
//import jfxtras.styles.jmetro.Style;
//import jfxtras.styles.jmetro.Style.*;
import javafx.application.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.layout.Pane;

public class Gui extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.getIcons().add(new Image(Gui.class.getResourceAsStream("ico.png")));
		primaryStage.setTitle("MCSL");
		primaryStage.setWidth(810);
		primaryStage.setHeight(490);
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(0,0,0,0));// 下左上右
		GridPane menuPane = new GridPane();

		Button menuButton_Start = new Button("开   始");
		Button menuButton_Manage = new Button("管   理");
		Button menuButton_Run = new Button("运   行");
		Button menuButton_Settings = new Button("设   置");
		menuButton_Start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});
		menuButton_Manage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});
		menuButton_Run.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});
		menuButton_Settings.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

			}
		});

		HBox menuBox = new HBox();
		menuBox.getChildren().addAll(menuButton_Start, menuButton_Manage, menuButton_Run, menuButton_Settings);
		menuBox.setAlignment(Pos.CENTER);
		menuBox.setPrefHeight(80); 
		final String MENU_UNCHOSEN="-fx-text-fill:#FFFFFF;-fx-background-color: #1375D8;-fx-border-color: #1375D8;-fx-border-radius: 20;-fx-background-radius: 20;-fx-pref-width: 100px;-fx-pref-height: 35px;-fx-padding: 6 6 6 6;";
		menuButton_Start.setStyle(MENU_UNCHOSEN);
		menuButton_Manage.setStyle(MENU_UNCHOSEN);
		menuButton_Run.setStyle(MENU_UNCHOSEN);
		menuButton_Settings.setStyle(MENU_UNCHOSEN);
//		menuButton_Start.setGraphic(new ImageView(new Image("start_unselect.png")));
		menuButton_Start.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		menuButton_Manage.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		menuButton_Run.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		menuButton_Settings.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		HBox.setHgrow(menuButton_Start, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Manage, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Run, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Settings, Priority.ALWAYS);
		

		pane.setBottom(menuBox);

		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setScene(scene);
		primaryStage.show();


	}
}
