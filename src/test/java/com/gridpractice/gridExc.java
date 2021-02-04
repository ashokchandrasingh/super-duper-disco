package com.gridpractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class gridExc {
	

	public RemoteWebDriver driver;

@Test
public void remoteExc() throws MalformedURLException
{
	 URL url = new URL("http://192.168.1.3:5555");
	  DesiredCapabilities cap= DesiredCapabilities.chrome();
	  cap.setPlatform(Platform.WINDOWS);
	  cap.setBrowserName("chrome");
	  
	  driver= new RemoteWebDriver(url, cap);
	  driver.get("http://facebook.com");
}


}
