package com.mcsl;


import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;

public class Gui extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}




////	窗口拖拉拽用
//	private static boolean isRight;// 是否处于右边界调整窗口状态
//	private static boolean isLeft;// 是否处于左边界调整窗口状态
//	private static boolean isUp;// 是否处于上边界调整窗口状态
//	private static boolean isBottom;// 是否处于下边界调整窗口状态
//	private static boolean isBottomRight;// 是否处于右下角调整窗口状态
//	private final static int RESIZE_WIDTH = 5;// 判定是否为调整窗口状态的范围与边界距离
//	private final static double MIN_WIDTH = 810;// 窗口最小宽度
//	private final static double MIN_HEIGHT = 490;// 窗口最小高度

	Pane page = new Pane();
	BorderPane pane = new BorderPane();
	String pageNow;





	public static class StartPage extends AnchorPane {
		public StartPage() {
			super();
			this.setStyle("-fx-background-color:rgba(255, 255, 255, .0);");
			Label startPageInfo = new Label(
					"	当前版本为0.0.0.1\r\n"
							+ "	目前MCSL任然处于内测中\r\n"
							+ "	功能不甚完善\r\n"
							+ "	有什么建议欢迎添加交流群\r\n"
							+ "	群号：857934957\r\n"
							+ "	感谢各位赞助者们！\r\n");
			startPageInfo.setStyle("-fx-text-fill:#000000;"
					+ "-fx-background-color: rgba(255, 255, 255, .8);"
					+ "-fx-border-color: #000000;"
					+ "-fx-border-radius: 5px;"
					+ "-fx-background-radius: 5px;"
					+ "-fx-font-size: 15px;"
					+ "-fx-pref-width: 300px;"
					+ "-fx-pref-height: 200px;"
					+ "-fx-padding: 6 6 6 6;");
			this.getChildren().add(startPageInfo);
			AnchorPane.setTopAnchor(startPageInfo, 40.0);
			AnchorPane.setLeftAnchor(startPageInfo, 40.0);
			AnchorPane.setRightAnchor(startPageInfo, 40.0);

		}
	}

	public class ManagePage extends AnchorPane {
		class ServerView extends HBox {
			public ServerView(Server currentServer) {
				super(20);
				this.setStyle("-fx-text-fill:#000000;"
						+ "-fx-background-color: rgba(255, 255, 255, .8);"
						+ "-fx-border-color: #000000;"
						+ "-fx-border-radius: 5px;"
						+ "-fx-background-radius: 5px;"
						+ "-fx-font-size: 20px;");
				this.setPadding(new Insets(0, 5, 0, 5));
				Button showCondition = new Button();
				showCondition.setStyle("-fx-background-color: rgba(255, 255, 255, .0);");
				showCondition.setGraphic(new ImageView(currentServer.serverIcon));
				showCondition.setDisable(true);
				Label showName = new Label(currentServer.getServerName());
				showName.setPrefHeight(40);
				showName.setMaxWidth(Double.MAX_VALUE);
				showName.prefWidthProperty().bind(page.widthProperty());
				VBox.setVgrow(showName, Priority.ALWAYS);
				Button settingsButton = new Button();
				this.getChildren().addAll(showCondition, showName, settingsButton);
				this.prefWidthProperty().bind(page.widthProperty());
			}
		}

		public ManagePage() {
			super();
			VBox serverListView = new VBox(20);
//			this.setStyle("-fx-background-color:#FFFFFF");//调试用-显示范围
			serverListView.setStyle("-fx-text-fill:#000000;"
					+ "-fx-background-color: rgba(255, 255, 255, .8);"
					+ "-fx-border-color: #000000;"
					+ "-fx-border-radius: 5px;"
					+ "-fx-background-radius: 5px;"
					+ "-fx-font-size: 15px;");
			serverListView.setSpacing(2);
//			this.setPadding(new Insets(5, 5, 5, 5));
			this.getChildren().add(serverListView);
			this.prefHeightProperty().bind(page.heightProperty());
			this.prefWidthProperty().bind(page.widthProperty());
			AnchorPane.setTopAnchor(serverListView, null);
			AnchorPane.setLeftAnchor(serverListView, null);
			AnchorPane.setBottomAnchor(serverListView, null);
			AnchorPane.setRightAnchor(serverListView, null);

			serverListView.setPadding(new Insets(0));
			for(Server i:Server.serverList){
				serverListView.getChildren().add(new ServerView(i));
			}

			Button newServer = new Button();
			newServer.setStyle("-fx-background-color: rgba(255, 255, 255, .0);");
			newServer.setGraphic(new ImageView(new Image("/com/mcsl/resource/pic/new.png", 50, 50, false, true)));
			this.getChildren().add(newServer);
			AnchorPane.setBottomAnchor(newServer, 30.0);
			AnchorPane.setRightAnchor(newServer, 30.0);

		}
	}

	public void setButtonType(Button menuButton, boolean type) {
		menuButton.setDisable(type);
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



		Server.serverList.add(new Server("ServerA"));
		Server.serverList.add(new Server("ServerA"));

		primaryStage.getIcons().add(new Image("/com/mcsl/resource/pic/ico.png"));
		primaryStage.setTitle("MCSL");
		primaryStage.setWidth(810);
		primaryStage.setHeight(490);
		primaryStage.setMinWidth(810);
		primaryStage.setMinHeight(490);


		pane.setId("biggest_pane");
		pane.setPadding(new Insets(0, 0, 0, 0));// 下左上右
		pane.setStyle("-fx-background-color:rgba(255, 255, 255, .0);");// 背景


//		BackgroundImage myBI= new BackgroundImage(new Image("/com/mcsl/resource/pic/background2.png",810,490,false,false),
//		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//		          BackgroundSize.DEFAULT);
//		//then you set to your node
//		pane.setBackground(new Background(myBI));
//		//老的背景实现

		HBox head=new HBox(20);
		head.prefWidthProperty().bind(pane.widthProperty());
		head.setPadding(new Insets(8));
		head.setAlignment(Pos.CENTER);
		head.setStyle("-fx-background-color:rgba(19, 117, 216, .5);");
		ImageView MCSLLogo=new ImageView(new Image("/com/mcsl/resource/pic/MCSL.png",60,20,false,true));
		head.getChildren().add(MCSLLogo);
		HBox headButton=new HBox();
		headButton.setSpacing(5);
		Label sep = new Label();
		sep.prefWidthProperty().bind(page.widthProperty());
		head.getChildren().add(sep);
		Button headButton_Minimize=new Button();
		Button headButton_Close=new Button();
		headButton_Minimize.setId("head");
		headButton_Close.setId("head");
		headButton_Minimize.setGraphic(new ImageView(new Image("/com/mcsl/resource/pic/minimize.png", 12, 12, false, true)));
		headButton_Close.setGraphic(new ImageView(new Image("/com/mcsl/resource/pic/close.png", 12, 12, false, true)));
		headButton_Minimize.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage)headButton_Minimize.getScene().getWindow();
				stage.setIconified(true);
			}
		});
		headButton_Close.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage)headButton_Close.getScene().getWindow();
				stage.close();
				//close server and work
				Platform.exit();
			}
		});
		headButton.getChildren().addAll(headButton_Minimize,headButton_Close);
		head.getChildren().add(headButton);




		Image start_unselected = new Image("/com/mcsl/resource/pic/start_unselected.png", 30, 30, false, true);
		Image start_selected = new Image("/com/mcsl/resource/pic/start_selected.png", 30, 30, false, true);
		Image settings_unselected = new Image("/com/mcsl/resource/pic/settings_unselected.png", 30, 30, false, true);
		Image settings_selected = new Image("/com/mcsl/resource/pic/settings_selected.png", 30, 30, false, true);
		Image run_unselected = new Image("/com/mcsl/resource/pic/run_unselected.png", 30, 30, false, true);
		Image run_selected = new Image("/com/mcsl/resource/pic/run_selected.png", 30, 30, false, true);
		Image manage_unselected = new Image("/com/mcsl/resource/pic/manage_unselected.png", 30, 30, false, true);
		Image manage_selected = new Image("/com/mcsl/resource/pic/manage_selected.png", 30, 30, false, true);
		//加载菜单按钮图片资源
		Button menuButton_Start = new Button("");
		Button menuButton_Manage = new Button("");
		Button menuButton_Run = new Button("");
		Button menuButton_Settings = new Button("");
		menuButton_Start.setGraphic(new ImageView(start_unselected));
		menuButton_Manage.setGraphic(new ImageView(manage_unselected));
		menuButton_Run.setGraphic(new ImageView(run_unselected));
		menuButton_Settings.setGraphic(new ImageView(settings_unselected));
		//设置按钮
		menuButton_Start.setId("menu");
		menuButton_Manage.setId("menu");
		menuButton_Run.setId("menu");
		menuButton_Settings.setId("menu");
		// 加载默认样式

		page.setStyle("-fx-background-color:rgba(255, 255, 255, .0);");
		//设置背景透明

		pageNow = "Start";
		setButtonType(menuButton_Start, true);
		menuButton_Start.setGraphic(new ImageView(start_selected));
		setButtonType(menuButton_Manage, false);
		menuButton_Manage.setGraphic(new ImageView(manage_unselected));
		setButtonType(menuButton_Run, false);
		menuButton_Run.setGraphic(new ImageView(run_unselected));
		setButtonType(menuButton_Settings, false);
		menuButton_Settings.setGraphic(new ImageView(settings_unselected));
		page.getChildren().clear();
		page.getChildren().add(new StartPage());

		menuButton_Start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Start, true);
				menuButton_Start.setGraphic(new ImageView(start_selected));
				setButtonType(menuButton_Manage, false);
				menuButton_Manage.setGraphic(new ImageView(manage_unselected));
				setButtonType(menuButton_Run, false);
				menuButton_Run.setGraphic(new ImageView(run_unselected));
				setButtonType(menuButton_Settings, false);
				menuButton_Settings.setGraphic(new ImageView(settings_unselected));
				pageNow = "Start";
				page.getChildren().clear();
				page.getChildren().add(new StartPage());

			}
		});
		menuButton_Manage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Manage, true);
				menuButton_Manage.setGraphic(new ImageView(manage_selected));
				setButtonType(menuButton_Start, false);
				menuButton_Start.setGraphic(new ImageView(start_unselected));
				setButtonType(menuButton_Run, false);
				menuButton_Run.setGraphic(new ImageView(run_unselected));
				setButtonType(menuButton_Settings, false);
				menuButton_Settings.setGraphic(new ImageView(settings_unselected));
				pageNow = "Manage";
				page.getChildren().clear();
				page.getChildren().add(new ManagePage());
			}
		});
		menuButton_Run.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Run, true);
				menuButton_Run.setGraphic(new ImageView(run_selected));
				setButtonType(menuButton_Start, false);
				menuButton_Start.setGraphic(new ImageView(start_unselected));
				setButtonType(menuButton_Manage, false);
				menuButton_Manage.setGraphic(new ImageView(manage_unselected));
				setButtonType(menuButton_Settings, false);
				menuButton_Settings.setGraphic(new ImageView(settings_unselected));
				pageNow = "Run";
				page.getChildren().clear();
			}
		});
		menuButton_Settings.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setButtonType(menuButton_Settings, true);
				menuButton_Settings.setGraphic(new ImageView(settings_selected));
				setButtonType(menuButton_Start, false);
				menuButton_Start.setGraphic(new ImageView(start_unselected));
				setButtonType(menuButton_Manage, false);
				menuButton_Manage.setGraphic(new ImageView(manage_unselected));
				setButtonType(menuButton_Run, false);
				menuButton_Run.setGraphic(new ImageView(run_unselected));
				pageNow = "Settings";
				page.getChildren().clear();
			}
		});

		HBox menuBox = new HBox(40);
		menuBox.getChildren().addAll(menuButton_Start, menuButton_Manage, menuButton_Run, menuButton_Settings);
		menuBox.setAlignment(Pos.CENTER);
		menuBox.setPadding(new Insets(5));
		menuButton_Start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuButton_Manage.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuButton_Run.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuButton_Settings.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		menuBox.setStyle("-fx-background-color: #FFFFFF;-fx-opacity: 0.6;");
