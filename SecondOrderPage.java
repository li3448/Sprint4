package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {
    private WebDriver driver;

    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Когда привезти самокат
    public By dateField = By.xpath("//div/input[@placeholder='* Когда привезти самокат']");

    //Срок аренды
    public By orderArrowTimeField = By.xpath("//div/span[@class='Dropdown-arrow']");


    public By orderDropTimeField = By.xpath("//div[contains(text(),'двое суток')]"); ///div[contains(text(),'двое суток')'//div[@class='Dropdown-menu']/div[2]

    //Цвет
    public By colorScooterCheck = By.xpath("//label[contains(text(),'чёрный жемчуг')]");

    //Комментарий
    public By orderComment = By.xpath("//div/input[@placeholder='Комментарий для курьера']");

    //Кнопка заказать
    public By orderBook = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]");

    //Подтверждение заказа
    public By orderConfirmation = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]");

    //Текст подтверждения заказа
    public By orderSocsessText = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    //Указать дату заказа
    public void setDateOrdier(String dataFields){
        driver.findElement(dateField).sendKeys(dataFields);}
    //Выбор срока аренды(1)
    public  void setOrderArrowTimeField(){
        driver.findElement(orderArrowTimeField).click();}
    //Выбор срока аренды(2)
    public  void setOrderDropTimeField(){
        driver.findElement(orderDropTimeField).click();}
    //Выбор цвета
    public  void setColorScooterCheck(){
        driver.findElement(colorScooterCheck).click();}
    //Добавление комментария
    public  void setOrderComments(String commentField){
        driver.findElement(orderComment).sendKeys(commentField);}
    //Кнопка заказать
    public void clicOrderBook() {
        driver.findElement(orderBook).click();}
    // Подтверждение заказа
    public  void setOrderConfirmation() {
        driver.findElement(orderConfirmation).click();
    }
    // Получение заказа из подтверждения заказа
    public String getOrderSocsessText() {
        String orderText = driver.findElement(orderSocsessText).getText();
        return orderText;
    }
    //Заполнение страницы 2
    public void fillSecondPage(String dataFields,String color, String commentField) {
        setDateOrdier(dataFields);
        setOrderArrowTimeField();
        setOrderDropTimeField();
        setColorScooterCheck();
        setOrderComments(commentField);
    }

}

