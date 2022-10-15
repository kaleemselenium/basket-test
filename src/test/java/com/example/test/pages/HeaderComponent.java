package com.example.test.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Header Component
 */
@Component
public class HeaderComponent {

    //Page locators
    By BASKET_ICON = By.id("minibasket-icon-anchor");

    /**
     * Method to navigate to Basket Page
     */
    public void goToBasket(){
        $(BASKET_ICON).shouldBe(visible).click();
    }
}
