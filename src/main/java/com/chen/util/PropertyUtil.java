package com.chen.util;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
 
	    static  Properties pro = new Properties();  

	    public static  String getValue(String key){  
	    	 try {  
	                pro.load(PropertyUtil.class.getClassLoader().getResourceAsStream("database.properties"));  
	            } catch (IOException e) {         
	                e.printStackTrace();  
	            }  
	        return pro.getProperty(key);  
	    }  
	      
}
