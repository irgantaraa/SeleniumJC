package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingAlert {
    public static void main(String[] args) {
        Utils utils = new Utils();

        // Menetapkan properti untuk ChromeDriver
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi ChromeDriver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser

        // Web scraping untuk mengambil teks judul halaman
        //String txtTitlePage = driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > h1")).getText();
        //System.out.println(txtTitlePage);

        // Mendapatkan judul halaman
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // Mendapatkan URL saat ini
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Mengonversi WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("alertButton")).click();
        utils.delay(3);
        driver.switchTo().alert().accept();
        System.out.println("Alert Button");

        utils.delay(3);

        driver.findElement(By.id("timerAlertButton")).click();
        utils.delay(6);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmButton")).click();
        utils.delay(2);
        driver.switchTo().alert().accept();  // Accept the confirm alert

        driver.findElement(By.id("promtButton")).click();
        utils.delay(2);
        driver.switchTo().alert().sendKeys("irga");
        driver.switchTo().alert().accept();




        utils.delay(3);
        driver.quit();
    }
}
