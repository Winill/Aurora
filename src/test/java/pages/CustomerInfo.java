package pages;

import appmanager.TestBase;
import org.openqa.selenium.By;

/**
 * Created by Олег Калужин on 06.07.2017.
 */
public class CustomerInfo extends TestBase{

  private By lastName = By.id("last_name");
  private By middleName = By.id("middle_name");
  private By phoneNumber = By.id("phones_dict-0-phone");
  private By submitButton =  By.id("submit_button");
  private By headerLogo =  By.cssSelector("img.x-header__logo-img");


  public void fillLastName(String last){
    app.wd.findElement(lastName).click();
    app.wd.findElement(lastName).sendKeys(last);
  }

  public void fillMiddleName(String middle){
    app.wd.findElement(middleName).click();
    app.wd.findElement(middleName).sendKeys(middle);
  }

  public void fillPhone(String phone){
    app.wd.findElement(phoneNumber).click();
    app.wd.findElement(phoneNumber).sendKeys(phone);
  }

  public void submitData(){
    app.wd.findElement(submitButton).click();
  }

  public void clickOnLogo(){
    app.wd.findElement(headerLogo).click();
  }
}
