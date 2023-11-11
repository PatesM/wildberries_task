package org.example.steps.selenium_steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumMethods {

    public WebElement searchElementById(WebDriver driver, String elementId) {
        return driver.findElement(By.id(elementId));
    }

    public WebElement searchElementByXpath(WebDriver driver, String elementId) {
        return driver.findElement(By.xpath(elementId));
    }

    public void searchProductByName(WebElement webElement, String productName) {
        webElement.sendKeys(productName);
    }

    public void clickElement(WebElement webElement) throws InterruptedException {
        webElement.click();
        Thread.sleep(10000);
    }
}
