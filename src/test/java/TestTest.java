import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestTest {
    static WebDriver webDriver;
    static String current;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Torf\\IdeaProjects\\BankTest\\chromedriver.exe");
        webDriver = new ChromeDriver();


    }

    @Epic(value = "Ренессанс Кредит")
    @Test
    public void Test1() throws InterruptedException {

        webDriver.get("https://rencredit.ru/");

        webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[2]/div[1]/a[1]")).click();
        current = webDriver.getCurrentUrl();
        Thread.sleep(2000);
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

        Thread.sleep(2000);


        Actions keyAction = new Actions(webDriver);
        keyAction.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);


    }

    @Epic(value = "Ренессанс Кредит")
    @Feature(value = "страница Карта сайта Ренессанс Кредит")
    @Description(value = "Тест проверяет элементы на странице Карта")
    @Test
    public void Test2() throws InterruptedException {
        try {


            Thread.sleep(1000);
            webDriver.get("https://rencredit.ru/");
            webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div[2]/div[3]/div[1]/a[2]")).click();

            current = webDriver.getCurrentUrl();
            checkRedirectByURLTest2("https://rencredit.ru/app/card/cc_full", current);

            String lastName = "//*[@id=\"t1\"]";
            WebElement lastNameElement = webDriver.findElement(By.xpath(lastName));
            String lastNameExpected = "Перегняк";
            lastNameElement.sendKeys(lastNameExpected);
            checkStringEquals("Фамилия", lastNameExpected, lastNameElement.getAttribute("value"));

            String firstName = "//*[@id=\"t2\"]";
            WebElement firstNameElement = webDriver.findElement(By.xpath(firstName));
            String expectedFirstName = "Павел";
            firstNameElement.sendKeys(expectedFirstName);
            checkStringEquals("Имя", expectedFirstName, firstNameElement.getAttribute("value"));

            String checkbox = "#section_1 > div.order-form-block__content > div > form > div:nth-child(1) > div:nth-child(4) > div > label > div";
            WebElement checkboxElement = webDriver.findElement(By.cssSelector(checkbox));
            checkboxElement.click();
            checkСheckboxSelect(checkboxElement);

            String email = "//*[@id=\"t38\"]";
            WebElement emailElement = webDriver.findElement(By.xpath(email));
            String expectedEmail = "test@mail.com";
            emailElement.sendKeys(expectedEmail);
            checkStringEquals("Email", expectedEmail, emailElement.getAttribute("value"));

            Thread.sleep(1000);
            String phone = "//*[@id=\"t4\"]";
            String expectedPhone = "+7 (923) 397-33-01";
            WebElement phoneElement = webDriver.findElement(By.xpath(phone));
            phoneElement.click();
            phoneElement.sendKeys("9233973301");
            checkStringEquals("Телефон", expectedPhone, phoneElement.getAttribute("value"));


            Thread.sleep(1000);
            String obl = "#s2-styler > div.jq-selectbox__dropdown > ul > li:nth-child(36)";
            String fieldObl = webDriver.findElement(By.cssSelector("#s2 > option:nth-child(36)")).getText();
            String expectedCity = "Пензенская область";
            webDriver.findElement(By.cssSelector(obl)).click();
            webDriver.findElement(By.cssSelector("#s3-styler > div.jq-selectbox__select > div.jq-selectbox__select-text.placeholder")).click();
            webDriver.findElement(By.cssSelector("#s3-styler > div.jq-selectbox__dropdown > ul > li:nth-child(4)")).click();
            checkDropList(fieldObl,"Область",expectedCity);


            Thread.sleep(2000);
        } finally {
            webDriver.quit();
        }


    }


    @Step("переход на URL {currentUrl}")
        public static void checkRedirectByURLTest2(String expectedUrl, String currentUrl) {

        Assert.assertEquals(currentUrl, expectedUrl, "URL не соответствует ожидаемому");
    }

    @Step("Пустое ли поле {fieldName}")
       public static void checkStringEquals(String fieldName, String expected, String actual) {
        Assert.assertEquals(actual, expected, "Поле пустое:" + fieldName);
    }

    @Step("Выбран ли чекбокс")
       public static void checkСheckboxSelect(WebElement checkboxCssSelector) {
        Assert.assertTrue(checkboxCssSelector.getAttribute("class").contains("checked"), "Чекбокс не выбран");
    }


    @Step("В выпадающем списке выбрана {myoption}")
        public static void checkDropList(String myoption,String namelist,String expectedCity) {

        Assert.assertEquals(myoption,expectedCity , "В списке выбрана"+ namelist);
    }
}



