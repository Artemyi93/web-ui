package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    @FindBy(xpath = "//a[text()='Погода']")
    private WebElement weatherButton;

    private final WebDriver driver;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WeatherPage clickOnWeatherButton() {
        weatherButton.click();
        return new WeatherPage(driver);
    }
}
