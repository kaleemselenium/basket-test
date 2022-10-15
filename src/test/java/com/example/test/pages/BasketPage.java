package com.example.test.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Basket Page Object
 */
@Component
public class BasketPage {

    //Page locators
    By ITEMS_COUNT = By.cssSelector("[data-test='heading-title-count']");
    By PRODUCT_NAME = By.cssSelector("[data-test='item-description-indicator-title-without-brand']");

    /**
     * Method to the product name from the basket
     * @return - Product name
     */
    public String getProductNameFromBasket(){
        $(ITEMS_COUNT).shouldHave(text("1 Item"));
        return $(PRODUCT_NAME).should(visible).text();
    }
}
