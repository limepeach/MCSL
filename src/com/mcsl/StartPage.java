package com.mcsl;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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
