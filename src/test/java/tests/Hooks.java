package tests;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

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

        String SAUCEappiumVersion = props.getProperty("SAUCEappiumVersion");
        String SAUCEdeviceName = props.getProperty("SAUCEdeviceName");
        String SAUCEdeviceOrientation = props.getProperty("SAUCEdeviceOrientation");
        String SAUCEbrowserName = props.getProperty("SAUCEbrowserName");
        String SAUCEplatformVersion = props.getProperty("SAUCEplatformVersion");
        String SAUCEplatformName = props.getProperty("SAUCEplatformName");
        String SAUCEapp = props.getProperty("SAUCEapp");
        String SACUEappPackage = props.getProperty("SAUCEappPackage");
        String SAUCEappActivity = props.getProperty("SAUCEappActivity");


        DesiredCapabilities capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("appiumVersion", SAUCEappiumVersion);
        capabilities.setCapability("deviceName", SAUCEdeviceName);
        capabilities.setCapability("deviceOrientation", SAUCEdeviceOrientation);
        capabilities.setCapability("browserName", SAUCEbrowserName);
        capabilities.setCapability("platformVersion", SAUCEplatformVersion);
        capabilities.setCapability("platformName", SAUCEplatformName);
        capabilities.setCapability("app", SAUCEapp);
        capabilities.setCapability("appPackage", SACUEappPackage);
        capabilities.setCapability("appActivity", SAUCEappActivity);

        String SAUCE_USERNAME = props.getProperty("SAUCE_USERNAME");
        String SAUCE_ACCESS_KEY = props.getProperty("SAUCE_ACCESS_KEY");
        String SAUCE_URL = props.getProperty("SAUCE_URL");

        String urlSauceLabTemp = "https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + SAUCE_URL;

        try {
            //driver = new AndroidDriver(new URL(urlSauceLab), capabilities);
            driver = new AndroidDriver(new URL(urlSauceLabTemp), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        log.info("url: " + SAUCE_URL);
        //log.info("udid: " + udid);
        log.info("SAUCEappiumVersion: " + SAUCEappiumVersion);
        log.info("SAUCEdeviceName: " + SAUCEdeviceName);
        log.info("SAUCEappPackage: " + SACUEappPackage);
        log.info("SAUCEdeviceOrientation: " + SAUCEdeviceOrientation);
        log.info("SAUCEplatformVersion: " + SAUCEplatformVersion);
        log.info("SAUCEplatformName: " + SAUCEplatformName);
        log.info("SAUCEapp: " + SAUCEapp);
        log.info("SAUCEappPackage: " + SACUEappPackage);
        log.info("SAUCEappActivity: " + SAUCEappActivity);

    }

    @AfterMethod
    public void mainActivityCall(){
        driver.startActivity(new Activity("com.alibaba.aliexpresshd", "com.alibaba.aliexpresshd.home.ui.MainActivity"));
    }




}
