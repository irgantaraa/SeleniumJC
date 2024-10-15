package com.juaracoding;

import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class FirstSelenium {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //driver.findElement(By.name("q")).sendKeys("Selenium");
        //driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // LinkText
        driver.findElement(By.linkText("Gmail")).click();

        //String title = driver.getTitle();
        //System.out.println("Judul Halaman: " + title);

        // beri delay 2 detik
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit(); // Tutup browser
    }
}