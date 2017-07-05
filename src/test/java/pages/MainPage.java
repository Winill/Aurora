package pages;

import appmanager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Олег Калужин on 05.07.2017.
 */
public class MainPage extends TestBase{

  public Actions actions = new Actions(app.wd);

  By registrationButton = By.xpath("//span[@data-qaid='reg_element']");
  By asACustomer = By.linkText("Как покупатель");
  By categories = By.xpath("//div[@data-bazooka='MainMenu']");
  By clothesShoesAccessories = By.xpath("//span[. = 'Одежда, обувь, аксессуары' ]");
  By specialClothes = By.xpath("//span[. = 'Спецодежда и обувь' ]");
  By militaryClothes = By.xpath("//span[. = 'Военное обмундирование' ]");
  By vest = By.xpath("//span[. = 'Тельняшки' ]");
  By login = By.xpath(".//*[@id='head_control_panel']/div/div/div[2]/ul/li[4]/div/div/div[1]/a/span");



  public void moveToRegistration(){
    WebElement regBut = app.wd.findElement(registrationButton);
    actions.moveToElement(regBut, 1, 1).build().perform();
  }

  public void clickOnCustomerButton(){
    WebElement cust = app.wd.findElement(asACustomer);
    cust.click();
  }

  public void clickOnLogin() {
    WebElement cust = app.wd.findElement(login);
    cust.click();
  }
}
