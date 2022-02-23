package util;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BaseAppium {

    private AndroidDriver<AndroidElement> driver;

    private final String APP_PACKAGE = "com.facebook.katana";
    private final String APP_ACTIVITY = "com.facebook.katana.LoginActivity";
    private final String EMULATOR_NAME = "emulator-5554";
    private final String APPIUM_SERVER = "http://127.0.0.1:4723/wd/hub";
    private final String APK_FOLDER = "src/main/resources/apk";
    private final String APK_NAME = "Facebook_App.apk";

    public BaseAppium(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }



    public AndroidDriver<AndroidElement> appConection() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        File appDir = new File(APK_FOLDER);
        File app = new File(appDir, APK_NAME);


        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");//new step
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability("appPackage", APP_PACKAGE);
        cap.setCapability("appActivity", APP_ACTIVITY);
        cap.setCapability("udid", EMULATOR_NAME);


        this.driver = new AndroidDriver<>(new URL(APPIUM_SERVER), cap);

        return this.driver;
    }


    public void type(By locator, String inputText) {
        wait(locator);
        driver.findElement(locator).sendKeys(inputText);
    }


    public void wait(String locator) {
        WebDriverWait waitForkashtagtextbox = new WebDriverWait(driver, 30);
        waitForkashtagtextbox.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(locator)));


    }

    public void wait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(String locator) {
        wait(locator);
        driver.findElementByAccessibilityId(locator).click();
    }

    public void click(By locator) {
        wait(locator);
        driver.findElement(locator).click();
    }

    public void datePicker(String values, String selector) {
        List<AndroidElement> elements = driver.findElementsByXPath(selector);


        elements.get(0).click();
        elements.get(0).clear();
        elements.get(0).sendKeys(values.split("/")[0]);

        elements.get(1).click();
        elements.get(1).clear();
        elements.get(1).sendKeys(values.split("/")[1]);

        elements.get(2).click();
        elements.get(2).clear();
        elements.get(2).sendKeys(values.split("/")[2]);
        elements.get(2).click();
    }


    public String getText(By locator) {

        return driver.findElement(locator).getText();
    }

    public void close() {

        driver.quit();
    }


}
