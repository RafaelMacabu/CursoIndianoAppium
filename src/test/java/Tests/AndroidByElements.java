package Tests;

import DriverUtils.StartDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class AndroidByElements {
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]")
    private static WebElement elementAccess;

    @AndroidFindBy(accessibility = "Views")
    private static WebElement elementView;

    public AndroidByElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public static void main(String[] args) throws MalformedURLException {
        AppiumDriver driver = StartDriverSession.createAndroidDriver();
        AndroidByElements instance = new AndroidByElements(driver);

        By elementBy = By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");

        System.out.println(driver.findElement(elementBy).getText());

        System.out.println(elementAccess.getText());
    }
}
