package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitySearchResultPage {

    @FindBy(xpath = "//div[@class='place-list place-list_ancient-design_yes']/li[@class='place-list__item']")
    private WebElement firstFoundCityLabel;

    private final WebDriver driver;

    public CitySearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getFirstFoundCityText() {
        return firstFoundCityLabel.getText();
    }
}
