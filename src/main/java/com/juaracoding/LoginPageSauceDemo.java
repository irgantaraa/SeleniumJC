package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageSauceDemo {
    public static void main(String[] args) {
        Utils utils = new Utils();

        // Menetapkan properti untuk geckodriver (FirefoxDriver)
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi FirefoxDriver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Membuka URL
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser

        // Mengonversi WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");
        utils.delay(1);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        utils.delay(1);
        WebElement login = driver.findElement(By.xpath("//button[@id='login-button']"));
        login.click();
        utils.delay(1);
    }
}
