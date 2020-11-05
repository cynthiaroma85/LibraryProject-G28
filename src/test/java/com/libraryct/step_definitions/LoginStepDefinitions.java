package com.libraryct.step_definitions;

import com.libraryct.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginStepDefinitions {

    LoginPage login = new LoginPage();

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        login.openURL();
    }

    @And("user logs in as {string}")
    public void userLogsInAs(String role) {
        login.login(role);
    }
}
