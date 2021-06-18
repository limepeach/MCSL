package com.mcsl;

import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import jfxtras.styles.jmetro.Style.*;
//import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;


public class Gui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String version =new String("0.0.0.1");
	public Gui() {
		super("MCSL "+version);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		JPanel examplePannel=new JPanel();
		new JMetro(Style.LIGHT);
		JButton exampleButton=new JButton("text");
		add(exampleButton);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
//        System.setProperty("swing.defaultlaf","com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.invokeLater(
            new Runnable(){
                public void run() {
                    new Gui();
                }
            }
        );
    }
}