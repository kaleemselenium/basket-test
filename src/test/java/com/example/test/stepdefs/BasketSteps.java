package com.example.test.stepdefs;

import com.example.test.pages.*;
import com.example.test.utility.Data;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

/**
 * Step definitions class
 */
public class BasketSteps {

    @Autowired
    HomePage homePage;

    @Autowired
    SearchResultsPage searchResultsPage;

    @Autowired
    HeaderComponent headerComponent;

    @Autowired
    BasketPage basketPage;

    @Autowired
    Data data;

    @Given("user on home page")
    public void onPage() {
        homePage.navigateToHomePage();
    }

    @When("user searches for the product {string}")
    public void searchFor(String product) {
        homePage.searchProduct(product);
        searchResultsPage.selectRandomProduct();

    }

    @And("adds random product from the result")
    public void addRandomProduct() {
        searchResultsPage.addToBasket();
    }

    @And("user navigates to the basket page")
    public void goToBasket() {
        headerComponent.goToBasket();
    }

    @Then("user sees the correct product in the basket page")
    public void verifyTheProduct() {
        String productName = basketPage.getProductNameFromBasket().toLowerCase();
        Assert.assertTrue(productName.contains(data.getProductName().toLowerCase()));
    }
}
