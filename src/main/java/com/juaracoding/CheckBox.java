package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
    public static void main(String[] args) {
        // Menetapkan properti untuk GeckoDriver (Firefox)
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Buka halaman web
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser

        // Casting WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // locator cssSelector
        // checklist
        driver.findElement(By.cssSelector("#tree-node> ol > li > span > label")).click();
        // unchecklist
        driver.findElement(By.cssSelector("#tree-node> ol > li > span > label")).click();
        // checklist: Documents, Downloads
        driver.findElement(By.cssSelector("#tree-node> ol > li >span> button")).click();
        driver.findElement(By.cssSelector("#tree-node> ol > li > ol> li:nth-child(2) > span > label")).click();
        driver.findElement(By.cssSelector("#tree-node> ol> li > ol > li:nth-child(3) > span > label")).click();

        // Tambahan: Menunggu beberapa detik sebelum browser ditutup (opsional)
        try {
            Thread.sleep(5000);  // Beri waktu 3 detik untuk melihat hasilnya sebelum menutup
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Menutup browser
        driver.quit();
    }
}
