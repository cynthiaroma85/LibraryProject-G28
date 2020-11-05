package com.libraryct.pages;

import com.libraryct.util.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * all webelements on book page go here
 * all methods that interact with the page goes here
 * method examples: clickEditButton() gettext() enterinfo()...
 */
public class BookPage extends BasePage {

    private String search = "//input[@type='search']";

    private String result = "//tbody//td[3]";

    private String loader = "//div[@class='modal-body']";

    public void searchBook(String name){
        driver.findElement(By.xpath(search)).sendKeys(name);
    }

    public void verifyResult(String name){
        BrowserUtils.wait(1);

        List<WebElement> bookLst = driver.findElements(By.xpath(result));
        System.out.println(bookLst.size());
        for (WebElement each: bookLst){
            Assert.assertTrue(each.getText().equalsIgnoreCase(name));
        }
    }
}
