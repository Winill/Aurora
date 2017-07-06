package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oлег on 05.07.2017.
 */
public class App {
    public WebDriver wd;
    public Wait<WebDriver> wait;
    private String browser;
    App(String browser){
        this.browser = browser;
                    }

    void init() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
        if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver(capabilities);
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
