package com.libraryct.step_definitions;

import com.libraryct.pages.BookPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStepDefinitions {

    BookPage bookPage = new BookPage();

    @When("user clicks on books tab")
    public void userClicksOnBooksTab() {
        bookPage.clickBooksBtn();
    }

    @And("user enters book {string}")
    public void userEntersABook(String name) {
        bookPage.searchBook(name);
    }

    @Then("user verifies search result by name {string}")
    public void userVerifiesSearchResultByName(String name){
        bookPage.verifyResult(name);
    }
}
