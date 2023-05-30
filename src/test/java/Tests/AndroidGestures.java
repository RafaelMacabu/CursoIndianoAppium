package Tests;

import DriverUtils.StartDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class AndroidGestures {
    public static void longClickGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: longClickGesture",
                ImmutableMap.of(
                        "elementId",((RemoteWebElement) element).getId(),
                        "duration",1000));
    }

    public static void scrollGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.
                xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "right",
                "percent", 1));
    }

        public static void swipeGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.
                xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId(),
                "direction","left",
                "percent",1));


        /*WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                        "left",100,"top",100,"width",600,"height",600,
                "elementId",((RemoteWebElement) element).getId(),
                "direction","up",
                "percent",0.75));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left",100,"top",100,"width",600,"height",600,
                "elementId",((RemoteWebElement) element).getId(),
                "direction","down",
                "percent",0.75));*/
    }


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver driver = StartDriverSession.createAndroidDriver();
        // longClickGesture(driver);
        swipeGesture(driver);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        Thread.sleep(3000);
        driver.lockDevice(Duration.ofSeconds(5));
        driver.unlockDevice();

        /*System.out.println(driver.isKeyboardShown());
        driver.pressKey(new KeyEvent().withKey(AndroidKey.A));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.B));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.C));
        driver.hideKeyboard();*/

        //((AndroidDriver)driver).terminateApp("io.appium.android.apis");

        System.out.println();



    }
}
