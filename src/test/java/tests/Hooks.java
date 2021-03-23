package tests;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import utilities.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Hooks {

    private static final Logger log = getLogger(Hooks.class.getName());
    protected AndroidDriver driver;

    @BeforeClass
    public void setup(){

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("application.properties"));
        } catch (IOException var2) {
            log.info("Error when reading the property file");
        }

        String url = props.getProperty("url");
        String udid = props.getProperty("udid");
        String deviceName = props.getProperty("deviceName");
        String platformName = props.getProperty("platformName");
        String appPackage = props.getProperty("appPackage");
        String appActivity = props.getProperty("appActivity");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        try {
            driver = new AndroidDriver(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        log.info("url: " + url);
        log.info("udid: " + udid);
        log.info("deviceName: " + deviceName);
        log.info("platformName: " + platformName);
        log.info("appPackage: " + appPackage);
        log.info("appActivity: " + appActivity);

    }


    private String sauceUserName = System.getenv("SAUCE_USERNAME");
    private String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
    private String sauceUrl = System.getenv("SAUCE_URL");

    private String urlSauceLab = "https://" + sauceUserName + ":" + sauceAccessKey + sauceUrl;
    //@BeforeClass
    public void setupSauceLabs(){

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("application.properties"));
        } catch (IOException var2) {
            log.info("Error when reading the property file");
        }

        String url = props.getProperty("url");
        String udid = props.getProperty("udid");
        String deviceName = props.getProperty("deviceName");
        String platformName = props.getProperty("platformName");
        String appPackage = props.getProperty("appPackage");
        String appActivity = props.getProperty("appActivity");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);


       /* DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appiumVersion", "1.20.2");
        capabilities.setCapability("deviceName", "Android GoogleAPI Emulator");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "storage:filename=Aliexpress.apk");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);*/


        try {
            driver = new AndroidDriver(new URL(url), capabilities);
            //driver = new AndroidDriver(new URL(urlSauceLab), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        log.info("url: " + url);
        log.info("udid: " + udid);
        log.info("deviceName: " + deviceName);
        log.info("platformName: " + platformName);
        log.info("appPackage: " + appPackage);
        log.info("appActivity: " + appActivity);

    }

    @AfterMethod
    public void mainActivityCall(){
        driver.startActivity(new Activity("com.alibaba.aliexpresshd", "com.alibaba.aliexpresshd.home.ui.MainActivity"));
    }




}
