package Tests;

import DriverUtils.StartDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class AndroidFindElements {

    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = StartDriverSession.createAndroidDriver();

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(element.getText());

        element = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println(element.getText());

        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println(element.getText());

    }
}
