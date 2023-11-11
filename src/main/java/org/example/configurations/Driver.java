package org.example.configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static final WebDriver driver = new ChromeDriver();

    public static WebDriver configureWebDriver(String webDriverKey, String webDriverValue,
        String url) {
        System.setProperty(webDriverKey, webDriverValue);

        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }
}
