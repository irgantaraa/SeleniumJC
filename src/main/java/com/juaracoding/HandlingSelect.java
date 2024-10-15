package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingSelect {
    public static void main(String[] args) {
        Utils utils = new Utils();

        // Menetapkan properti untuk geckodriver (FirefoxDriver)
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");

        // Inisialisasi FirefoxDriver
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Membuka URL
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser


        // Mendapatkan judul halaman
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // Mendapatkan URL saat ini
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Mengonversi WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");

        WebElement dropdown = driver.findElement(By.xpath("//*[@id='withOptGroup']"));
        dropdown.click(); // Klik untuk membuka dropdown
        WebElement option = driver.findElement(By.xpath("//div[text()='Group 1, option 1']"));
        option.click(); // Pilih opsi
        utils.delay(3);

        WebElement selectOne = driver.findElement(By.xpath("//*[@id='selectOne']"));
        selectOne.click();
        WebElement list = driver.findElement(By.xpath("//div[contains(text(), 'Mr.')]"));
        list.click();
        utils.delay(3);


        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColor);

        select.selectByIndex(7);
        utils.delay(3);

        select.selectByValue("red");
        utils.delay(3);

        select.selectByVisibleText("Indigo");
        utils.delay(3);

        driver.quit();
    }
}

