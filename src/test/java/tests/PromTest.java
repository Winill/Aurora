package tests;

import appmanager.TestBase;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import pages.MainPage;

import static org.openqa.selenium.OutputType.*;

public class PromTest extends TestBase{
    /*WebDriver wd;*/
    private MainPage mainPage;



    
    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
        wd = new FirefoxDriver(capabilities);
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
    
    @Test
    public void testProm() throws AWTException, InterruptedException {

        wd.get("https://prom.ua/");
        Thread.sleep(10000);


        mainPage = new MainPage(wd);
        mainPage.moveToRegistration();
        mainPage.clickOnCustomerButton();
        Actions actions = new Actions(wd);
        WebElement reg = wd.findElement(By.xpath("//span[@data-qaid='reg_element']"));
        actions.moveToElement(reg, 1, 1).build().perform();

        wd.findElement(By.linkText("Как покупатель")).click();
        Thread.sleep(5000);

        //form
        wd.findElement(By.name("vertical-name")).click();
        wd.findElement(By.name("vertical-name")).clear();
        wd.findElement(By.name("vertical-name")).sendKeys("Test");

        wd.findElement(By.name("vertical-email")).click();
        wd.findElement(By.name("vertical-email")).clear();
        wd.findElement(By.name("vertical-email")).sendKeys("nuzujr@pcmylife.com");

        wd.findElement(By.name("vertical-password")).click();
        wd.findElement(By.name("vertical-password")).clear();
        wd.findElement(By.name("vertical-password")).sendKeys("Olaneg152");

        wd.findElement(By.xpath("//div[@class='lp-vertical-form']//button[.='Зарегистрироваться']")).click();

        //reg
        wd.findElement(By.id("last_name")).click();
        wd.findElement(By.id("last_name")).clear();
        wd.findElement(By.id("last_name")).sendKeys("Test");

        wd.findElement(By.id("middle_name")).click();
        wd.findElement(By.id("middle_name")).clear();
        wd.findElement(By.id("middle_name")).sendKeys("Test");

        wd.findElement(By.id("phones_dict-0-phone")).click();
        wd.findElement(By.id("phones_dict-0-phone")).clear();
        wd.findElement(By.id("phones_dict-0-phone")).sendKeys("+380667897452");

        wd.findElement(By.id("submit_button")).click();

        wd.findElement(By.cssSelector("img.x-header__logo-img")).click();

        //main
        WebElement Bazooka = wd.findElement(By.xpath("//div[@data-bazooka='MainMenu']"));
        Bazooka.click();

        WebElement OOA = wd.findElement(By.xpath("//span[. = 'Одежда, обувь, аксессуары' ]"));
        Thread.sleep(500);
        actions.moveToElement(OOA, 1, 1).build().perform();

        WebElement SO = wd.findElement(By.xpath("//span[. = 'Спецодежда и обувь' ]"));
        Thread.sleep(500);
        actions.moveToElement(SO, 1, 1).build().perform();

        WebElement WO = wd.findElement(By.xpath("//span[. = 'Военное обмундирование' ]"));
        Thread.sleep(500);
        actions.moveToElement(WO, 1, 1).build().perform();

        WebElement Tel = wd.findElement(By.xpath("//span[. = 'Тельняшки' ]"));
        Thread.sleep(500);
        actions.moveToElement(Tel, 1, 1).build().perform();
        Tel.click();

        Thread.sleep(10000);

        wd.get("https://prom.ua/Telnyashki");

        wd.findElement(By.linkText("Дешевые")).click();
        Thread.sleep(4000);
        System.out.println(1);
        WebElement Des = wd.findElement(By.xpath("//div[@class = 'x-gallery-tile__content'][1]"));
        actions.moveToElement(Des, 1, 1).build().perform();
        System.out.println(2);
        Des.findElement(By.xpath("//span[. = 'Купить' ]")).click();
        System.out.println(3);
        Thread.sleep(4000);
        wd.findElement(By.xpath("//span[@data-qaid='close_btn']")).click();


        wd.findElement(By.linkText("Дорогие")).click();
        Thread.sleep(4000);
        System.out.println(5);
        WebElement Dor = wd.findElement(By.xpath("//div[@class = 'x-gallery-tile__content'][1]"));
        actions.moveToElement(Dor, 1, 1).build().perform();
        System.out.println(6);
        Dor.findElement(By.xpath("//span[. = 'Купить' ]")).click();
        System.out.println(7);
        Thread.sleep(5000);
        wd.findElement(By.cssSelector("//span[@data-qaid='close_btn']")).click();
        Thread.sleep(5000);
    }


    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
