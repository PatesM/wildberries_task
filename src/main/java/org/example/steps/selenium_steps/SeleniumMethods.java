package org.example.steps.selenium_steps;

import static org.example.configurations.Driver.configureWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumMethods {

    WebDriver driver;

    public SeleniumMethods(String CHROME_WEB_DRIVER_KEY, String CHROME_WEB_DRIVER_VALUE,
        String WB_MAIN_PAGE_URL) {
        driver = configureWebDriver(CHROME_WEB_DRIVER_KEY, CHROME_WEB_DRIVER_VALUE,
            WB_MAIN_PAGE_URL);
    }

    public WebElement searchElementById(String elementId) {
        return driver.findElement(By.id(elementId));
    }

    public WebElement searchElementByXpath(String elementId) {
        return driver.findElement(By.xpath(elementId));
    }

    public void searchProductByName(WebElement webElement, String productName) {
        webElement.sendKeys(productName);
    }

    public void clickElement(WebElement webElement) throws InterruptedException {
        webElement.click();
        Thread.sleep(10000);
    }

    public void quitDriver() {
        driver.quit();
    }
}
