package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class MainClass1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");

        Thread.sleep(3000);

        // Go to products page
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        Thread.sleep(3000);

        // Locate first product Add to Cart
        WebElement addCart = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));

        // Click using JavaScript (bypasses ad overlay)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addCart);

        Thread.sleep(3000);

        // Continue shopping
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
