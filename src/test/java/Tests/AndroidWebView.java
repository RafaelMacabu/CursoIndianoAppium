package Tests;

import DriverUtils.StartDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class AndroidWebView {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver driver = StartDriverSession.createAndroidDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId(),
                "direction","down",
                "percent",2));



        driver.findElement(AppiumBy.accessibilityId("WebView")).click();
        Thread.sleep(5000);

        Set<String> contextHandles = driver.getContextHandles();
        for (String contextHandle : contextHandles){
            System.out.println(contextHandle);

        }

        //driver.context("WEBVIEW");
        driver.context(contextHandles.toArray()[1].toString());

        System.out.println(driver.findElement(AppiumBy.cssSelector("body > h1")).getText());
    }
}
