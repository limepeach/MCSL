package com.mcsl;


import javafx.application.*;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.*;
import javafx.event.*;
import com.mcsl.Server.*;


import java.io.File;

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

//	ScrollPane superPage=new ScrollPane();
	BorderPane pane = new BorderPane();
	VBox mainPart=new VBox();
	Pane page = new Pane();
	HBox menuBox = new HBox(40);
	String pageNow;
	Stage theStage;

	/**
	 * 一个普通的按钮
	 */
	public class CommonButton extends Button{
		public CommonButton(){
			super();
			preload();
		}
		public CommonButton(String text){
			super(text);
			preload();
		}
		public CommonButton(String text,Node graphic){
			super(text,graphic);
			preload();
		}
		private void preload(){
			this.setId("commonButton");
		}
	}
//	public class ScrollBarPane1 extends ScrollPane{
//		@Override
//		public ObservableList<Node> getChildren() {
//			return super.getChildren();
//		}
//	}

//	public class ScrollBarPane extends ScrollPane
//	{
//		public Pane pane;
//
//		public BorderPane selfPane; // 自身用的面板
//
//
//
//		public ScrollBar hBar; // 横向滚动条
//		public ScrollBar vBar; // 纵向滚动条
//
//		@Override
//		public ObservableList<Node> getChildren() {
//			return super.getChildren();
//		}
//
//		public ScrollBarPane()
//		{
//			super();
//
//			// 设置滚动面板不使用内置的滚动条
//			this.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//			this.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//			this.setStyle("-fx-background-color:rgba(255,255,255,.0);");
//
//			// 滚动面板的背景颜色
////		scrollPane.setBackground(new Background(new BackgroundFill(Conver.hexColorStrToColor("EBEBEB"), null, null)));
//
//
//			selfPane = new BorderPane();
//
//			hBar = new ScrollBar();
//			hBar.valueProperty().addListener(new ChangeListener<Number>()
//			{
//				@Override
//				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
//				{
//					setHvalue(newValue.doubleValue() / 100);
//				}
//			});
//
//			vBar = new ScrollBar();
//			vBar.valueProperty().addListener(new ChangeListener<Number>()
//			{
//				@Override
//				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
//				{
//					setVvalue(newValue.doubleValue() / 100);
//				}
//			});
//
//			// 显示为纵向的滚动条
//			vBar.setOrientation(Orientation.VERTICAL);
//
//			// BorderPane下面和右边放滚动条, 中间放滚动面板
//			selfPane.setRight(vBar);
//			selfPane.setBottom(hBar);
//			selfPane.setCenter(this);
//
//			this.setHVBarLength(50);
//			this.setHBarSize(300, 25);
//			this.setVBarSize(25, 300);
//		}
//		/**
//		 * 设置横向、纵向滚动条按钮的长度
//		 */
//		public void setHVBarLength(int length)
//		{
//			hBar.setVisibleAmount(length);
//			vBar.setVisibleAmount(length);
//		}
//		/**
//		 * 设置横向滚动条的大小
//		 */
//		public void setHBarSize(int width, int height)
//		{
//			hBar.setPrefSize(width, height);
//		}
//
//		/**
//		 * 设置纵向滚动条的大小
//		 */
//		public void setVBarSize(int width, int height)
//		{
//			vBar.setPrefSize(width, height);
//		}
//	}

	/**
	 * 选择一个目录
	 * 使用文件资源管理器
	 * @return 返回目录的路径(String)
	 */
	public String getPath(){
		DirectoryChooser directoryChooser=new DirectoryChooser();
		File file = directoryChooser.showDialog(theStage);
		return file.getPath();
	}

	/**
	 * 开始页面
	 */
	public class StartPage extends AnchorPane {
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
	/**
	 * 管理页面
	 */
	public class ManagePage extends AnchorPane {
		/**
		 * 每一个服务端的显示
		 */
		class ServerView extends HBox {
			public ServerView(Server currentServer) {
				super(20);
				this.setStyle("-fx-text-fill:#000000;"
						+ "-fx-background-color: rgba(255, 255, 255, .8);"
						+ "-fx-border-color: #000000;"
						+ "-fx-border-radius: 5px;"
						+ "-fx-background-radius: 5px;"
						+ "-fx-font-size: 15px;");
				this.setPadding(new Insets(0, 5, 0, 5));
				//!!
				currentServer.setServerCondition(Server.ServerConditionType.READY);
				//!!
				Button showCondition = new Button();
				showCondition.setStyle("-fx-background-color: rgba(255, 255, 255, .0);");
				showCondition.setGraphic(new ImageView(currentServer.serverIcon));
				showCondition.setDisable(true);
				showCondition.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					}
				});
				Label showName = new Label(currentServer.getServerName());
				showName.setPrefHeight(30);
				showName.setMaxWidth(Double.MAX_VALUE);
				showName.prefWidthProperty().bind(page.widthProperty());
				VBox.setVgrow(showName, Priority.ALWAYS);
				Button settingsButton = new Button();
				settingsButton.setStyle("-fx-background-color: rgba(255, 255, 255, .0);");
				settingsButton.setGraphic(new ImageView(new Image("/com/mcsl/resource/pic/setting.png")));
				settingsButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					}
				});
				this.getChildren().addAll(showCondition, showName);
				if(currentServer.getServerCondition()== Server.ServerConditionType.READY){
					this.getChildren().add(settingsButton);
				}
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
			for (Server i : Server.serverList) {
				serverListView.getChildren().add(new ServerView(i));
			}

			Button newServer = new Button();
			newServer.setStyle("-fx-background-color: rgba(255, 255, 255, .0);");
			newServer.setGraphic(new ImageView(new Image("/com/mcsl/resource/pic/new.png", 50, 50, false, true)));
