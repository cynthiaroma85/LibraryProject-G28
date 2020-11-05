package com.libraryct.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    public static void wait(int seconds){

        try{
            Thread.sleep(1000*seconds);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for (WebElement element: elements){
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    /**
     * wait for page load after click action
     */
    public static void waitForLoad(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        By mask =By.xpath("//img[@class='loading']");
        wait.until(ExpectedConditions.presenceOfElementLocated(mask));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(mask));
    }

    public static void waitStalenessOfElement(By by){
        int count=0;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        while(count++<10){
            try {

                break;
            }catch (WebDriverException e){
                wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        }
    }

    /**
     * clicks on an element using JavaScript
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",element);

    }

    /**
     * scroll to element using JavaScript
     * @param element
     */
    public static void scrollTo(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void scrollBy(){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("scroll(0,100)");
    }

    /**
     *
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenShot(String name){
        name = new Date().toString().replace(" ","_").replace(":","-")+"_"+name;
        String path = System.getProperty("user.dir")+"/test-ouput/screenshots/"+name+".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }
}
