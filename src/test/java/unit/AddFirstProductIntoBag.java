package unit;

import static org.example.configurations.Properties.CHROME_WEB_DRIVER_KEY;
import static org.example.configurations.Properties.CHROME_WEB_DRIVER_VALUE;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.example.configurations.Driver.configureWebDriver;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertAddFirstProductIntoBag;
import org.example.steps.selenium_steps.SeleniumMethods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddFirstProductIntoBag {

    private final SeleniumMethods seleniumMethods = new SeleniumMethods();
    private final AssertAddFirstProductIntoBag assertAddFirstProductIntoBag = new AssertAddFirstProductIntoBag();

    @Test
    @DisplayName("Adding the first product into the bag")
    @Description("Should save the first product into the bag")
    public void addingFirstProductIntoBag() throws InterruptedException {
        WebDriver driver = configureWebDriver(CHROME_WEB_DRIVER_KEY, CHROME_WEB_DRIVER_VALUE,
            WB_MAIN_PAGE_URL);

        WebElement searchInput = seleniumMethods.searchElementById(driver, "searchInput");
        seleniumMethods.clickElement(searchInput);

        seleniumMethods.searchProductByName(searchInput, "мобильный телефон");

        WebElement searchButton = seleniumMethods.searchElementById(driver, "applySearchBtn");
        seleniumMethods.clickElement(searchButton);

        WebElement firstProduct = seleniumMethods.searchElementByXpath(driver,
            "//div[@class='product-card__wrapper'][1]");
        seleniumMethods.clickElement(firstProduct);

        WebElement productName = seleniumMethods.searchElementByXpath(driver,
            "//h1[contains(@data-link, 'selectedNomenclature')]");
        String expectedProductName = productName.getText();

        WebElement addToBagButton = seleniumMethods.searchElementByXpath(driver,
            "/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[11]/div/div[1]/div[3]/div/button[2]/span[1]");
        seleniumMethods.clickElement(addToBagButton);

        WebElement bagButton = seleniumMethods.searchElementByXpath(driver,
            "//*[@id=\"basketContent\"]/div[3]/a");
        seleniumMethods.clickElement(bagButton);

        WebElement productInBag = seleniumMethods.searchElementByXpath(driver,
            "//span[@class='good-info__good-name']");
        String actualProductName = productInBag.getText();

        assertAddFirstProductIntoBag.assertionFirstProductInt(expectedProductName,
            actualProductName);

        driver.quit();
    }
}
