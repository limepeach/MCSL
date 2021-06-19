package com.mcsl;

//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        GridPane gridPane = new GridPane();
//
//        Rectangle[] recs = new Rectangle[10];
//        for (int i = 0; i < recs.length; i++) {
//            recs[i] = new Rectangle(30, 30, Color.GREEN);
//            recs[i].setStroke(Color.BLACK);
//            gridPane.add(recs[i], i, 0);
//        }
//
//        primaryStage.setTitle("Code after primaryStage.show()");
//        primaryStage.setScene(new Scene(gridPane, 400, 300));
//        primaryStage.show();
//
//
//        for (Rectangle rec : recs) {   
//            Thread.sleep(1000);    
//            rec.setFill(Color.ORANGE);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

////import jfxtras.styles.jmetro.JMetro;
////import jfxtras.styles.jmetro.Style;
////import jfxtras.styles.jmetro.Style.*;
//
//import javafx.application.Application;
//import javafx.geometry.*;
//import javafx.scene.*;
//import javafx.scene.control.*;
//import javafx.scene.image.*;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.scene.text.*;
//import javafx.stage.Stage;
//import javafx.event.*;
//
//
//
//
//
//
//public class Main extends Application {
//	  public static void main(String[] args) {
//	    Application.launch(args);
//	  }
//
//	  @Override
//	  public void start(Stage primaryStage) {
//
//		    
//	    Button btn = new Button();
//	    final Label lbl = new Label();
//
//	    primaryStage.setTitle("Hello World!");
//
//	    lbl.setLayoutX(70);
//	    lbl.setLayoutY(150);
//
//	    btn.setLayoutX(100);
//	    btn.setLayoutY(100);
//	    btn.setText("Hello, World!");
//
//	    btn.setOnAction(new EventHandler<ActionEvent>() {
//
//	      @Override
//	      public void handle(ActionEvent event) {
//	        lbl.setText("Hello, World.");
//	      }
//	    });
//
//	    Group root = new Group();
//
//	    root.getChildren().add(btn);
//	    root.getChildren().add(lbl);
//	    primaryStage.setScene(new Scene(root, 300, 250));
//	    primaryStage.show();
//	  }
//	}
//
//
////public class Main extends Application {
////	  public static void main(String[] args) {
////	    launch(args);
////	  }
////
////	  @Override
////	  public void start(Stage stage) {
////	    Scene scene = new Scene(new Group());
////	    stage.setTitle("Label Sample");
////	    stage.setWidth(400);
////	    stage.setHeight(180);
////
////	    HBox hbox = new HBox();
////
////	    final Label label1 = new Label("Search long long long long long long long long long ");
////	    label1.setOnMouseEntered(new EventHandler<MouseEvent>() {
////	      @Override
////	      public void handle(MouseEvent e) {
////	        label1.setScaleX(1.5);
////	        label1.setScaleY(1.5);
////	        label1.setTranslateX(80);
////	        label1.setTranslateY(0);
////	      }
////	    });
////
////	    label1.setOnMouseExited(new EventHandler<MouseEvent>() {
////	      @Override
////	      public void handle(MouseEvent e) {
////	        label1.setScaleX(1);
////	        label1.setScaleY(1);
////	        label1.setTranslateX(0);
////	        label1.setTranslateY(0);
////	      }
////	    });
////	    
////	    hbox.setSpacing(10);
////	    hbox.getChildren().add((label1));
////	    ((Group) scene.getRoot()).getChildren().add(hbox);
////
////	    stage.setScene(scene);
////	    stage.show();
////	  }
////	}