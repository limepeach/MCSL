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

	String pageNow;
	public class StartPage extends StackPane{
		public StartPage() {
			super();
			Label startPageInfo=new Label("欢迎使用MCSL，目前版本为0.0.0.1");
			StackPane.setAlignment(startPageInfo, Pos.CENTER_RIGHT);
			
		}
	}
	public void refresh() {
		if(pageNow=="Start") {
			
		}
	}

	public void setButtonType(Button menuButton, boolean type) {
		menuButton.setDisable(!type);
		menuButton.setStyle("-fx-opacity: 1;");
	}

	@Override
	public void start(Stage primaryStage) {

//		VBox root = new VBox();
//        root.setId("root");
//        // 引入样式
//        root.getStylesheets().add(Gui.class.getResource("/mcsl/bin/com/mcsl/resource/css/style.css").toString());
//        
//
//        //顶部
//        VBox top = new VBox();
//        top.setId("top");
//        top.setPrefSize(300,26);
//        // 标题栏
//        AnchorPane title = new AnchorPane();
//        Label close = new Label();
//        close.setPrefWidth(33);
//        close.setPrefHeight(26);
//        close.setId("winClose");//winClose css样式Id
//        title.getChildren().add(close);
//        AnchorPane.setRightAnchor(close, 0.0);
//        AnchorPane.setTopAnchor(close, 5.0);
//        top.getChildren().add(title);

		primaryStage.getIcons().add(new Image(Gui.class.getResourceAsStream("/com/mcsl/resouse/pic/ico.png")));
		primaryStage.setTitle("MCSL");
		primaryStage.setWidth(810);
		primaryStage.setHeight(490);
		BorderPane pane = new BorderPane();
		pane.setId("biggest_pane");
		pane.setPadding(new Insets(0, 0, 0, 0));// 下左上右
		pane.setStyle("-fx-background-color: #FFFFF1；-fx-background-image: url(\"/com/mcsl/resouse/pic/background.png\");");// 背景

		Image start_unselected = new Image("/com/mcsl/resouse/pic/start_unselected.png");
		Image start_selected = new Image("/com/mcsl/resouse/pic/start_selected.png");
		Image settings_unselected = new Image("/com/mcsl/resouse/pic/settings_unselected.png");
		Image settings_selected = new Image("/com/mcsl/resouse/pic/settings_selected.png");
		Image run_unselected = new Image("/com/mcsl/resouse/pic/run_unselected.png");
		Image run_selected = new Image("/com/mcsl/resouse/pic/run_selected.png");
		Image manage_unselected = new Image("/com/mcsl/resouse/pic/manage_unselected.png");
		Image manage_selected = new Image("/com/mcsl/resouse/pic/manage_selected.png");
		Button menuButton_Start = new Button("");
		Button menuButton_Manage = new Button("");
		Button menuButton_Run = new Button("");
		Button menuButton_Settings = new Button("");
		menuButton_Start.setGraphic(new ImageView(start_unselected));
		menuButton_Manage.setGraphic(new ImageView(manage_unselected));
		menuButton_Run.setGraphic(new ImageView(run_unselected));
		menuButton_Settings.setGraphic(new ImageView(settings_unselected));
//		final String MENU_UNSELECTED = "-fx-text-fill:#1375D8;-fx-background-color: #FFFFFF;-fx-border-color: #FFFFFF;-fx-border-radius: 20;-fx-background-radius: 20;-fx-pref-width: 100px;-fx-pref-height: 35px;-fx-padding: 6 6 6 6;";
//		final String MENU_SELECTED = "-fx-text-fill:#FFFFFF;-fx-background-color: #1375D8;-fx-border-color: #1375D8;-fx-border-radius: 20;-fx-background-radius: 20;-fx-pref-width: 100px;-fx-pref-height: 35px;-fx-padding: 6 6 6 6;";
//		menuButton_Start.setStyle(MENU_SELECTED);
//		menuButton_Manage.setStyle(MENU_UNSELECTED);
//		menuButton_Run.setStyle(MENU_UNSELECTED);
//		menuButton_Settings.setStyle(MENU_UNSELECTED);

		// 加载默认样式
		menuButton_Start.setId("menu");
		menuButton_Manage.setId("menu");
		menuButton_Run.setId("menu");
		menuButton_Settings.setId("menu");

		// 设置default page
		pageNow = "Start";
		setButtonType(menuButton_Start, false);
		menuButton_Start.setGraphic(new ImageView(start_selected));
		setButtonType(menuButton_Manage, true);
		menuButton_Manage.setGraphic(new ImageView(manage_unselected));
		setButtonType(menuButton_Run, true);
		menuButton_Run.setGraphic(new ImageView(run_unselected));
		setButtonType(menuButton_Settings, true);
		menuButton_Settings.setGraphic(new ImageView(settings_unselected));

		menuButton_Start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Start, false);
				menuButton_Start.setGraphic(new ImageView(start_selected));
				setButtonType(menuButton_Manage, true);
				menuButton_Manage.setGraphic(new ImageView(manage_unselected));
				setButtonType(menuButton_Run, true);
				menuButton_Run.setGraphic(new ImageView(run_unselected));
				setButtonType(menuButton_Settings, true);
				menuButton_Settings.setGraphic(new ImageView(settings_unselected));
				pageNow = "Start";
				refresh();
			}
		});
		menuButton_Manage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Manage, false);
				menuButton_Manage.setGraphic(new ImageView(manage_selected));
				setButtonType(menuButton_Start, true);
				menuButton_Start.setGraphic(new ImageView(start_unselected));
				setButtonType(menuButton_Run, true);
				menuButton_Run.setGraphic(new ImageView(run_unselected));
				setButtonType(menuButton_Settings, true);
				menuButton_Settings.setGraphic(new ImageView(settings_unselected));
				pageNow = "Manage";
				refresh();
			}
		});
		menuButton_Run.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Run, false);
				menuButton_Run.setGraphic(new ImageView(run_selected));
				setButtonType(menuButton_Start, true);
				menuButton_Start.setGraphic(new ImageView(start_unselected));
				setButtonType(menuButton_Manage, true);
				menuButton_Manage.setGraphic(new ImageView(manage_unselected));
				setButtonType(menuButton_Settings, true);
				menuButton_Settings.setGraphic(new ImageView(settings_unselected));
				pageNow = "Run";
				refresh();
			}
		});
		menuButton_Settings.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Settings, false);
				menuButton_Settings.setGraphic(new ImageView(settings_selected));
				setButtonType(menuButton_Start, true);
				menuButton_Start.setGraphic(new ImageView(start_unselected));
				setButtonType(menuButton_Manage, true);
				menuButton_Manage.setGraphic(new ImageView(manage_unselected));
				setButtonType(menuButton_Run, true);
				menuButton_Run.setGraphic(new ImageView(run_unselected));
				pageNow = "Settings";
				refresh();
			}
		});

		HBox menuBox = new HBox(30);
		menuBox.getChildren().addAll(menuButton_Start, menuButton_Manage, menuButton_Run, menuButton_Settings);
		menuBox.setAlignment(Pos.CENTER);
		menuBox.setPrefHeight(50);
		menuBox.setPadding(new Insets(8));
		menuButton_Start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuButton_Manage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuButton_Run.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuButton_Settings.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuBox.setStyle("-fx-background-color: #FFFFFF");
		HBox.setHgrow(menuButton_Start, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Manage, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Run, Priority.ALWAYS);
		HBox.setHgrow(menuButton_Settings, Priority.ALWAYS);
		

		pane.setBottom(menuBox);
		pane.getStylesheets().add(Gui.class.getResource("/com/mcsl/resouse/css/style.css").toString());
//		root.getChildren().addAll(top,pane);

		Scene scene = new Scene(pane, 200, 250);
//		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
