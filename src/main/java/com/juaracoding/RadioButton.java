package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class RadioButton {
    public static void main(String[] args) {
        // Menetapkan properti untuk GeckoDriver (Firefox)
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Buka halaman web
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser
        // Casting WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > div:nth-child(3) > div:nth-child(2) > label")).click(); // Mencari radio button Yes
        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > div:nth-child(3) > div:nth-child(3) > label")).click(); // klick impressive


        // Menutup browser
        driver.quit();
    }
}
