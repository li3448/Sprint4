package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Создали page object — класс для страницы Main
public class MainPage {
    // Добавили поле driver
    private WebDriver driver;

    //Куки
    private By cookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // "Вопросы о важном"
    private By mainQwestionText = By.xpath("//div[text()='Вопросы о важном']");

    // accordionBlock_0
    public By firstAccordionBlock = By.xpath("//div[@id='accordion__heading-0']");

    // accordionBlock_1
    public By secondAccordionBlock = By.xpath("//div[@id='accordion__heading-1']");

    // accordionBlock_2
    public By thirdAccordionBlock = By.xpath("//div[@id='accordion__heading-2']");

    //accordionBlock_3
    public By fofthAccordionBlock = By.xpath("//div[@id='accordion__heading-3']");

    // accordionBlock_4
    public By fifthAccordionBlock = By.xpath("//div[@id='accordion__heading-4']");

    // accordionBlock_6
    public By sixthAccordionBlock = By.xpath("//div[@id='accordion__heading-5']");

    // accordionBlock_7
    public By seventhAccordionBlock = By.xpath("//div[@id='accordion__heading-6']");

    //  accordionBlock_8
    public By eighthAccordionBlock = By.xpath("//div[@id='accordion__heading-7']");

    //Локатор ответа
    public By openAnswerText = By.xpath("//div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p");

    //Верхняя кнопка "Заказать"
    public By orderUpButton = By.xpath("//div/button[@class='Button_Button__ra12g']");

    //Нижняя кнопка "Заказать"
    public By orderDownButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    // конструктор класса page object
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //  Клик по кнопке «Куки»
    public void clickSignInButton() {
        driver.findElement(cookiesButton).click();
    }

    //Скролл до текста "Вопросы о важном"
    public void scrollToMainQwestion() {
        WebElement element = driver.findElement(mainQwestionText);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Получение текста ответа
    public String getOpenAnswerText() {
        String textElement = driver.findElement(openAnswerText).getText();
        return textElement;
    }

}
