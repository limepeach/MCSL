package com.mcsl;

import javafx.beans.value.*;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.*;
import javafx.scene.layout.*;

public class ScrollBarPane
{
	public Pane pane;

	public BorderPane selfPane; // 自身用的面板

	public ScrollPane scrollPane; // 滚动面板, 也是用来放组件的面板

	public ScrollBar hBar; // 横向滚动条
	public ScrollBar vBar; // 纵向滚动条

	public ScrollBarPane(Pane pane, int selfPaneWidth, int selfPaneHeight, int hvBarLength)
	{
		this.pane = pane;

		scrollPane = new ScrollPane();

		// 设置滚动面板不使用内置的滚动条
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);

		// 滚动面板的背景颜色
//		scrollPane.setBackground(new Background(new BackgroundFill(Conver.hexColorStrToColor("EBEBEB"), null, null)));

		selfPane = new BorderPane();
		selfPane.setPrefWidth(selfPaneWidth);
		selfPane.setPrefHeight(selfPaneHeight);

		hBar = new ScrollBar();
		hBar.valueProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
			{
				scrollPane.setHvalue(newValue.doubleValue() / 100);
			}
		});

		vBar = new ScrollBar();
		vBar.valueProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
			{
				scrollPane.setVvalue(newValue.doubleValue() / 100);
			}
		});

		// 显示为纵向的滚动条
		vBar.setOrientation(Orientation.VERTICAL);

		// BorderPane下面和右边放滚动条, 中间放滚动面板
		selfPane.setRight(vBar);
		selfPane.setBottom(hBar);
		selfPane.setCenter(scrollPane);

		this.setHVBarLength(50);
		this.setHBarSize(300, 25);
		this.setVBarSize(25, 300);
	}

	/**
	 * 设置滚动面板里的子节点
	 */
	public void setContent(Node node)
	{
		scrollPane.setContent(node);
	}

	/**
	 * 设置横向、纵向滚动条按钮的长度
	 */
	public void setHVBarLength(int length)
	{
		hBar.setVisibleAmount(length);
		vBar.setVisibleAmount(length);
	}
	/**
	 * 设置横向滚动条的大小
	 */
	public void setHBarSize(int width, int height)
	{
		hBar.setPrefSize(width, height);
	}

	/**
	 * 设置纵向滚动条的大小
	 */
	public void setVBarSize(int width, int height)
	{
		vBar.setPrefSize(width, height);
	}

	/**
	 * 设置横向滚动条的位置
	 */
	public void setHBarLayoutXY(int x, int y)
	{
		hBar.setLayoutX(x);
		hBar.setLayoutY(y);
	}

	/**
	 * 设置纵向滚动条的位置
	 */
	public void setVBarLayoutXY(int x, int y)
	{
		vBar.setLayoutX(x);
		vBar.setLayoutY(y);
	}

	public void setLayoutXY(int x, int y)
	{
		selfPane.setLayoutX(x);
		selfPane.setLayoutY(y);
	}

	/**
	 * 将BorderPane添加到构造方法里的pane的子节点
	 */
	public void addToPane()
	{
		pane.getChildren().add(selfPane);
	}
}
