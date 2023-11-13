package org.example.flows;

public class AddFirstProductIntoBagFlow {

    public static String searchInputId = "searchInput";
    public static String searchButtonId = "applySearchBtn";
    public static String firstProductXpath = "//div[@class='product-card__wrapper'][1]";
    public static String productNameXpath = "//h1[contains(@data-link, 'selectedNomenclature')]";
    public static String addToBagButtonXpath = "//div[@class='product-page__order-buttons']/div/button[2]";
    public static String bagButtonXpath = "//a[@class='navbar-pc__link j-wba-header-item']/span[contains(@class, 'basket')]";
    public static String productInBagXpath = "//span[@class='good-info__good-name']";
}
