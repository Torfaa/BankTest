import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class TestTest { WebDriver webDriver;

@BeforeSuite
public void setUp(){
   System.setProperty("webdriver.chrome.driver","C:\\web\\chromedriver.exe");
    webDriver = new ChromeDriver();


}


     @Test
    public void Test1 () throws InterruptedException {

         webDriver.get("https://rencredit.ru/");
         webDriver.findElement(By.xpath("//a[@href='https://rencredit.ru/contributions/#section_5']")).click();

          Thread.sleep(5000);
          WebElement webElem = webDriver.findElement((By.className("calculator__check-block-input")));
              Actions action = new Actions(webDriver);
              action.moveToElement(webElem).click().perform();

          WebElement webElem2 = webDriver.findElement(By.className("calculator__slide-input-field"));
          Actions action2 = new Actions(webDriver);
             action2.moveToElement(webElem2).click().perform();
             action2.moveToElement(webElem2).sendKeys("2000000").perform();

         Thread.sleep(1000);

         webDriver.findElement(By.xpath("//*[@id=\"period-styler\"]/div[1]/div[1]")).click();
         WebElement dropbox =   webDriver.findElement(By.cssSelector("  #period-styler > div.jq-selectbox__dropdown > ul > li:nth-child(1)"));
            Actions action3 = new Actions(webDriver);
             action3.moveToElement(dropbox).click().perform();

         Thread.sleep(1000);

         webDriver.findElement(By.cssSelector("#section_2 > div > div.tabs.js-tabs > div.tabs-content > div:nth-child(1) > div.deposits-terms__info-doc-row > div > h3 > a")).click();

         Thread.sleep(5000);

         Actions keyAction = new Actions(webDriver);
         keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();





         }




    @Test
    public void Test2 () throws InterruptedException {

        webDriver.get("https://rencredit.ru/");
        webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[3]/div[1]/a[2]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"t1\"]")).sendKeys("Перегняк");
        webDriver.findElement(By.xpath("//*[@id=\"t2\"]")).sendKeys("Павел");
        webDriver.findElement(By.cssSelector("#section_1 > div.order-form-block__content > div > form > div:nth-child(1) > div:nth-child(4) > div > label > div")).click();
        webDriver.findElement(By.cssSelector("#r1-styler")).click();
        webDriver.findElement(By.xpath("//*[@id=\"t38\"]")).sendKeys("test@mail.com");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"t4\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"t4\"]")).sendKeys("9233973301");

        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector("#s2-styler > div.jq-selectbox__dropdown > ul > li:nth-child(36)")).click();

        webDriver.quit();


    }

     }



