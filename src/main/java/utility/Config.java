package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	public static Properties prop;
	
	public static Properties loadPropertyFile() throws Exception {
		
		prop = new Properties();
		FileInputStream fi = new FileInputStream("C://Users//shree//Downloads//PolicybossCar//src//main//resources//configfile//config.properties");
		
		prop.load(fi);
		return prop;
	}

}
