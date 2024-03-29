package basicQATest;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumWebYandexScooterTest.BasicPageTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static seleniumWebYandexScooterTest.BasicPageTest.PAGE_URL;

@RunWith(Parameterized.class)
public class OrderNumberTest {

    private WebDriver driver;
    private final String orderNumber;

    public OrderNumberTest(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderNumber() {
        return new Object[][] {
                {"000000"},
                {"555-555"},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkNonexistentNumber_showsError() {
        BasicPageTest objBasicPage = new BasicPageTest(driver);
        objBasicPage.waitForLoadServiceLogo();
        objBasicPage.clickOrderStatusButton();
        objBasicPage.waitForLoadOrderNumberInput();
        objBasicPage.enterOrderNumber(orderNumber);
        objBasicPage.clickGoButton();
        Assert.assertTrue(objBasicPage.isImageNotFoundDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

