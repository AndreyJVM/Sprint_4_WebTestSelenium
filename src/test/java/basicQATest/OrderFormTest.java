package basicQATest;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumWebYandexScooterTest.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static seleniumWebYandexScooterTest.BasicPageTest.PAGE_URL;

@RunWith(Parameterized.class)
public class OrderFormTest {

    private WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String errorText;

    public OrderFormTest
            (String name, String lastName, String address, String metro, String phoneNumber, String errorText) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.errorText = errorText;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderDetails() {
        return new Object[][] {
                {" ", "Пупкин", "ул. Ватутина, 25", "Черкизовская", "+79111111111", "Введите корректное имя"},
                {"Ян", " ", "Победы, 7", "Первомайская", "88004005050", "Введите корректную фамилию"},
                {"Александра", "Суворова", "вапывапывапывапывапывапывапывапывапывапывапыавпыавпывапывап", "Красные Ворота", "+79215556363", "Введите корректный адрес"},
                {"Алекс", "Мело", "пр. Победы, 25", "Лубянка", "  ", "Введите корректный номер"},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkEmptyField_ShowsError() {
        BasicPageTest objBasicPage = new BasicPageTest(driver);
        objBasicPage.waitForLoadServiceLogo();
        objBasicPage.clickCookieButton();

        OrderPageTest objOrderPage = new OrderPageTest(driver);
        objOrderPage.clickOrderButtonTop();
        objOrderPage.waitForLoadOrderHeader();
        objOrderPage.fillOutPersonalData(name, lastName, address, metro, phoneNumber);
        objOrderPage.isErrorTextDisplayed(errorText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

