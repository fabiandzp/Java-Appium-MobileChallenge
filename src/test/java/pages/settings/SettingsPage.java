package pages.settings;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pages.BasePage;
import pages.account.AccountMenuPage;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SettingsPage extends BasePage {
    private static final Logger log = getLogger(AccountMenuPage.class.getName());


    public SettingsPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By countrySettingsBtn = By.id("com.alibaba.aliexpresshd:id/rl_country_settings");
    public void goToCountrySettings(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(countrySettingsBtn));

        log.info("Clicking Country pages.settings button");
        driver.findElement(countrySettingsBtn).click();
    }

    private static final By ccySettingsBtn = By.id("com.alibaba.aliexpresshd:id/rl_currency_settings");
    public void goToCcySettings() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(ccySettingsBtn));
        log.info("Clicking Currency pages.settings button");
        driver.findElement(ccySettingsBtn).click();

    }
}
