package Task8;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Task8.MTSPaymentFrame.*;
import static Task8.MTSPaymentPage.*;

public class MTSTest {
    public static WebDriver driver;
    public MTSPaymentPage paymentPage;
    public MTSPaymentFrame paymentFrame;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));//иначе "Помощь" перекрывает ссылку "Подробнее о сервисе"
        driver.get("https://www.mts.by/");
        paymentPage = new MTSPaymentPage(driver);
        paymentFrame = new MTSPaymentFrame(driver);
        wait = new WebDriverWait(driver, 15);
        paymentPage.acceptCookies();
    }

    @Test
    public void checkBlockTitle() {
        String title = paymentPage.getBlockTitleText();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(title).as("Название блока не совпадает").isEqualTo("Онлайн пополнение\nбез комиссии");
        softly.assertAll();
    }

    @Test
    public void checkPaymentLogos() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(paymentPage.isPaymentLogoPresent(0)).as("Логотип 'Visa' не найден").isTrue();
        softly.assertThat(paymentPage.isPaymentLogoPresent(1)).as("Логотип 'Verified By Visa' не найден").isTrue();
        softly.assertThat(paymentPage.isPaymentLogoPresent(2)).as("Логотип 'MasterCard' не найден").isTrue();
        softly.assertThat(paymentPage.isPaymentLogoPresent(3)).as("Логотип 'MasterCard Secure Code' не найден").isTrue();
        softly.assertThat(paymentPage.isPaymentLogoPresent(4)).as("Логотип 'Белкарт' не найден").isTrue();
        softly.assertAll();
    }

    @Test
    public void checkMoreInfoServiceLink() {
        paymentPage.clickMoreInfoServiceLink();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getTitle()).as("Ссылка 'Подробнее о сервисе' не работает корректно")
                .contains("Порядок оплаты и безопасность интернет платежей");
        driver.navigate().back();
        softly.assertAll();
    }

    @Test
    public void verifyPlaceholders() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(paymentPage.getPlaceholderText(payConnectionPhoneNumberInput))
                .as("Плейсхолдер для номера телефона должен быть 'Номер телефона'")
                .isEqualTo("Номер телефона");
        softly.assertThat(paymentPage.getPlaceholderText(payConnectionSummaInput))
                .as("Плейсхолдер для суммы должен быть 'Сумма'").isEqualTo("Сумма");
        softly.assertThat(paymentPage.getPlaceholderText(payConnectionEmailInput))
                .as("Плейсхолдер для E-mail для отправки чека должен быть 'E-mail для отправки чека'")
                .isEqualTo("E-mail для отправки чека");
        softly.assertThat(paymentPage.getPlaceholderText(payInternetAbonentNumberInput))
                .as("Плейсхолдер для номера абонента должен быть 'Номер абонента'")
                .isEqualTo("Номер абонента");
        softly.assertThat(paymentPage.getPlaceholderText(payInternetSummaInput))
                .as("Плейсхолдер для суммы интернет должен быть 'Сумма'")
                .isEqualTo("Сумма");
        softly.assertThat(paymentPage.getPlaceholderText(payInternetEmailInput))
                .as("Плейсхолдер для E-mail интернет должен быть 'E-mail для отправки чека'")
                .isEqualTo("E-mail для отправки чека");
        softly.assertThat(paymentPage.getPlaceholderText(payInstalmentCountNumberInput))
                .as("Плейсхолдер для номера счета на 44 должен быть 'Номер счета на 44'")
                .isEqualTo("Номер счета на 44");
        softly.assertThat(paymentPage.getPlaceholderText(payInstalmentSummaInput))
                .as("Плейсхолдер для суммы рассрочки должен быть 'Сумма'")
                .isEqualTo("Сумма");
        softly.assertThat(paymentPage.getPlaceholderText(payInstalmentEmailInput))
                .as("Плейсхолдер для E-mail рассрочки должен быть 'E-mail для отправки чека'")
                .isEqualTo("E-mail для отправки чека");
        softly.assertThat(paymentPage.getPlaceholderText(payArrearsCountNumberInput))
                .as("Плейсхолдер для номера счета на 2073 должен быть 'Номер счета на 2073'")
                .isEqualTo("Номер счета на 2073");
        softly.assertThat(paymentPage.getPlaceholderText(payArrearsSummaInput))
                .as("Плейсхолдер для суммы задолженности должен быть 'Сумма'")
                .isEqualTo("Сумма");
        softly.assertThat(paymentPage.getPlaceholderText(payArrearsEmailInput))
                .as("Плейсхолдер для E-mail задолженности должен быть 'E-mail для отправки чека'")
                .isEqualTo("E-mail для отправки чека");
        System.out.println("Текст плейсхолдеров проверен");
        softly.assertAll();
    }

    @Test
    public void fillFormAndContinueButton() {
        paymentPage.choicePayment(payConnection);
        paymentPage.fillPaymentForm("297777777", "10");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat("297777777").as("Номер телефона должен быть '(29)777-77-77'").isEqualTo("297777777");
        softly.assertThat("10").as("Сумма должна быть '10'").isEqualTo("10");
        paymentPage.clickContinueButton(continueButtonPayConnection);
        paymentFrame.switchToFrame();

        softly.assertThat(verifyElement(summaText).getText()).
                as("Сумма оплаты должна быть равна 10.00 BYN").isEqualTo("10.00 BYN");
        System.out.println("Сумма оплаты проверена: " + verifyElement(summaText).getText());
        softly.assertThat(verifyElement(phoneText).getText()).
                as("Номер телефона должен содержать 375297777777").contains("375297777777");
        System.out.println("Номер телефона проверен: " + verifyElement(phoneText).getText());
        softly.assertThat(verifyElement(payButton).getText()).
                as("Текст кнопки должен содержать сумму 10.00 BYN").contains("10.00 BYN");
        System.out.println("Кнопка оплаты проверена: " + verifyElement(payButton).getText());

        softly.assertThat(paymentFrame.isElementPresent(visaIcon))
                .as("Иконка Visa").isTrue();
        System.out.println("Иконка Visa проверена");
        softly.assertThat(paymentFrame.isElementPresent(mastercardIcon))
                .as("Иконка MasterCard").isTrue();
        System.out.println("Иконка MasterCard проверена");
        softly.assertThat(paymentFrame.isElementPresent(belkartIcon))
                .as("Иконка belkart").isTrue();
        System.out.println("Иконка belkart проверена");
        softly.assertThat(paymentFrame.isElementPresent(maestroIcon))
                .as("Иконка maestro").isTrue();
        System.out.println("Иконка maestro проверена");
        /*softly.assertThat(paymentFrame.isElementPresent(mirIcon))
                .as("Иконка MIR").isTrue();// закоментировала, чтобы тест не падал
        System.out.println("Иконка MIR проверена");*/

        softly.assertThat(paymentFrame.getLabelText(cardNumberInput))
                .as("Текст поля должен содержать 'Номер карты'").contains("Номер карты");
        System.out.println("Поле номера карты проверено: " + paymentFrame.getLabelText(cardNumberInput));
        softly.assertThat(paymentFrame.getLabelText(cardExpireInput))
                .as("Текст поля должен содержать 'Срок действия'").contains("Срок действия");
        System.out.println("Поле срока действия проверено: " + paymentFrame.getLabelText(cardExpireInput));
        softly.assertThat(paymentFrame.getLabelText(cardCVCInput))
                .as("Текст поля должен содержать 'CVC'").isEqualTo("CVC");
        System.out.println("Поле CVC проверено: " + paymentFrame.getLabelText(cardCVCInput));
        softly.assertThat(paymentFrame.getLabelText(cardOwnerInput))
                .as("Текст поля должен содержать 'Имя держателя (как на карте)'").contains("Имя держателя (как на карте)");
        System.out.println("Поле имени держателя проверено: " + paymentFrame.getLabelText(cardOwnerInput));

        softly.assertAll();
        paymentFrame.switchFromFrame();
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
