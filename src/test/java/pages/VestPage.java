package pages;

import appmanager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Олег Калужин on 06.07.2017.
 */
public class VestPage extends TestBase {

  private Actions actions = new Actions(app.wd);

  private By cheap = By.linkText("Дешевые");
  private By expensive = By.linkText("Дорогие");
  private By firstElemInTable = By.xpath("//div[@class = 'x-gallery-tile__content'][1]");
  private By buttonBuy = By.xpath("//span[. = 'Купить' ]");
  private By closeCart = By.xpath("//span[@data-qaid='close_btn']");
  private By continueShopping = By.xpath("//span[@data-qaid='continue_shopping']");


  public void pressOnCheap(){
    app.wd.findElement(cheap).click();
    waitUrlToBe("https://prom.ua/Telnyashki?sort=price");
  }

  public void pressOnExpensive(){
    app.wd.findElement(expensive).click();
    waitUrlToBe("https://prom.ua/Telnyashki?sort=-price");
  }

  public void navigateToFirstElem(){
    WebElement clothes = app.wd.findElement(firstElemInTable);
    actions.moveToElement(clothes, 1, 1).build().perform();
  }

  public void pressBuy(){
    app.wd.findElement(buttonBuy).click();
  }

  public void closeCart(){
    app.wd.findElement(closeCart).click();
    waitElementBeClickable(app.wd.findElement(continueShopping));
  }

  private void waitUrlToBe(String partUrl) {
    app.wait = new WebDriverWait(app.wd, 30);
    app.wait.until(ExpectedConditions.urlToBe(partUrl));
  }

  private void waitElementBeClickable(WebElement element) {
    app.wait = new WebDriverWait(app.wd, 30);
    app.wait.until(ExpectedConditions.elementToBeClickable(element));
  }

}
