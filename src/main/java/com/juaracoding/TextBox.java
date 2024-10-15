package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBox {
    public static void main(String[] args) {
        // Menetapkan properti untuk GeckoDriver (Firefox)
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Casting WebDriver ke JavascriptExecutor untuk bisa menjalankan JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Buka halaman web
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser

        // Locator
        driver.findElement(By.id("userName")).sendKeys("Irga");
        driver.findElement(By.id("userEmail")).sendKeys("irga@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");

        js.executeScript("window.scrollBy(0,800)");

        // Klik tombol submit menggunakan JavaScript
        js.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));

        String nameText = driver.findElement(By.xpath("//p[@id='name']")).getText();
        String emailText = driver.findElement(By.xpath("//p[@id='email']")).getText();
        String currentAddressText = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String permanentAddressText = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();

        // Menampilkan nilai yang diambil dari hasil
        System.out.println(nameText);  // Output: Nama: Irga
        System.out.println(emailText);  // Output: Email: irga@gmail.com
        System.out.println(currentAddressText);  // Output: Alamat Saat Ini
        System.out.println(permanentAddressText);  // Output: Alamat Permanen

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Menutup browser
        driver.quit();
    }
}
