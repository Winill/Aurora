package appmanager;

import org.omg.CORBA.Object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oлег on 05.07.2017.
 */
public class App {
    public WebDriver wd;
    private String browser;
    public App(String browser){
        this.browser = browser;
                    }

    public void init() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "none");
        if (Objects.equals(browser, BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if (Objects.equals(browser, BrowserType.CHROME)) {
            wd = new ChromeDriver(capabilities);
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
}
