package com.example.test.pages;

import com.codeborne.selenide.SelenideElement;
import com.example.test.utility.Data;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Search Results Page Object
 */
@Component
public class SearchResultsPage {

    //Page locators
    By PRODUCT_CONTAINER = By.cssSelector("[data-test='product-card']");
    By PRODUCTS_TITLE = By.cssSelector("[class^='title_title__desc__']");
    By ADD_TO_BASKET = By.cssSelector("[aria-label='Add to your basket']");
    By ADD_TO_YOUR_BASKET = By.id("addToBasket");
    By ADD_TO_BASKET_SUCCESS = By.cssSelector("[class^='add-to-basket-success_container']");
    By POPUP_CLOSE = By.cssSelector("[data-test='modal-button-close']");

    @Autowired
    Data data;

    /**
     * Method to find random product
     */
    public void selectRandomProduct() {
        $(PRODUCT_CONTAINER).shouldBe(visible);
        SelenideElement product = $$(PRODUCT_CONTAINER)
                .stream()
                .filter(ele -> ele.find(ADD_TO_BASKET).isDisplayed())
                .findAny()
                .get();
        String productName = product.find(PRODUCTS_TITLE).text();
        data.setProductName(productName);
        product.find(ADD_TO_BASKET).shouldBe(visible).click();
    }

    /**
     * Add the product to basket
     */
    public void addToBasket(){
        $(ADD_TO_YOUR_BASKET).shouldBe(visible).click();
        $(ADD_TO_BASKET_SUCCESS).shouldBe(visible);
        $(POPUP_CLOSE).shouldBe(visible).click();
        $(POPUP_CLOSE).shouldBe(disappear);
    }


}
