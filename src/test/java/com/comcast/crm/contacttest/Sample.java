package com.comcast.crm.contacttest;

import java.io.IOException;

import com.comcast.crm.generic.fileutility.FileUtility;

public class Sample {
	public static void main(String[] args) throws IOException {
		
	
	FileUtility fLib=new FileUtility();
	String Browser=fLib.getDataFromPropertiesFile("browser");
	System.out.println(Browser);
	}
}
