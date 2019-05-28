import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CitySearchResultPage;
import pages.StartPage;
import pages.WeatherPage;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setDriver()  {
        driver = new ChromeDriver();
    }


    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }

    @Test
    public void cityCheck() {
        driver.findElement(By.xpath("//a[text()='Погода']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Город или район']")).sendKeys("Нью-Йорк");
        driver.findElement(By.xpath("//input[@placeholder='Город или район']")).sendKeys(Keys.ENTER);
        String actualString = driver.findElement(By.xpath("//div[@class='place-list place-list_ancient-design_yes']/li[@class='place-list__item']")).getText();
        Assert.assertTrue("Какая-то беда, бро", actualString.contains("Нью-Йорк, Штат Нью-Йорк, США"));

    }

    @Test
    public void newCityCheck() {
        StartPage startPage = new StartPage(driver);
        WeatherPage weatherPage = startPage.clickOnWeatherButton();
        weatherPage.typeCityIntoSearchField("Нью-Йорк");
        CitySearchResultPage citySearchResultPage = weatherPage.search();
        String actualText = citySearchResultPage.getFirstFoundCityText();
        Assert.assertTrue("Какая-то беда, brother", actualText.contains("Нью-Йорк, Штат Нью-Йорк, США"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}