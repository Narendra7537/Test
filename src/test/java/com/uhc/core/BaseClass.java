package com.uhc.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver driver;
	public static Properties properties = new Properties();  
    
    
	public static void initialize(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();;
			driver= new EdgeDriver();
		
			
		}
		driver.manage().window().maximize();
		try {
			properties = loadApplicationProperties(properties, "./src/test/resources/application.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void launchApplication(String URL)
	{
		driver.get(URL);
	}
	public static void closeApplication()
	{
		driver.close();
	}
	public static Properties loadApplicationProperties(Properties properties, String propertiesFile) {
		FileInputStream input = null;
        try {
        	
            // Load the properties file
            input = new FileInputStream(propertiesFile);
            properties.load(input);

            // Retrieve values from the properties file
            String url = properties.getProperty("url");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
	}

}
