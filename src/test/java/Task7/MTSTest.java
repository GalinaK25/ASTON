package Task7;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MTSTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie")));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("NO banner");
        }
    }

    @Test
    public void checkBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        Assertions.assertNotNull(blockTitle, "Блок 'Онлайн пополнение без комиссии' не найден");
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", blockTitle.getText(), "Название блока не совпадает");
    }

    @Test
    public void checkPaymentLogos() {
        List<WebElement> logoVisa = driver.findElements(By.cssSelector(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(1) > img"));
        Assertions.assertFalse(logoVisa.isEmpty(), "Логотип 'Visa' не найден");
        List<WebElement> logoVerifiedByVisa = driver.findElements(By.cssSelector(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(2) > img"));
        Assertions.assertFalse(logoVerifiedByVisa.isEmpty(), "Логотип 'Verified By Visa' не найден");
        List<WebElement> logoMasterCard = driver.findElements(By.cssSelector(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(3) > img"));
        Assertions.assertFalse(logoMasterCard.isEmpty(), "Логотип 'MasterCard' не найден");
        List<WebElement> logoMasterCardSecureCode = driver.findElements(By.cssSelector(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(4) > img"));
        Assertions.assertFalse(logoMasterCardSecureCode.isEmpty(), "Логотип 'MasterCard Secure Code' не найден");
        List<WebElement> logoBelkart = driver.findElements(By.cssSelector(
                "#pay-section > div > div > div.col-12.col-xl-8 > section > div > div.pay__partners > ul > li:nth-child(5) > img"));
        Assertions.assertFalse(logoBelkart.isEmpty(), "Логотип 'Белкарт' не найден");
    }

    @Test
    public void checkMoreInfoServiceLink() {
        WebElement moreInfoServiceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoServiceLink.click();
        Assertions.assertTrue(driver.getTitle().contains("Порядок оплаты и безопасность интернет платежей"),
                "Ссылка 'Подробнее о сервисе' не работает корректно");
        driver.navigate().back();
    }

    @Test
    public void fillFormAndContinueButton() {
        WebElement payType = driver.findElement(By.className("select__header"));
        WebElement payTypeChoice = driver.findElement(By.xpath("//div[@class=\"pay__form\"]//ul/li[1]"));
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        WebElement summa = driver.findElement(By.id("connection-sum"));
        WebElement continueButton = driver.findElement(
                By.xpath("//form[@id=\"pay-connection\"]//button[@class=\"button button__default \"]"));
        payType.click();
        payTypeChoice.click();
        phoneNumberInput.sendKeys("297777777");
        summa.sendKeys("10");
        //Assertions.assertEquals("Услуги связи", payTypeChoice.getText(), "Тип оплаты должен быть 'Услуги связи'");
        //Assertions.assertEquals("(29)777-77-77", phoneNumberInput.getAttribute("value"), "Номер телефона должен быть '(29)777-77-77'");
        //Assertions.assertEquals("10", summa.getAttribute("value"), "Сумма должна быть '10'");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(payTypeChoice.getText()).as("Тип оплаты должен быть 'Услуги связи'").isEqualTo("Услуги связи");
        softly.assertThat(phoneNumberInput.getAttribute("value")).as("Номер телефона должен быть '(29)777-77-77'").isEqualTo("(29)777-77-77");
        softly.assertThat(summa.getAttribute("value")).as("Сумма должна быть '10'").isEqualTo("10");
        softly.assertAll();
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[@class='bepaid-app']//iframe[@class='bepaid-iframe']")));
            driver.switchTo().frame(iframe);
        } catch (Exception e) {
            System.out.println("NO iframe");
        }
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