//			newServer.setTooltip(new Tooltip("新建服务端"));
			newServer.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					pane.setCenter(new NewServer());
				}
			});
			this.getChildren().add(newServer);
			AnchorPane.setBottomAnchor(newServer, 30.0);
			AnchorPane.setRightAnchor(newServer, 30.0);

		}
	}
	/**
	 * 新建服务端
	 */
	public class NewServer extends VBox{
		Server theNewServer=new Server();
		Pane newServerPage=new Pane();
		Label stepName=new Label();
		final int labelWidth=100;
		/**
		 * 清空页面
		 */
		private void clear(){
			newServerPage.getChildren().clear();
			newServerPage.prefWidthProperty().bind(pane.widthProperty());
			newServerPage.prefHeightProperty().bind(pane.heightProperty().add(-67));
		}
		/**
		 * 扩大getChild的范围以使得内部类能够访问
		 */
		private ObservableList<Node> getChild() {
			return newServerPage.getChildren();
		}
		public void add(Node node){

		}
		private ReadOnlyDoubleProperty pageWidth=this.prefWidthProperty();
		private ReadOnlyDoubleProperty pageHeight=this.prefHeightProperty();
//		/**
//		 * 行间隔符
//		 */
//		public class Separation extends Label{
//			public Separation(){
//				super();
//			}
//		}
		/**
		 * 页面结尾间隔符
		 */
		public class EndSeparation extends Label{

			public EndSeparation(){
				super();
			}
			public EndSeparation(int height){
				super();
				this.prefHeightProperty().bind(newServerPage.heightProperty().add(-70).add(-height));
			}
		}
		/**
		 * 下一页按钮
		 */
		class NextPage extends HBox{
			class NextPageButton extends Button{
				public NextPageButton(){
					super();
					this.setStyle(
							"-fx-text-fill:#FFFFFF;" +
									"-fx-background-color: #1375D8;" +
									"-fx-border-color: #000000;" +
									"-fx-pref-width: 60px;" +
									"-fx-pref-height: 30px;" +
									"-fx-border-radius: 5;" +
									"-fx-background-radius: 5;");
					this.setText("下一步");
				}
			}
			public NextPageButton nextPageButton=new NextPageButton();
			public NextPage(){
				super();
				this.setAlignment(Pos.BOTTOM_RIGHT);
				this.getChildren().add(nextPageButton);
			}
		}
		/**
		 * 选择服务端类型(下拉框)
		 */
		class setServerType extends ChoiceBox<Object> {
			ServerType_String serverType;
			public setServerType(){
				super();
				this.setItems(FXCollections.observableArrayList(
						ServerType_String.VANILLA,
						ServerType_String.BUKKIT,
						ServerType_String.SPIGOT,
						ServerType_String.PAPER,
						ServerType_String.CAT_SERVER,
						ServerType_String.SPONGE,
						ServerType_String.CARPET,
						ServerType_String.BUNGEE_CORD,
						ServerType_String.WATERFALL));

				final Server.ServerType_String[] showType = {
						ServerType_String.VANILLA,
						ServerType_String.BUKKIT,
						ServerType_String.SPIGOT,
						ServerType_String.PAPER,
						ServerType_String.CAT_SERVER,
						ServerType_String.SPONGE,
						ServerType_String.CARPET,
						ServerType_String.BUNGEE_CORD,
						ServerType_String.WATERFALL
				};
				this.getSelectionModel().selectedIndexProperty().addListener((ov, oldValue, newValue) -> {
					serverType=showType[newValue.intValue()];
				});
			}
			public ServerType_String getSelect(){
				return serverType;
			}

		}
		class setServerApi extends ChoiceBox<Object> {
			String usingApi;
			public setServerApi(){
				super();
				this.setItems(FXCollections.observableArrayList("none","Forge","Fabric"));
				final String[] showType = {"none","Forge","Fabric"};
				this.getSelectionModel().selectedIndexProperty().addListener((ov, oldValue, newValue) -> {
					usingApi=showType[newValue.intValue()];
				});
			}
			public String getSelect(){
				return usingApi;
			}

		}
		/**
		 * 选择下载还是导入
		 */
		class Page_ChooseMethod extends VBox{
			public Page_ChooseMethod(){
				super();
				this.setPadding(new Insets(10));
				this.prefWidthProperty().bind(newServerPage.widthProperty());
				stepName.setText("新建服务端");
				Button importFromExistingSource=new Button();
				HBox iFESBox=new HBox();
				iFESBox.setPadding(new Insets(5));
				iFESBox.setPrefHeight(50);
				Label iFESLable=new Label("从现有来源导入");
				iFESLable.setStyle("-fx-font-size:28px;");
//				Label iFESSeparate=new Label();
//				iFESSeparate.prefWidthProperty().bind(this.widthProperty());
				iFESLable.prefWidthProperty().bind(this.widthProperty());
				Polygon iFESTriangle = new Polygon();
				iFESTriangle.getPoints().addAll(
						-10.0, -17.0,
						-10.0, 17.0,
						20.0, 0.0);
				iFESTriangle.setFill(Color.web("#1375D8"));
				iFESTriangle.setStroke(Color.web("#1375D8"));
				iFESBox.getChildren().addAll(iFESLable,iFESTriangle);
				importFromExistingSource.setGraphic(iFESBox);
				importFromExistingSource.setId("branch");
				importFromExistingSource.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						clear();
						getChild().add(new Page_SetBasicInfo());
					}
				});
				this.getChildren().addAll(importFromExistingSource);
			}
		}
		/**
		 * 设置基本信息
		 * 包括：服务端根目录、核心、类型、版本
		 */
		class Page_SetBasicInfo extends VBox{
			/**
			 * 设置基本信息
			 * 包括：服务端根目录、核心、类型、版本
			 */
			public Page_SetBasicInfo(){
				super(15);
				this.setPadding(new Insets(10));
				this.prefWidthProperty().bind(newServerPage.widthProperty());
				stepName.setText("导入服务端");

				HBox choosePath=new HBox(15);
				Label serverPathLabel=new Label("源服务端根目录");
				serverPathLabel.setPrefWidth(labelWidth);
				TextField serverPathTextField=new TextField();
				serverPathTextField.setPrefWidth(350);
				CommonButton serverPathButton=new CommonButton("浏览");
				serverPathButton.setPrefHeight(25);
				serverPathButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						serverPathTextField.setText(getPath());
					}
				});
				choosePath.getChildren().addAll(serverPathLabel,serverPathTextField,serverPathButton);
