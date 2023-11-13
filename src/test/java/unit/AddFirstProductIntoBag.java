package unit;

import static org.example.configurations.Properties.CHROME_WEB_DRIVER_KEY;
import static org.example.configurations.Properties.CHROME_WEB_DRIVER_VALUE;
import static org.example.configurations.Properties.WB_MAIN_PAGE_URL;
import static org.example.flows.AddFirstProductIntoBagFlow.addToBagButtonXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.bagButtonXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.firstProductXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.productInBagXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.productNameXpath;
import static org.example.flows.AddFirstProductIntoBagFlow.searchButtonId;
import static org.example.flows.AddFirstProductIntoBagFlow.searchInputId;

import io.qameta.allure.Description;
import org.example.steps.asserts.AssertAddFirstProductIntoBag;
import org.example.steps.selenium_steps.SeleniumMethods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class AddFirstProductIntoBag {

    private final SeleniumMethods seleniumMethods = new SeleniumMethods(CHROME_WEB_DRIVER_KEY,
        CHROME_WEB_DRIVER_VALUE, WB_MAIN_PAGE_URL);
    private final AssertAddFirstProductIntoBag assertAddFirstProductIntoBag = new AssertAddFirstProductIntoBag();

    @Test
    @DisplayName("Adding the first product into the bag")
    @Description("Should save the first product into the bag")
    public void addingFirstProductIntoBag() throws InterruptedException {

        WebElement searchInput = seleniumMethods.searchElementById(searchInputId);
        seleniumMethods.clickElement(searchInput);

        seleniumMethods.searchProductByName(searchInput, "мобильный телефон");

        WebElement searchButton = seleniumMethods.searchElementById(searchButtonId);
        seleniumMethods.clickElement(searchButton);

        WebElement firstProduct = seleniumMethods.searchElementByXpath(firstProductXpath);
        seleniumMethods.clickElement(firstProduct);

        WebElement productName = seleniumMethods.searchElementByXpath(productNameXpath);
        String expectedProductName = productName.getText();

        WebElement addToBagButton = seleniumMethods.searchElementByXpath(addToBagButtonXpath);
        seleniumMethods.clickElement(addToBagButton);

        WebElement bagButton = seleniumMethods.searchElementByXpath(bagButtonXpath);
        seleniumMethods.clickElement(bagButton);

        WebElement productInBag = seleniumMethods.searchElementByXpath(productInBagXpath);
        String actualProductName = productInBag.getText();

        assertAddFirstProductIntoBag.assertionFirstProductInt(expectedProductName,
            actualProductName);

        seleniumMethods.quitDriver();
    }
}
