package com.crm.GenericUtility_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * 
 * @author rishav ranjan
 *
 */

public class FileUtility {
	
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getpropertydata(String key) throws IOException
	{
		
		FileInputStream fis=new FileInputStream(IpathConstants.Filepath);
		
		Properties pobj=new Properties();
		
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		
	}

	

}
