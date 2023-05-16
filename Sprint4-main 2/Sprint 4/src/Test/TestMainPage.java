package qa_scooter;

import Locators.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestMainPage  {
    WebDriver driver;

    private final String result;
    private final String accordionLocator;



    public TestMainPage(String result, String accordionLocator) {
        this.result = result;
        this.accordionLocator = accordionLocator;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                { "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее." },
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
    public void testMainPage()  throws InterruptedException {

        MainPage objMainPage = new MainPage(driver);
        objMainPage.scrollToMainQwestion();

        driver.findElement(By.xpath(accordionLocator)).click();
        String answerText = objMainPage.getOpenAnswerText();
        Assert.assertEquals("Текст различается",result, answerText );
    }
    @After
    public void quit() {
        driver.quit();
    }
}





