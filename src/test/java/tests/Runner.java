package tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.account.AccountMenuPage;
import pages.account.AccountPage;
import pages.account.SignInPage;
import pages.pages.HomePage;
import pages.pages.Navigation;
import pages.pages.ResultsPage;
import pages.settings.CountrySettingsPage;
import pages.settings.CurrencySettingsPage;
import pages.settings.SettingsPage;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Runner extends Hooks{

    private static final Logger log = getLogger(Hooks.class.getName());

    @Test
    public void unsuccessfulLogin(){
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

        assertThat("Login validation fail", message,
                equalTo("Password is incorrect. Please try again."));
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

        assertThat("Search validation fails", resultText.toUpperCase(),
                containsString(query.toUpperCase()));

    }

    @Test
    public void verifyAddedProducts(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToHomeMenu();

    }

    @Test
    public void addProductToWishList(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToHomeMenu();

    }

    @Test
    public void SearchByImage(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToHomeMenu();

    }

    @Test
    public void addSearchFilter(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToHomeMenu();

    }

    @Test
    public void shareProduct(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToHomeMenu();

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

        assertThat("Country validation fails", newCountry,
                not(equalTo(actualCountry)));
    }
    
    @Test
    public void changeCurrency(){
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

        assertThat("Currency validation fails", newCcy,
                not(equalTo(actualCcy)));
    }

    @Test
    public void verifyPriceProduct(){
        log.info("Clicking Home menu");
        Navigation navigation = new Navigation(driver);
        navigation.goToHomeMenu();



    }




}
