package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        // Wait for page to load
        Thread.sleep(5000);

        // Close advertisement popup if it appears
        try {
            driver.findElement(By.cssSelector(".grippy-host")).click();
        } catch (Exception e) {
            System.out.println("Ad popup not found");
        }

        Thread.sleep(3000);

        // Click first product "Add to cart" (Blue Top ₹500)
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();

        Thread.sleep(5000);

        // Close cart popup by clicking Continue Shopping
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

        System.out.println("Blue Top added to cart");

        // Browser stays open (NO driver.quit())

    }
}
