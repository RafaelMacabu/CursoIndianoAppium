package Tests;

import DriverUtils.StartDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class AndroidUIAutomator {
    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = StartDriverSession.createAndroidDriver();

        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
//        By element1 = AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")");

        System.out.println(element.getText());

        element = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);

        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));

        System.out.println(element.getText());
    }
}
