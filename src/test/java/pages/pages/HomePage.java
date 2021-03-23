package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.apache.logging.log4j.LogManager.getLogger;

public class HomePage extends BasePage {
    private static final Logger log = getLogger(Navigation.class.getName());

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    private static final By searchBar = By.id("rl_search_box");
    private static final By realSearchBar = By.id("abs__search_src_text");
    private static final By searchBtn = By.id("abs__search_go_btn");
    public void searchItem(String query){
        log.info("Search Item -> " + query);
        driver.findElement(searchBar).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(realSearchBar));

        driver.findElement(realSearchBar).sendKeys(query);
        driver.findElement(searchBtn).click();
    }
}
