package pages;

import appmanager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Олег Калужин on 05.07.2017.
 */
public class MainPage extends TestBase{

  private Actions actions = new Actions(app.wd);

  private By registrationButton = By.xpath("//span[@data-qaid='reg_element']");
  private By asACustomer = By.linkText("Как покупатель");
  private By categories = By.xpath("//div[@data-bazooka='MainMenu']");
  private By clothesShoesAccessories = By.xpath("//span[. = 'Одежда, обувь, аксессуары' ]");
  private By specialClothes = By.xpath("//span[. = 'Спецодежда и обувь' ]");
  private By militaryClothes = By.xpath("//span[. = 'Военное обмундирование' ]");
  private By vest = By.xpath("//span[. = 'Тельняшки' ]");


  public void moveToRegistration(){
    WebElement regBut = app.wd.findElement(registrationButton);
    actions.moveToElement(regBut, 1, 1).build().perform();
  }

  public void clickOnCustomerButton(){
    WebElement cust = app.wd.findElement(asACustomer);
    cust.click();
  }

  public void clickOnAllCategories(){
    app.wd.findElement(categories).click();
  }

  public void navigateToClothes() throws InterruptedException {
    WebElement clothes = app.wd.findElement(clothesShoesAccessories);
    Thread.sleep(500);
    actions.moveToElement(clothes, 1, 1).build().perform();
  }

  public void navigateToSpecialClothes() throws InterruptedException {
    WebElement specClothes = app.wd.findElement(specialClothes);
    Thread.sleep(500);
    actions.moveToElement(specClothes, 1, 1).build().perform();
  }

  public void navigateToMilitaryClothes() throws InterruptedException {
    WebElement miliClothes = app.wd.findElement(militaryClothes);
    Thread.sleep(500);
    actions.moveToElement(miliClothes, 1, 1).build().perform();
  }

  public void navigateToVest() throws InterruptedException {
    WebElement clothForSeaMan = app.wd.findElement(vest);
    Thread.sleep(500);
    actions.moveToElement(clothForSeaMan, 1, 1).build().perform();
    clothForSeaMan.click();
  }

}
