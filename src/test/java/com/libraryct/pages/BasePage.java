package com.libraryct.pages;

import com.libraryct.util.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * all webelements on header/menu go here
 * all methods that interact with the page goes here
 * method examples: clickUser(), clickBooks(),clickDashboard()...
 */
public abstract class BasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,5);

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private String bookTab = "//span[.='Books']";

    /**
     * methods to click user button, books button
     */
    public void clickBooksBtn(){
        driver.findElement(By.xpath(bookTab)).click();
    }
}
