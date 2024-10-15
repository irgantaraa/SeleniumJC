package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrame {
    public static void main(String[] args) {
        Utils utils = new Utils();

        // Menetapkan properti untuk ChromeDriver
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi ChromeDriver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        String txtHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtHeading);

        driver.switchTo().defaultContent();

        // web scrapping
        String txtTitlePage = driver.findElement(By.cssSelector(".text-center")).getText();
        System.out.println(txtTitlePage);


        // Mendapatkan judul halaman
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // Mendapatkan URL saat ini
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Mengonversi WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.quit();
    }

}
