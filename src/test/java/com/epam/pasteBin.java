package com.epam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class pasteBin {
    @Test
    public void pasteBin() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://pastebin.com");

        WebElement newPaste = driver.findElement(By.id("postform-text"));
        newPaste.sendKeys("Hello from WebDriver");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,350)", "");

        WebElement pasteExpiration = driver.findElement(By.id("select2-postform-expiration-container"));
        pasteExpiration.click();

        driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[3]")).click();


        javascriptExecutor.executeScript("window.scrollBy(0,350)", "");

        WebElement pasteName = driver.findElement(By.id("postform-name"));
        pasteName.sendKeys("hello web");

    }

}

