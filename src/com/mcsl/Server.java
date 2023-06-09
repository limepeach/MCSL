package com.mcsl;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;

import javax.print.DocFlavor;
import javax.swing.*;

public class Server {
	private String serverName;

	private ServerType_String serverType_String;
	private ServerType_Int serverType_Int;

	private String serverVersion;
	private String serverPath;

	private ServerConditionType serverCondition = ServerConditionType.READY;
	public Image serverIcon;

	boolean enablePluginForMCDR, enablePluginForBucket, enableModForForge;
	private String apiType;

	private String coreName;
	private String MCDRPath, apiName;

	private String javaEnvPath, pythonEnvPath;

	private int minMemory, maxMemory;
	private String jvmParameter;

	private Properties serverSettings, serverOptions;

	public static ArrayList<Server> serverList = new ArrayList<>();
	public static ArrayList<Server> runningServerList = new ArrayList<>();
	public Server() {
		setServerCondition(ServerConditionType.LOADING);
	}
	public Server(String theName) {
		serverName = theName;
		setServerCondition(ServerConditionType.LOADING);
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}
	public String getServerPath() {
		return serverPath;
	}

	public enum ServerType_Int {
		VANILLA(1),
		BUKKIT(2),
		SPIGOT(3),
		PAPER(4),
		CAT_SERVER(5),
		SPONGE(6),
		CARPET(7),
		BUNGEE_CORD(8),
		WATERFALL(9);
		private int serverType;

		ServerType_Int(int inputInt) {
			this.serverType = inputInt;
		}
	}
	public enum ServerType_String {

		VANILLA("Vanilla"),
		BUKKIT("Bukkit"),
		SPIGOT("Spigot"),
		PAPER("Paper"),
		CAT_SERVER("CatServer"),
		SPONGE("Sponge"),
		CARPET("Carpet"),
		BUNGEE_CORD("BungeeCord"),
		WATERFALL("Waterfall");

		private String serverType;

		ServerType_String(String inputString) {
			this.serverType = inputString;
		}

	}
	public static ServerType_String intToString(ServerType_Int inputInt) {
		switch (inputInt) {
			case VANILLA:
				return ServerType_String.VANILLA;
			case BUKKIT:
				return ServerType_String.BUKKIT;
			case SPIGOT:
				return ServerType_String.SPIGOT;
			case PAPER:
				return ServerType_String.PAPER;
			case CAT_SERVER:
				return ServerType_String.CAT_SERVER;
			case SPONGE:
				return ServerType_String.SPONGE;
			case CARPET:
				return ServerType_String.CARPET;
			case BUNGEE_CORD:
				return ServerType_String.BUNGEE_CORD;
			case WATERFALL:
				return ServerType_String.WATERFALL;
		}

		return null;
	}
	public static ServerType_Int stringToInt(ServerType_String inputString) {
		switch (inputString) {
			case VANILLA:
				return ServerType_Int.VANILLA;
			case BUKKIT:
				return ServerType_Int.BUKKIT;
			case SPIGOT:
				return ServerType_Int.SPIGOT;
			case PAPER:
				return ServerType_Int.PAPER;
			case CAT_SERVER:
				return ServerType_Int.CAT_SERVER;
			case SPONGE:
				return ServerType_Int.SPONGE;
			case CARPET:
				return ServerType_Int.CARPET;
			case BUNGEE_CORD:
				return ServerType_Int.BUNGEE_CORD;
			case WATERFALL:
				return ServerType_Int.WATERFALL;
		}

		return null;
	}
	public void setServerType(ServerType_Int serverType1) {
		serverType_Int = serverType1;
		serverType_String = intToString(serverType1);
	}
	public void setServerType(ServerType_String serverType1) {
		serverType_String = serverType1;
		serverType_Int = stringToInt(serverType1);
	}
	public ServerType_Int getServerType_Int() {
		return serverType_Int;
	}
	public ServerType_String getServerType_String() {
		return serverType_String;
	}


	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}
	public String getServerVersion() {
		return serverVersion;
	}

	public void setCoreName(String coreName) {
		this.coreName = coreName;
	}
	public String getCoreName() {
		return coreName;
	}
	public void setJavaEnvPath(String javaEnvPath) {
		this.javaEnvPath = javaEnvPath;
	}
	public String getJavaEnvPath() {
		return javaEnvPath;
	}


	public enum ServerConditionType {
		READY(1),
		LOADING(2),
		DOWNLOADING(3),
		INSTALLING(4),
		RUNNING(5);

		private int theType;

		ServerConditionType(int inputInt) {
			this.theType = inputInt;
		}
	}
	public void setServerCondition(ServerConditionType serverCondition) {
		this.serverCondition = serverCondition;
		switch (this.serverCondition) {
			case READY:
				this.serverIcon = new Image("/com/mcsl/resource/pic/ready.png", 30, 30, false, true);
				break;
			case LOADING:
				this.serverIcon = new Image("/com/mcsl/resource/pic/loading.gif", 30, 30, false, true);
				break;
			case DOWNLOADING:
				this.serverIcon = new Image("/com/mcsl/resource/pic/downloading.png", 30, 30, false, true);
				break;
			case INSTALLING:
				this.serverIcon = new Image("/com/mcsl/resource/pic/installing.gif", 30, 30, false, true);
				break;
			case RUNNING:
				this.serverIcon = new Image("/com/mcsl/resource/pic/running.png", 30, 30, false, true);
				break;
		}
	}
	public ServerConditionType getServerCondition() {
		return serverCondition;
	}

	/**
	 * 检测是否可以安装Forge Mod(类型层面)
	 * 注意：并不是可以安装，有些可能需要安装api
	 */
	public boolean getForgeAble(){
		switch (getServerType_Int()) {
			case VANILLA:
			case BUKKIT:
			case WATERFALL:
			case BUNGEE_CORD:
			case CARPET:
			case PAPER:
			case SPIGOT:
				return false;
			case CAT_SERVER:
			case SPONGE:
				return true;
		}
		return false;
	}
	/**
	 * 检测是否可以安装Fabric Mod(类型层面)
	 * 注意：并不是可以安装，有些可能需要安装api
	 */
	public boolean getFabricAble(){
		switch (getServerType_Int()) {
			case VANILLA:
			case CARPET:
				return true;
			case BUKKIT:
			case WATERFALL:
			case BUNGEE_CORD:
			case SPONGE:
			case CAT_SERVER:
			case PAPER:
			case SPIGOT:
				return false;
		}
		return false;
	}
	/**
	 * 检测是否可以安装插件(类型层面)
	 * 注意：并不是可以安装，有些可能需要安装api
	 */
	public boolean getPluginAble(){
		switch (getServerType_Int()) {
			case VANILLA:
			case CARPET:
			case SPONGE:
				return false;
			case BUKKIT:
			case WATERFALL:
			case BUNGEE_CORD:
			case CAT_SERVER:
			case PAPER:
			case SPIGOT:
				return true;
		}
		return false;
	}


	public void setApiType(String apiType) {
		this.apiType = apiType;
	}
	public String getApiType() {
		return apiType;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getApiName() {
		return apiName;
	}
}