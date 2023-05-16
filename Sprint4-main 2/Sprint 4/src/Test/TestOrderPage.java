package qa_scooter;

import Locators.FirstOrderPage;
import Locators.MainPage;
import Locators.SecondOrderPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class TestOrderPage {

    private final String orderButtonLocator;
    private final String firstName;
    private final String secondName;
    private final String streetName;
    private final String metroStation;
    private final String phoneNumber;
    private final String dataFields;
    private final String commentField;

    WebDriver driver;

    public TestOrderPage(String orderButtonLocator, String firstName, String secondName, String streetName, String metroStation, String phoneNumber, String dataFields, String commentField) {
        this.orderButtonLocator = orderButtonLocator;
        this.firstName = firstName;
        this.secondName = secondName;
        this.streetName = streetName;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.dataFields = dataFields;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] getCostumersData() {
        return new Object[][] {
                { "Елизавета", "Кузнецова", "Зеленоград, 1462", "Андреевка", "89060485147", "18.03.2023", "Хорошо"},
        };
    }

    @Before
    public void startDriver () {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSignInButton();
    }

    @Test
    public void testUpOrderButton ()  {
        MainPage objMainPage = new MainPage(driver);
        driver.findElement(By.xpath(orderUpButton)).click();
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        firstOrderPage.fillFirstPage(firstName, secondName, streetName, metroStation,phoneNumber);
        firstOrderPage.setNextButton();
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillSecondPage(dataFields,commentField);
        secondOrderPage.clicOrderBook();
        secondOrderPage.setOrderConfirmation();
        String orderText = secondOrderPage.getOrderSocsessText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }


    @Test
    public void testDownOrderButton ()  {
        MainPage objMainPage = new MainPage(driver);
        driver.findElement(By.xpath(orderDownButton)).click();
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        firstOrderPage.fillFirstPage(firstName, secondName, streetName, metroStation,phoneNumber);
        firstOrderPage.setNextButton();
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillSecondPage(dataFields,commentField);
        secondOrderPage.clicOrderBook();
        secondOrderPage.setOrderConfirmation();
        String orderText = secondOrderPage.getOrderSocsessText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    
    @After
    public void quit() {
        driver.quit();
    }
}
