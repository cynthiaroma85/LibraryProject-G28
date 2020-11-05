package com.libraryct.pages;

import com.libraryct.util.ConfigurationReader;
import com.libraryct.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage {


    private String email = "//input[@id='inputEmail']";
    private String passWord = "//input[@id='inputPassword']";


    public void openURL(){
        String URL = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(URL);
    }

    public void login(String role) {
        driver.findElement(By.xpath(email)).
                sendKeys(ConfigurationReader.getProperty("librarian"));
        driver.findElement(By.xpath(passWord)).
                sendKeys(ConfigurationReader.getProperty("librarian_password"), Keys.ENTER);
    }

}
