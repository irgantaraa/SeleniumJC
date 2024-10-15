package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {
    public static void main(String[] args) {
        Utils utils = new Utils();

        // Menetapkan properti untuk geckodriver (FirefoxDriver)
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi FirefoxDriver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Membuka URL
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser

        // Mendapatkan judul halaman
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // Mendapatkan URL saat ini
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Mengonversi WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Klik tombol yang membuka tab baru
        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);
        utils.delay(3);

        driver.switchTo().window(tabs.get(0));
        String txtTittlePage = driver.findElement(By.cssSelector("#browserWindows > h1")).getText();
        System.out.println(txtTittlePage);
        utils.delay(3);


        // navigation
        js.executeScript("window.scrollBy(0,500);");
        driver.get("https://demoqa.com/modal-dialogs");
        System.out.println("current URL: " + driver.getCurrentUrl());
        driver.findElement(By.id("showSmallModal")).click();
        utils.delay(3);
        driver.findElement(By.id("closeSmallModal")).click();
        utils.delay(3);

        driver.navigate().back();
        System.out.println("current URL: " + driver.getCurrentUrl());
        driver.navigate().refresh();

        // Menutup browser
        driver.quit();
    }
}
