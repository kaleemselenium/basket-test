package com.example.test.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * E-Commerce Home Page Object
 */
@Component
public class HomePage {

    //Page locators
    By ACCEPT_COOKIES = By.cssSelector("[data-test='allow-all']");
    By SEARCH_BOX = By.id("mobileSearch");

    /**
     * Navigate to e-commerce site and accept cookies if displayed
     */
    public void navigateToHomePage(){
        if ($(ACCEPT_COOKIES).isDisplayed()) {
            $(ACCEPT_COOKIES).shouldBe(visible).click();
            $(ACCEPT_COOKIES).shouldBe(disappear);
        }
    }

    /**
     * Search for the product
     * @param product - Product to search
     */
    public void searchProduct(String product){
        $(SEARCH_BOX).click();
        $(SEARCH_BOX).val(product).pressEnter();
    }

}

