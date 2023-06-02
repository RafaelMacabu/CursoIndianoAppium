package Tests;

import DriverUtils.StartDriverSession;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.time.Duration;

public class AndroidAutomateBrowser {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver = StartDriverSession.createAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tesla.com");
    }
}
