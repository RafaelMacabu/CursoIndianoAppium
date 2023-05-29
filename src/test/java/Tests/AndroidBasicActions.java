package Tests;

import DriverUtils.StartDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class AndroidBasicActions {


    @AndroidFindBy(accessibility = "Views")
    private static WebElement elementView;

    @AndroidFindBy(accessibility = "TextFields")
    private static WebElement elementTextField;

    @AndroidFindBy(id = "io.appium.android.apis:id/edit")
    private static WebElement elementEditTextField;

    public AndroidBasicActions(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AppiumDriver driver = StartDriverSession.createAndroidDriver();
        AndroidBasicActions instance = new AndroidBasicActions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        elementView.click();

        //scrolling
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));

        System.out.println(elementTextField.getText());

        wait.until(ExpectedConditions.visibilityOf(elementTextField)).click();
        elementEditTextField.sendKeys("SEXO");
        Thread.sleep(3000);
        elementEditTextField.clear();



    }
}
