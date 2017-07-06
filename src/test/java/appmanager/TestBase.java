package appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



/**
 * Created by Олег Калужин on 05.07.2017.
 */
public class TestBase {
    protected static final App app = new App(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();

    }
    @AfterMethod
    public void tearDown() {
        app.wd.quit();
    }

}
