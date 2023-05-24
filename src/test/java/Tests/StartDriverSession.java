package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class StartDriverSession {

    public static void main(String[] args) throws MalformedURLException {
        HashMap<String,String> caps = new HashMap<>();
        caps.put(MobileCapabilityType.PLATFORM_NAME,"android");
        caps.put(MobileCapabilityType.UDID,"291d97f2");
        caps.put(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //caps.put(MobileCapabilityType.APP,"D:\\Software Estudos APPIUM\\apps\\ApiDemos-debug.apk");
        caps.put("appPackage","io.appium.android.apis");
        caps.put("appActivity",".ApiDemos t2949");
        caps.put("newCommandTimeout","300");
        UiAutomator2Options options = new UiAutomator2Options(caps);
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        caps.setCapability(MobileCapabilityType.UDID,"291d97f2");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP,"D:\\Software Estudos APPIUM\\apps\\ApiDemos-debug.apk");*/

        URL url = new URL("http://0.0.0.0:4723");

        AppiumDriver driver = new AndroidDriver(url,options);
        System.out.println("session id: " + driver.getSessionId());

    }
}
