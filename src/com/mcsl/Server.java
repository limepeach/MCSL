package com.mcsl;

import java.util.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;

import javax.swing.*;

public class Server {
	String serverName,serverType,serverVersion,serverCondition;
	
	boolean pluginForMCDR,pluginForBucket,modForForge,modForFabric;
	
	String javaEnvPath,pythonenvPath;
	
	int minMemory,maxMemory;
	String jvmParameter;

	Properties serverSettings, serverOptions;

	public Server(String theName) {
		this.serverName = theName;
		try {
			Util.system("cmd");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}