//				choosePath.setAlignment(Pos.TOP_LEFT);

				HBox chooseServerCore=new HBox(15);
				Label serverCoreLabel=new Label("服务器核心文件名");
				serverCoreLabel.setPrefWidth(labelWidth);
				TextField serverCoreTextField=new TextField();
				serverCoreTextField.setPrefWidth(100);
				chooseServerCore.getChildren().addAll(serverCoreLabel,serverCoreTextField);

				HBox chooseServerType=new HBox(15);
				Label serverTypeLabel=new Label("服务端类型");
				serverTypeLabel.setPrefWidth(labelWidth);
				setServerType serverTypeComboBox=new setServerType();
				Label serverTypeWarn=new Label("若不清楚请选择VANILLA");
				chooseServerType.getChildren().addAll(serverTypeLabel,serverTypeComboBox,serverTypeWarn);

				HBox chooseServerVersion=new HBox(15);
				Label serverVersionLabel=new Label("服务器版本");
				serverVersionLabel.setPrefWidth(labelWidth);
				TextField serverVersionTextField=new TextField();
				serverVersionTextField.setPrefWidth(100);
				chooseServerVersion.getChildren().addAll(serverVersionLabel,serverVersionTextField);

				NextPage next=new NextPage();
				next.nextPageButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if(serverPathTextField.getText()==null||
								serverCoreTextField.getText()==null||
								serverTypeComboBox.getSelect()==null||
								serverVersionTextField.getText()==null){
							return;
						}
						theNewServer.setServerName(serverPathTextField.getText());
						theNewServer.setCoreName(serverCoreTextField.getText());
						theNewServer.setServerType(serverTypeComboBox.getSelect());
						theNewServer.setServerVersion(serverVersionTextField.getText());
						clear();
						if(theNewServer.getServerType_Int()==ServerType_Int.VANILLA){
							getChild().add(new Page_SetModInfo());
						}
						else{
							//
						}
					}
				});
				this.getChildren().addAll(choosePath,chooseServerCore,chooseServerType,chooseServerVersion);
				this.getChildren().addAll(new EndSeparation(150),next);

			}
		}
		/**
		 * 设置模组信息
		 * 包括：
		 */
		class Page_SetModInfo extends VBox{
			/**
			 * 设置模组信息
			 * 包括：
			 */
			public Page_SetModInfo(){
				super(15);
				this.setPadding(new Insets(10));
				this.prefWidthProperty().bind(newServerPage.widthProperty());
				stepName.setText("设置模组信息");

				HBox chooseApi=new HBox(15);
				Label serverApiLabel=new Label("模组加载api");
				chooseApi.setPrefWidth(labelWidth);
				setServerApi serverApiComboBox=new setServerApi();
				Label serverTypeWarn=new Label("若无请选择none");
				chooseApi.getChildren().addAll(serverApiLabel,serverApiComboBox,serverTypeWarn);
				HBox chooseApiCore=new HBox(15);
//				chooseApiCore.setVisible(false);
				Label serverApiCoreLabel=new Label();
				serverApiCoreLabel.setPrefWidth(labelWidth);
				TextField serverApiCoreTextField=new TextField();
				serverApiCoreTextField.setPrefWidth(100);
				chooseApiCore.getChildren().addAll(serverApiCoreLabel,serverApiCoreTextField);
				serverApiComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
					@Override
					public void changed(ObservableValue observable, Object oldValue, Object newValue) {
						if(newValue=="none"){
//							chooseApiCore.setVisible(false);
							serverApiCoreLabel.setText("");
						}
						if(newValue=="Forge"){
//							chooseApiCore.setVisible(true);
							serverApiCoreLabel.setText("Forge Api文件名");
						}
						if(newValue=="Fabric"){
//							chooseApiCore.setVisible(true);
							serverApiCoreLabel.setText("Fabric Api文件名");
						}

					}
				});

				NextPage next=new NextPage();
				next.nextPageButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						if(serverApiComboBox.getSelect()==null||((serverApiComboBox.getSelect()=="Forge"||serverApiComboBox.getSelect()=="Fabric")&& serverApiCoreTextField.getText().equals(""))){
							return;
						}
