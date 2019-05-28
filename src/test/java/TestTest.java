import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestTest {
    static WebDriver webDriver;
    static String cuuret;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\web\\chromedriver.exe");
        webDriver = new ChromeDriver();


    }


    @Test
    public void Test1() throws InterruptedException {

        webDriver.get("https://rencredit.ru/");

        webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[2]/div[1]/a[1]")).click();
        cuuret = webDriver.getCurrentUrl();
        checkRedirectByURL("https://rencredit.ru/contributions/", cuuret);
        Thread.sleep(4000);
        WebElement webElem = webDriver.findElement((By.className("calculator__check-block-input")));
        Actions action = new Actions(webDriver);
        action.moveToElement(webElem).click().perform();

        WebElement webElem2 = webDriver.findElement(By.className("calculator__slide-input-field"));
        Actions action2 = new Actions(webDriver);
        action2.moveToElement(webElem2).click().perform();
        action2.moveToElement(webElem2).sendKeys("2000000").perform();

        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[@id=\"period-styler\"]/div[1]/div[1]")).click();
        WebElement dropbox = webDriver.findElement(By.cssSelector("  #period-styler > div.jq-selectbox__dropdown > ul > li:nth-child(1)"));
        Actions action3 = new Actions(webDriver);
        action3.moveToElement(dropbox).click().perform();

        Thread.sleep(1000);

        webDriver.findElement(By.cssSelector("#section_2 > div > div.tabs.js-tabs > div.tabs-content > div:nth-child(1) > div.deposits-terms__info-doc-row > div > h3 > a")).click();

        Thread.sleep(4000);


        Actions keyAction = new Actions(webDriver);
        keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
        Thread.sleep(4000);


    }


    @Test
    public void Test2() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.get("https://rencredit.ru/");
        webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[3]/div[1]/a[2]")).click();

        cuuret = webDriver.getCurrentUrl();
        checkRedirectByURLTest2("https://rencredit.ru/app/card/cc_full", cuuret);

        webDriver.findElement(By.xpath("//*[@id=\"t1\"]")).sendKeys("Перегняк");
        checkIsNotNullFieldsTest2("//*[@id=\"t1\"]");

        webDriver.findElement(By.xpath("//*[@id=\"t2\"]")).sendKeys("Павел");
        checkIsNotNullFieldsTest2("//*[@id=\"t2\"]");

        webDriver.findElement(By.cssSelector("#section_1 > div.order-form-block__content > div > form > div:nth-child(1) > div:nth-child(4) > div > label > div")).click();
        checkСheckboxSelect("#section_1 > div.order-form-block__content > div > form > div:nth-child(1) > div:nth-child(4) > div > label > div");

        webDriver.findElement(By.xpath("//*[@id=\"t38\"]")).sendKeys("test@mail.com");
        checkIsNotNullFieldsTest2("//*[@id=\"t38\"]");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"t4\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"t4\"]")).sendKeys("9233973301");
        checkIsNotNullFieldsTest2("//*[@id=\"t4\"]");


        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector("#s2-styler > div.jq-selectbox__dropdown > ul > li:nth-child(36)")).click();
        webDriver.findElement(By.cssSelector("#s3-styler > div.jq-selectbox__select > div.jq-selectbox__select-text.placeholder")).click();
        webDriver.findElement(By.cssSelector("#s3-styler > div.jq-selectbox__dropdown > ul > li:nth-child(4)")).click();
        checkDropList("#s2-styler > div.jq-selectbox__dropdown > ul > li:nth-child(36)");
        checkDropList("#s3-styler > div.jq-selectbox__dropdown > ul > li:nth-child(4)");
        Thread.sleep(4000);
        webDriver.quit();


    }

    @Step("Проверка осуществления перехода на URL='{https://rencredit.ru/contributions/}'.")
    public static void checkRedirectByURL(String expectedUrl, String currentUrl) {

        Assert.assertEquals(currentUrl, expectedUrl, "URL не соответствует ожидаемому");
    }


    @Step("Проверка осуществления перехода на URL='{https://rencredit.ru/app/card/cc_full}'.")
    public static void checkRedirectByURLTest2(String expectedUrl, String currentUrl) {

        Assert.assertEquals(currentUrl, expectedUrl, "URL не соответствует ожидаемому");
    }

    @Step("Проверка на пустое поле")
    public static void checkIsNotNullFieldsTest2(String xpath) {
        Assert.assertNotNull(webDriver.findElement(By.xpath(xpath)).getText(), "Поле пустое");

    }

    @Step("Проверка, выбран ли чекбокс")
    public static void checkСheckboxSelect(String cssSelector) {
        Assert.assertEquals(webDriver.findElement(By.cssSelector(cssSelector)).getAttribute("checked"),null,"Чекбокс выбран");


    }

    @Step("Проверка, выпадающий список не пустой")
    public static void checkDropList(String cssSelector) {
        Assert.assertEquals(webDriver.findElement(By.cssSelector(cssSelector)).getAttribute("changed"),null,"Выпадающий список выбран");


    }


}



