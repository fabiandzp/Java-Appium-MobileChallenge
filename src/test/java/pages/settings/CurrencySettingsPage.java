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

public class CurrencySettingsPage extends BasePage {
    private static final Logger log = getLogger(CurrencySettingsPage.class.getName());

    public CurrencySettingsPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By currencySection = By.id("com.alibaba.aliexpresshd:id/lv_currency_list");
    private static final By countryList = By.xpath("//android.widget.TextView[@resource-id='com.alibaba.aliexpresshd:id/tv_currency_symbol']");
    private static final By goItBanner = By.id("com.alibaba.aliexpresshd:id/snackbar_action");

    public String setCurrency(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(currencySection));

        //Select the new country
        List<AndroidElement> list = driver.findElements(countryList);
        log.info("List Country Size " + list.size());
        int i = list.size();
        String newCcy = list.get(i-1).getText();
        list.get(i-1).click();

        log.info("Country Selected -> " + newCcy);

        if(driver.findElement(goItBanner).isDisplayed()){
            driver.findElement(goItBanner).click();
        }

        return newCcy;
    }

    private static final By currency = By.id("com.alibaba.aliexpresshd:id/tv_settings_currency_view");
    public String getActualCurrency(){
        log.info("Getting the actual currency");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(currency));

        //Get the actual country name
        String ccy = driver.findElement(currency).getText();
        log.info("Actual Country >>> " + ccy);
        return ccy;
    }



}
