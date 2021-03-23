package pages.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class ResultsPage extends BasePage {
    private static final Logger log = getLogger(Navigation.class.getName());

    public ResultsPage(AndroidDriver driver) {
        super(driver);
    }

    private static final By resultListContainer = By.id("com.alibaba.aliexpresshd:id/search_result_list");
    private static final By resultList =
            By.xpath("//android.widget.TextView[@resource-id='com.alibaba.aliexpresshd:id/tv_product_list_tagged_title']");
    public String getResultsList(String query){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(resultListContainer));

        List<AndroidElement> list = driver.findElements(resultList);
        log.info("List Country Size " + list.size());
        int numberOfItems = list.size();
        int id = 0;
        for (int i=0; i < numberOfItems; i++) {
            String strValidation = list.get(i).getText();
            if (strValidation.contains(query)){
                id = i;
                break;
            }
        }

        String resultItemText = list.get(id).getText();
        log.info("Result item contains the following text -> " + resultItemText);
        return resultItemText;

    }

    private static final By product =
            By.xpath("//android.widget.TextView[@resource-id='com.alibaba.aliexpresshd:id/tv_product_list_tagged_title']");
    public String gettingProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(resultListContainer));

        log.info("Getting the Product List");
        List<AndroidElement> list = driver.findElements(product);
        log.info("List elements Size " + list.size());
        String productText = list.get(0).getText();
        log.info("Going to Product Page");
        list.get(0).click();

        return productText;
    }

    private static final By productDotsMenuList =
            By.xpath("//android.widget.RelativeLayout[@resource-id='com.alibaba.aliexpresshd:id/mod_search_item_more_container']");
    public void prodcutDotsMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(resultListContainer));

        log.info("Click Open Product Dots Menus");
        List<AndroidElement> list = driver.findElements(productDotsMenuList);
        log.info("List elements Size " + list.size());
        list.get(0).click();
    }

    private static final By dotsMenuOptions = By.id("com.alibaba.aliexpresshd:id/m_search_operate");
    private static final By wishListBtn = By.id("com.alibaba.aliexpresshd:id/m_search_preview_action_add_wish");
    public void addingProductToWishList(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(dotsMenuOptions));
        log.info("Adding the product to the wish List");
        driver.findElement(wishListBtn).click();
    }

}
