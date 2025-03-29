package Task8;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MTSPaymentFrame {
    private final WebDriver driver;
    private static WebDriverWait wait = null;

    public final static By iframe = By.xpath("//iframe[@class='bepaid-iframe']");
    public final static By summaText = By.xpath("//div[@class=\"pay-description__cost\"]/span[text()=\"10.00 BYN\"]");
    public final static By phoneText = By.xpath("//div[@class=\"pay-description__text\"]//span[contains(text(), 'Номер:375297777777')]");
    public final static By payButton = By.xpath("//div[@class=\"card-page__card\"]//button[text()=\" Оплатить  10.00 BYN \"]");

    public static final By cardExpireInput = By.xpath("//label[contains(.,'Срок действия')]");
    public static final By cardNumberInput = By.xpath("//label[contains(.,'Номер карты')]");
    public static final By cardCVCInput = By.xpath("//label[contains(.,'CVC')]");
    public static final By cardOwnerInput = By.xpath("//label[contains(.,'Имя держателя (как на карте)')]");

    public final static By visaIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']");
    public final static By mastercardIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    public final static By belkartIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    public final static By maestroIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");
    public final static By mirIcon = By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system.svg']");

    public MTSPaymentFrame(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void switchToFrame() {
        try {
            System.out.println("Переключение на фрейм");
            WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iframe));
            wait.until(ExpectedConditions.visibilityOf(frameElement));
            driver.switchTo().frame(frameElement);
            System.out.println("Фрейм обнаружен");
        } catch (TimeoutException e) {
            System.out.println("Фрейм не обнаружен: " + e);
        }
    }

    public String getLabelText(By locator) {
        try {
            //return driver.findElement(locator).getAttribute("label");
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            return null;
        }
    }

    public static WebElement verifyElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            System.out.println("Элемент не найден");
            return false;
        }
    }

    public void switchFromFrame() {
        driver.switchTo().defaultContent();
    }

}