//						theNewServer.setServerName(serverPathTextField.getText());
//						theNewServer.setCoreName(serverCoreTextField.getText());
//						theNewServer.setServerType(serverTypeComboBox.getSelect());
//						theNewServer.setServerVersion(serverVersionTextField.getText());
						clear();
					}
				});
				this.getChildren().addAll(chooseApi,chooseApiCore);
				this.getChildren().addAll(new EndSeparation(72),next);

			}
		}

		public NewServer(){
			super();
			this.prefWidthProperty().bind(pane.widthProperty());
			this.prefHeightProperty().bind(pane.heightProperty());
			Polygon backGraphic=new Polygon();
			backGraphic.getPoints().addAll(
					5.0, -8.5,
					5.0, 8.5,
					-9.0, 0.0);
			backGraphic.setFill(Color.web("#1375D8"));
			backGraphic.setStroke(Color.web("#1375D8"));
			Button back=new Button();
			back.setGraphic(backGraphic);
			back.setStyle("-fx-background-color:rgba(255,255,255,.0);");
			back.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					pane.setCenter(mainPart);
					try {
						this.finalize();
					} catch (Throwable throwable) {
						throwable.printStackTrace();
					}
					//exit operations
				}
			});
//			stepName.setStyle("-fx-line-height:5");
			stepName.setStyle("-fx-font-size:20px");
