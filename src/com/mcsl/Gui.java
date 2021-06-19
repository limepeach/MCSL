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
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(0,0,0,0));// 下左上右
		GridPane menuPane = new GridPane();

		Button menuButton_Start = new Button("开始");
		Button menuButton_Manage = new Button("管理");
		Button menuButton_Run = new Button("运行");
		Button menuButton_Settings = new Button("设置");
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

		HBox hBox = new HBox();

		hBox.getChildren().addAll(menuButton_Start, menuButton_Manage, menuButton_Run, menuButton_Settings);
		hBox.setAlignment(Pos.CENTER);
		menuButton_Start.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		menuButton_Manage.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		menuButton_Run.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		menuButton_Settings.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
		HBox.setHgrow(menuButton_Start, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Manage, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Run, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Settings, Priority.ALWAYS);
		

		pane.setBottom(hBox);

		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setScene(scene);
		primaryStage.show();


	}
}
