package Task8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MTSPaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final By cookieBanner = By.className("cookie");
    public static final By acceptCookieButton = By.id("cookie-agree");
    public static final By blockTitle = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    public static final By paymentLogos = By.cssSelector("#pay-section .pay__partners ul li img");//заменила на сокращенный селектор
    public static final By moreInfoServiceLink = By.linkText("Подробнее о сервисе");

    public static final By payType = By.className("select__header");
    public static final By payConnection = By.xpath("//div[@class=\"pay__form\"]//ul/li[1]");
    public static final By payInternet = By.xpath("//div[@class=\"pay__form\"]//ul/li[2]");
    public static final By payInstalment = By.xpath("//div[@class=\"pay__form\"]//ul/li[3]");
    public static final By payArrears = By.xpath("//div[@class=\"pay__form\"]//ul/li[4]");

    public static final By continueButtonPayConnection = By.xpath("//*[@id=\"pay-connection\"]/button");
    public static final By continueButtonPayInternet = By.xpath("//*[@id=\"pay-internet\"]/button");
    public static final By continueButtonPayInstalment = By.xpath("//*[@id=\"pay-instalment\"]/button");
    public static final By continueButtonPayArrears = By.xpath("//*[@id=\"pay-arrears\"]/button");

    public static final By payConnectionPhoneNumberInput = By.xpath("//form[@id=\"pay-connection\"]//input[@placeholder=\"Номер телефона\"]");
    public static final By payConnectionSummaInput = By.xpath("//form[@id=\"pay-connection\"]//input[@placeholder=\"Сумма\"]");
    public static final By payConnectionEmailInput = By.xpath("//form[@id=\"pay-connection\"]//input[@placeholder=\"E-mail для отправки чека\"]");
    public static final By payInternetAbonentNumberInput = By.xpath("//form[@id=\"pay-internet\"]//input[@placeholder=\"Номер абонента\"]");
    public static final By payInternetSummaInput = By.xpath("//form[@id=\"pay-internet\"]//input[@placeholder=\"Сумма\"]");
    public static final By payInternetEmailInput = By.xpath("//form[@id=\"pay-internet\"]//input[@placeholder=\"E-mail для отправки чека\"]");
    public static final By payInstalmentCountNumberInput = By.xpath("//form[@id=\"pay-instalment\"]//input[@placeholder=\"Номер счета на 44\"]");
    public static final By payInstalmentSummaInput = By.xpath("//form[@id=\"pay-instalment\"]//input[@placeholder=\"Сумма\"]");
    public static final By payInstalmentEmailInput = By.xpath("//form[@id=\"pay-instalment\"]//input[@placeholder=\"E-mail для отправки чека\"]");
    public static final By payArrearsCountNumberInput = By.xpath("//form[@id=\"pay-arrears\"]//input[@placeholder=\"Номер счета на 2073\"]");
    public static final By payArrearsSummaInput = By.xpath("//form[@id=\"pay-arrears\"]//input[@placeholder=\"Сумма\"]");
    public static final By payArrearsEmailInput = By.xpath("//form[@id=\"pay-arrears\"]//input[@placeholder=\"E-mail для отправки чека\"]");

    public MTSPaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cookieBanner));
            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Баннер не обнаружен");
        }
    }

    public String getBlockTitleText() {
        return driver.findElement(blockTitle).getText();
    }

    public void clickMoreInfoServiceLink() {
        driver.findElement(moreInfoServiceLink).click();
    }

    public void choicePayment(By locator) {
        driver.findElement(payType).click();
        driver.findElement(locator).click();
    }

    public void fillPaymentForm(String phoneNumber, String amount) {
        driver.findElement(payConnectionPhoneNumberInput).sendKeys(phoneNumber);
        driver.findElement(payConnectionSummaInput).sendKeys(amount);
    }

    public void clickContinueButton(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isPaymentLogoPresent(int index) {
        List<WebElement> logos = driver.findElements(paymentLogos);
        return logos.size() > index;
    }

    public String getPlaceholderText(By locator) {
        try {
            return driver.findElement(locator).getAttribute("placeholder");
        } catch (Exception e) {
            System.out.println("Элемент на найден");
            return null;
        }
    }
}