//			stepName.setPrefHeight(15);
			stepName.setAlignment(Pos.CENTER_RIGHT);
			HBox title=new HBox(17);
			title.setPadding(new Insets(5));
			title.getChildren().addAll(back,stepName);
			this.getChildren().add(title);
			clear();
//			this.prefWidthProperty().bind(pane.widthProperty().add(-50));
//			this.prefHeightProperty().bind(pane.heightProperty().add(-50));
			this.setStyle(
					"-fx-background-color: rgba(255,255,255,.9);" +
					"-fx-border-color: rgba(255,255,255,.0);" +
					"-fx-border-radius: 8;" +
					"-fx-background-radius: 8;");
			newServerPage.getChildren().add(new Page_ChooseMethod());
			this.getChildren().add(newServerPage);
		}

	}

	public void setButtonType(Button menuButton, boolean type) {
		menuButton.setDisable(type);
		menuButton.setStyle("-fx-opacity: 1;");
	}

	@Override
	public void start(Stage primaryStage) {

		theStage=primaryStage;

		Server.serverList.add(new Server("ServerA"));
		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));
//		Server.serverList.add(new Server("ServerA"));

		primaryStage.getIcons().add(new Image("/com/mcsl/resource/pic/ico.png"));
		primaryStage.setTitle("MCSL");
		primaryStage.setWidth(810);
		primaryStage.setHeight(490);
		primaryStage.setMinWidth(810);
		primaryStage.setMinHeight(490);

//		superPage.setContent(page);
//		superPage.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//		superPage.setStyle("-fx-background-color:rgba(255, 255, 255, .0);");
//		superPage.prefWidthProperty().bind(pane.widthProperty());
//		page.prefHeightProperty().bind(pane.heightProperty());
//		page.prefWidthProperty().bind(pane.widthProperty().add(-15));
		page.prefHeightProperty().bind(pane.heightProperty().add(-94));

		pane.setId("biggest_pane");
		pane.setPadding(new Insets(0, 0, 0, 0));// 下左上右
		pane.setStyle("-fx-background-color:rgba(255, 255, 255, .0);");// 背景


//		BackgroundImage myBI= new BackgroundImage(new Image("/com/mcsl/resource/pic/background2.png",810,490,false,false),
//		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//		          BackgroundSize.DEFAULT);
//		//then you set to your node
//		pane.setBackground(new Background(myBI));
//		//老的背景实现

		HBox head = new HBox(20);
		head.prefWidthProperty().bind(pane.widthProperty());
		head.setPadding(new Insets(8));
		head.setAlignment(Pos.CENTER);
		head.setStyle("-fx-background-color:rgba(19, 117, 216, .5);");
		ImageView MCSLLogo = new ImageView(new Image("/com/mcsl/resource/pic/MCSL.png", 60, 20, false, true));
		head.getChildren().add(MCSLLogo);
		HBox headButton = new HBox();
		headButton.setSpacing(5);
		Label sep = new Label();
		sep.prefWidthProperty().bind(pane.widthProperty());
		head.getChildren().add(sep);
		Button headButton_Minimize = new Button();
		Button headButton_Close = new Button();
		headButton_Minimize.setId("head");
		headButton_Close.setId("head");
		headButton_Minimize.setGraphic(new ImageView(new Image("/com/mcsl/resource/pic/minimize.png", 12, 12, false, true)));
		headButton_Close.setGraphic(new ImageView(new Image("/com/mcsl/resource/pic/close.png", 12, 12, false, true)));
		headButton_Minimize.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) headButton_Minimize.getScene().getWindow();
				stage.setIconified(true);
			}
		});
		headButton_Close.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Stage stage = (Stage) headButton_Close.getScene().getWindow();
				stage.close();
				//close server and work
				Platform.exit();
			}
		});
		headButton.getChildren().addAll(headButton_Minimize, headButton_Close);
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

//		superPage.setStyle("-fx-background-color:rgba(255, 255, 255, .0);");
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
		menuButton_Run.setOnAction(new EventHandler<ActionEvent>() {
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


		mainPart.getChildren().addAll(page,menuBox);
		pane.setTop(head);
		pane.setCenter(mainPart);
		pane.getStylesheets().add(Gui.class.getResource("/com/mcsl/resource/css/style.css").toString());

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
