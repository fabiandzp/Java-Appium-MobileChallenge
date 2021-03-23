package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private static final By resultList =
            By.xpath("//android.widget.TextView[@resource-id='com.alibaba.aliexpresshd:id/tv_product_list_tagged_title']");
    public void searchItem(String query){
        log.info("Search Item -> " + query);
        driver.findElement(searchBar).click();

        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(realSearchBar));

        driver.findElement(realSearchBar).sendKeys(query);
        driver.findElement(searchBtn).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultList));

    }


    private static final By homeContainer = By.id("com.alibaba.aliexpresshd:id/pull_refreshlayout");
    public void homePageCheck(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(homeContainer));
    }
}
