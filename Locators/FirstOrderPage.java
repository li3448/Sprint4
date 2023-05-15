package Locators;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class FirstOrderPage {
    private WebDriver driver;

    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Имя
    public By Imya = By.xpath("//div/input[@placeholder='* Имя']");
    // Фамилия
    public By Familia = By.xpath("//div/input[@placeholder='* Фамилия']");
    // Куда привезти
    public By Street = By.xpath("//div/input[@placeholder='* Адрес: куда привезти заказ']");
    // Станция метро
    public By Metro = By.xpath("//div/input[@placeholder='* Станция метро']");
    // Телефон
    public By Telephone = By.xpath("//div/input[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее
    public By nextButton = By.xpath("//div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //  Метод внесения имени
    public void setImya(String firstName) {
        driver.findElement(this.Imya).sendKeys(firstName);
    }
    // Метод внесения фамилии
    public void setFamilia(String SecondName) {
        driver.findElement(this.Familia).sendKeys(SecondName);
    }
    // Метод внесения адреса
    public void setStreet(String streetName) {
        driver.findElement(Street).sendKeys(streetName);
    }
    // Метод внесения метро
    public void setMetro(String metroStation) {
        driver.findElement(Metro).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
    }
    //  Метод внесения номера телефона
    public void setTelephone(String phoneNumber) {
        driver.findElement(Telephone).sendKeys(phoneNumber);
    }
    //  Метод кликает по кнопке далее
    public void setNextButton() {
        driver.findElement(nextButton).click();}
    //Метод дата заказа

    // Заполнение первой страницы заказа
    public void fillFirstPage (String firstName, String secondName, String streetName, String metroStation, String phoneNumber) {
        setImya(firstName);
        setFamilia(secondName);
        setStreet(streetName);
        setMetro(metroStation);
        setTelephone(phoneNumber);
    }


}
