package com.mcsl;

import java.io.InputStream;

public class Util{
	static public void system(String filepath)throws Exception{
        String str=filepath+"execute.bat";
        try{
            Process p=Runtime.getRuntime().exec(str);
            InputStream in=p.getInputStream();
            int c;
            while((c=in.read())!=-1){
                System.out.print(c);
            }
            in.close();
            p.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}