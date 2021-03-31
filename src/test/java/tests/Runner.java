package tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.account.AccountMenuPage;
import pages.account.AccountPage;
import pages.account.SignInPage;
import pages.pages.*;
import pages.settings.CountrySettingsPage;
import pages.settings.CurrencySettingsPage;
import pages.settings.SettingsPage;

import static org.apache.logging.log4j.LogManager.getLogger;

@Listeners({ExtentITestListenerClassAdapter.class})
public class Runner extends Hooks{

    private static final Logger log = getLogger(Hooks.class.getName());

    @Test
    public void unsuccessfulLogin(){
        log.info("Main Menu Validation");
        HomePage homePage = new HomePage(driver);
        homePage.homePageCheck();

        log.info("Clicking pages.account menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToAccountMenu();

        log.info("Clicking SignIn Link");
        AccountMenuPage accountMenuPage = new AccountMenuPage(driver);
        accountMenuPage.goToRegisterLoginPage();

        log.info("Clicking SignIn Button");
        AccountPage accountPage = new AccountPage(driver);
        accountPage.goToLoginPage();

        log.info("Sending username/password and Click LogIn");
        SignInPage signInPage = new SignInPage(driver);
        String message = signInPage.login();
        log.info(message);

            SoftAssert softAssertion= new SoftAssert();
            softAssertion.assertEquals(message,
                    "Password is incorrect. Please try again.", "Login validation fail");
            softAssertion.assertAll();
    }

    @Test
    public void searchProduct(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToHomeMenu();

        log.info("Sending Query");
        HomePage homePage = new HomePage(driver);
        String query = "rubik";
        homePage.searchItem(query);

        //Getting Results
        log.info("Getting Results");
        ResultsPage resultsPage = new ResultsPage(driver);
        String resultText = resultsPage.getResultsList(query);


        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertTrue(resultText.toUpperCase().contains(query.toUpperCase()),
                "Search validation fails");
        softAssertion.assertAll();

        log.info("Going to Home Menu");
        TopMenu topMenu = new TopMenu(driver);
        topMenu.getDotMenu();
        topMenu.getHomeMenu();

        log.info("Main Menu Validation");
        homePage.homePageCheck();
    }

    @Test
    public void AddProductToCar(){

        log.info("Sending Query");
        HomePage homePage = new HomePage(driver);
        String query = "rubik";
        homePage.searchItem(query);

        log.info("Getting the Product");
        ResultsPage resultsPage = new ResultsPage(driver);
        String product = resultsPage.gettingProduct();
        log.info("PRODUCT TITLE -> " + product);

        log.info("Adding Product to the Car");
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCar();

        log.info("Go to Car Top menu");
        TopMenu topMenu = new TopMenu(driver);
        topMenu.getCarMenu();

        log.info("Going to car Page");
        CarPage carPage= new CarPage(driver);
        String resultText = carPage.getCarResults(query);

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertTrue(resultText.toUpperCase().contains(query.toUpperCase()),
                "Search validation fails");
        softAssertion.assertAll();

    }

    @Test
    public void verifyAddedProducts(){
        log.info("Verify Product Added to the Car");
        Navigation navigation = new Navigation(driver);
        navigation.goToCarMenu();
        String query = "rubik";

        log.info("Going to car Page");
        CarPage carPage= new CarPage(driver);
        String resultText = carPage.getCarResults(query);

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertTrue(resultText.toUpperCase().contains(query.toUpperCase()),
                "Search validation fails");
        softAssertion.assertAll();

    }

    @Test
    public void verifyPriceProduct(){
        log.info("Sending Query");
        HomePage homePage = new HomePage(driver);
        String query = "rubik";
        homePage.searchItem(query);

        log.info("Getting the Product");
        ResultsPage resultsPage = new ResultsPage(driver);
        String product = resultsPage.gettingProduct();
        log.info("PRODUCT TITLE -> " + product);

        log.info("Adding Product to the Car");
        ProductPage productPage = new ProductPage(driver);
        String priceProductValue = productPage.checkProductPrice();


        log.info("Product price is -> " + priceProductValue);
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertNotEquals(priceProductValue, "0.00",
                "Price product validation fails");
        softAssertion.assertAll();

        log.info("Going to Home Menu");
        TopMenu topMenu = new TopMenu(driver);
        topMenu.getDotMenu();
        topMenu.getHomeMenu();

        log.info("Main Menu Validation");
        homePage.homePageCheck();

    }

    @Test
    public void addProductToWishList(){
        log.info("Sending Query");
        HomePage homePage = new HomePage(driver);
        String query = "rubik";
        homePage.searchItem(query);

        log.info("Clicking Product 3 Dots Menu");
        ResultsPage resultsPage = new ResultsPage(driver);
        resultsPage.prodcutDotsMenu();
        resultsPage.addingProductToWishList();

        log.info("LogIn Pre-Requisite Validation");

        AccountPage accountPage = new AccountPage(driver);
        boolean userNotLogged = accountPage.checkRegisterLogInPage();

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertFalse(userNotLogged, "User must Be Logged");
        softAssertion.assertAll();

    }

    @Test
    public void shareProduct(){
        log.info("Sending Query");
        HomePage homePage = new HomePage(driver);
        String query = "rubik";
        homePage.searchItem(query);

        log.info("Getting the Product");
        ResultsPage resultsPage = new ResultsPage(driver);
        String product = resultsPage.gettingProduct();
        log.info("PRODUCT TITLE -> " + product);


        log.info("Top Dots Menu");
        TopMenu topMenu = new TopMenu(driver);
        topMenu.getShareMenu();

        log.info("Share Options");
        ShareOptions shareOptions = new ShareOptions(driver);
        String shareLink = shareOptions.clickShareMoreOptions();

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertNotNull(shareLink, "Link use not generated");
        softAssertion.assertAll();
    }

    @Test
    public void changeShippingCountry(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToAccountMenu();

        log.info("Going to Settings");
        AccountMenuPage accountMenuPage = new AccountMenuPage(driver);
        accountMenuPage.goToSettingsPage();

        log.info("Going to Country Settings");
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.goToCountrySettings();

        CountrySettingsPage countrySettingsPage = new CountrySettingsPage(driver);
        log.info("Getting the actual country");
        String actualCountry = countrySettingsPage.getActualCountry();
        log.info("ACTUAL Country >>> "+ actualCountry);

        log.info("Set new country");
        String newCountry = countrySettingsPage.setCountry();
        log.info("NEW Country Set >>> "+ newCountry);

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertNotEquals(newCountry, actualCountry,"Search validation fails");
        softAssertion.assertAll();

        log.info("go to Main Activity");
        HomePage homePage = new HomePage(driver);
        homePage.homePageCheck();
    }
    
    @Test
    public void changeCurrency(){
        log.info("go to Main Activity");
        HomePage homePage = new HomePage(driver);
        homePage.homePageCheck();

        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToAccountMenu();

        log.info("Going to Account Settings Page");
        AccountMenuPage accountMenuPage = new AccountMenuPage(driver);
        accountMenuPage.goToSettingsPage();

        log.info("Get the Actual Currency set");
        CurrencySettingsPage currencySettingsPage = new CurrencySettingsPage(driver);
        String actualCcy = currencySettingsPage.getActualCurrency();

        log.info("Going to Currency Settings");
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.goToCcySettings();

        log.info("Set new Currency");
        String newCcy = currencySettingsPage.setCurrency();

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertNotEquals(newCcy, actualCcy,"Search validation fails");
        softAssertion.assertAll();

        log.info("go to Main Activity");
        homePage.homePageCheck();
    }
}
