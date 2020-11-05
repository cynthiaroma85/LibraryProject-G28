package com.libraryct.step_definitions;

import com.libraryct.util.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("::: Starting Automation :::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }
}
