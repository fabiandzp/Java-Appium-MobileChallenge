package pages.settings;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pages.BasePage;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class CountrySettingsPage extends BasePage {
    private static final Logger log = getLogger(CountrySettingsPage.class.getName());

    public CountrySettingsPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By countrySection = By.id("com.alibaba.aliexpresshd:id/tv_country");
    private static final By countryList = By.xpath("//android.widget.TextView[@resource-id='com.alibaba.aliexpresshd:id/tv_country_value']");
    private static final By provinceList =
            By.xpath("//android.widget.TextView[@resource-id='com.alibaba.aliexpresshd:id/tv_country_value']");
    private static final By municipalityList =
            By.xpath("//android.widget.RelativeLayout[@resource-id='com.alibaba.aliexpresshd:id/rl_select_item']");

    public String setCountry(){
        driver.findElement(countrySection).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(countryList));

        //Select the new country
        List<AndroidElement> list = driver.findElements(countryList);
        log.info("List Country Size " + list.size());
        //int i = list.size();
        String newCountry = list.get(3).getText();
        list.get(3).click();

        log.info("Country Selected -> " + newCountry);

        //Wait until province List loads and select 1
        wait.until(ExpectedConditions.presenceOfElementLocated(provinceList));
        List<AndroidElement> provinceElements = driver.findElements(provinceList);
        log.info("List  Size " + provinceElements.size());
        provinceElements.get(0).click();

        return newCountry;
    }

    private static final By actualCountry = By.id("com.alibaba.aliexpresshd:id/tv_country");
    public String getActualCountry(){
        log.info("Getting the actual country configured");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(countrySection));

        //Get the actual country name
        String countryText = driver.findElement(actualCountry).getText();
        log.info("Actual Country >>> " + countryText);
        return countryText;
    }



}
