package tests;

import appmanager.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CustomerInfo;
import pages.MainPage;
import pages.RegistrationPage;
import pages.VestPage;

import java.awt.*;

public class PromTest extends TestBase{

    private MainPage mainPage;
    private RegistrationPage regPage;
    private CustomerInfo custInfo;
    private VestPage vestPage;

    @Test
    @Parameters
    public void testProm(String username, String email) throws AWTException, InterruptedException {

        app.wd.get("https://prom.ua/");
        mainPage = new MainPage();
        mainPage.moveToRegistration();
        mainPage.clickOnCustomerButton();
        regPage = new RegistrationPage();
        regPage.fillName(username);
        regPage.fillEmail(email);
        regPage.filldPassword("qwerty");
        regPage.confirmRegistration();
        custInfo = new CustomerInfo();
        custInfo.fillLastName("test");
        custInfo.fillMiddleName("test");
        custInfo.fillPhone("+31234567");
        custInfo.submitData();
        custInfo.clickOnLogo();
        mainPage.clickOnAllCategories();
        mainPage.navigateToClothes();
        mainPage.navigateToSpecialClothes();
        mainPage.navigateToMilitaryClothes();
        mainPage.navigateToVest();
        vestPage =  new VestPage();
        vestPage.pressOnCheap();
        vestPage.navigateToFirstElem();
        vestPage.pressBuy();
        vestPage.closeCart();
        vestPage.pressOnExpensive();
        vestPage.navigateToFirstElem();
        vestPage.pressBuy();
        vestPage.closeCart();

        //Assertions
        Assert.assertTrue(app.wd.getCurrentUrl().contains("https://prom.ua/shopping_cart/checkout/"));
        Assert.assertTrue(app.isElementPresent(By.cssSelector(".x-order-form")));
    }



    

}
