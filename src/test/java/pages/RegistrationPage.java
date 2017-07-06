package pages;

import appmanager.TestBase;
import org.openqa.selenium.By;


/**
 * Created by Олег Калужин on 06.07.2017.
 */
public class RegistrationPage extends TestBase {

  private By fieldName = By.name("vertical-name");
  private By fieldEmail = By.name("vertical-email");
  private By fieldPassword = By.name("vertical-password");
  private By registrationButton =  By.xpath("//div[@class='lp-vertical-form']//button[.='Зарегистрироваться']");


  public void fillName(String name){
    app.wd.findElement(fieldName).click();
    app.wd.findElement(fieldName).sendKeys(name);
  }

  public void fillEmail(String email){
    app.wd.findElement(fieldEmail).click();
    app.wd.findElement(fieldEmail).sendKeys(email);
  }

  public void filldPassword(String pass){
    app.wd.findElement(fieldPassword).click();
    app.wd.findElement(fieldPassword).sendKeys(pass);
  }

  public void confirmRegistration(){
    app.wd.findElement(registrationButton).click();
  }

}