//		HBox.setHgrow(menuButton_Start, Priority.ALWAYS);
//		HBox.setHgrow(menuButton_Manage, Priority.ALWAYS);
//		HBox.setHgrow(menuButton_Run, Priority.ALWAYS);
//		HBox.setHgrow(menuButton_Settings, Priority.ALWAYS);
		menuButton_Start.prefWidthProperty().bind(menuBox.widthProperty().divide(8));
		menuButton_Manage.prefWidthProperty().bind(menuBox.widthProperty().divide(8));
		menuButton_Run.prefWidthProperty().bind(menuBox.widthProperty().divide(8));
		menuButton_Settings.prefWidthProperty().bind(menuBox.widthProperty().divide(8));


		AnchorPane backgroundPane = new AnchorPane();
		Label backgroundLabel = new Label();
		ImageView backgroundImageView = new ImageView(new Image(getClass().getResourceAsStream("/com/mcsl/resource/pic/background1.png")));
		backgroundImageView.fitHeightProperty().bind(pane.widthProperty());
		backgroundImageView.fitWidthProperty().bind(pane.widthProperty());
		backgroundLabel.setGraphic(backgroundImageView);
		//背景实现

		backgroundPane.getChildren().add(backgroundLabel);
		AnchorPane.setTopAnchor(backgroundLabel, (double) 0);
		AnchorPane.setLeftAnchor(backgroundLabel, (double) 0);
		AnchorPane.setRightAnchor(backgroundLabel, (double) 0);
		AnchorPane.setBottomAnchor(backgroundLabel, (double) 0);
		backgroundPane.getChildren().add(pane);
		AnchorPane.setTopAnchor(pane, (double) 0);
		AnchorPane.setLeftAnchor(pane, (double) 0);
		AnchorPane.setRightAnchor(pane, (double) 0);
		AnchorPane.setBottomAnchor(pane, (double) 0);

		pane.setTop(head);
		pane.setBottom(menuBox);
		pane.setCenter(page);
		pane.getStylesheets().add(Gui.class.getResource("/com/mcsl/resource/css/style.css").toString());
