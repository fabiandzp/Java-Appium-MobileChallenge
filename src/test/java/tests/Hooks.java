package tests;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Hooks {

    private static final Logger log = getLogger(Hooks.class.getName());
    protected AndroidDriver driver;

/*    @BeforeSuite
    public void environmentSetup(){


    }*/

    @BeforeMethod
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


}
