package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Олег Калужин on 05.07.2017.
 */
public class MainPage {

  private WebDriver wd = new FirefoxDriver();
  private Actions actions = new Actions(wd);

  By registrationButton = By.xpath("//span[@data-qaid='reg_element']");
  /*WebElement registrationButton = wd.findElement(By.xpath("//span[@data-qaid='reg_element']"));*/
  WebElement asACustomer = wd.findElement(By.linkText("Как покупатель"));
  By categories = By.xpath("//div[@data-bazooka='MainMenu']");
  By clothesShoesAccessories = By.xpath("//span[. = 'Одежда, обувь, аксессуары' ]");
  By specialClothes = By.xpath("//span[. = 'Спецодежда и обувь' ]");
  By militaryClothes = By.xpath("//span[. = 'Военное обмундирование' ]");
  By vest = By.xpath("//span[. = 'Тельняшки' ]");

  public MainPage(WebDriver driver) {
    this.wd = driver;
  }

  public void moveToRegistration(){
    WebElement regBut = wd.findElement(registrationButton);
    actions.moveToElement(regBut, 1, 1).build().perform();
  }

  public void clickOnCustomerButton(){
    asACustomer.click();
  }
}