//		root.getChildren().addAll(top,pane);

		Scene scene = new Scene(backgroundPane);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);

////		窗口拖拉拽
//			backgroundPane.setOnMouseMoved((MouseEvent event) -> {
//			event.consume();
//			double x = event.getSceneX();
//			double y = event.getSceneY();
//			double width = primaryStage.getWidth();
//			double height = primaryStage.getHeight();
//			Cursor cursorType = Cursor.DEFAULT;// 鼠标光标初始为默认类型，若未进入调整窗口状态，保持默认类型
//			// 先将所有调整窗口状态重置
//			isRight = isLeft = isUp = isBottom = isBottomRight = false;
//			if (y >= height - RESIZE_WIDTH) {
//				if (x <= RESIZE_WIDTH) {// 左下角调整窗口状态
//
//				} else if (x >= width - RESIZE_WIDTH) {// 右下角调整窗口状态
//					isBottomRight = true;
//					cursorType = Cursor.SE_RESIZE;
//				} else {// 下边界调整窗口状态
//					isBottom = true;
//					cursorType = Cursor.S_RESIZE;
//				}
//			} else if (x >= width - RESIZE_WIDTH) {// 右边界调整窗口状态
//				isRight = true;
//				cursorType = Cursor.E_RESIZE;
//			}
//			// 最后改变鼠标光标
//			backgroundPane.setCursor(cursorType);
//		});
//		backgroundPane.setOnMouseDragged((MouseEvent event) -> {
//			double x = event.getSceneX();
//			double y = event.getSceneY();
//			// 保存窗口改变后的x、y坐标和宽度、高度，用于预判是否会小于最小宽度、最小高度
//			double nextX = primaryStage.getX();
//			double nextY = primaryStage.getY();
//			double nextWidth = primaryStage.getWidth();
//			double nextHeight = primaryStage.getHeight();
//			if (isRight || isBottomRight) {// 所有右边调整窗口状态
//				nextWidth = x;
//			}
//			if (isRight || isBottomRight) {// 所有右边调整窗口状态
//				nextWidth = x;
//			}
//			if (isBottomRight || isBottom) {// 所有下边调整窗口状态
//				nextHeight = y;
//			}
//			if (isBottomRight || isBottom) {// 所有下边调整窗口状态
//				nextHeight = y;
//			}
//			if (nextWidth <= MIN_WIDTH) {// 如果窗口改变后的宽度小于最小宽度，则宽度调整到最小宽度
//				nextWidth = MIN_WIDTH;
//			}
//			if (nextHeight <= MIN_HEIGHT) {// 如果窗口改变后的高度小于最小高度，则高度调整到最小高度
//				nextHeight = MIN_HEIGHT;
//			}
//			// 最后统一改变窗口的x、y坐标和宽度、高度，可以防止刷新频繁出现的屏闪情况
//			primaryStage.setX(nextX);
//			primaryStage.setY(nextY);
//			primaryStage.setWidth(nextWidth);
//			primaryStage.setHeight(nextHeight);
//		});

		primaryStage.show();

	}
}
