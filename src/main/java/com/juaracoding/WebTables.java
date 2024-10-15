package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebTables {
    public static void main(String[] args) {
        Utils utils = new Utils();

        // Menetapkan properti untuk ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");

        // Inisialisasi ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();  // Memaksimalkan jendela browser

        // Web scraping untuk mengambil teks judul halaman
        String txtTitlePage = driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > h1")).getText();
        System.out.println(txtTitlePage);

        // Mendapatkan judul halaman
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // Mendapatkan URL saat ini
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Mengonversi WebDriver ke JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Klik tombol 'Add' untuk menambahkan record baru
        driver.findElement(By.id("addNewRecordButton")).click();

        // Mengisi form dengan data baru
        driver.findElement(By.id("firstName")).sendKeys("Irgantara");
        driver.findElement(By.id("lastName")).sendKeys("Pratama");
        driver.findElement(By.id("userEmail")).sendKeys("irgantara@gmail.com");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.id("salary")).sendKeys("2000000");
        driver.findElement(By.id("department")).sendKeys("IT");

        // Delay sebelum mengirim form
        utils.delay(2);

        // Klik tombol submit
        driver.findElement(By.id("submit")).click();

        // Delay setelah submit
        utils.delay(2);

        // Mencari record baru dengan nama "Irgantara"
        driver.findElement(By.id("searchBox")).sendKeys("Irgantara");

        // Delay setelah memasukkan teks pencarian
        utils.delay(2);

        // Klik tombol 'Edit' pada record yang ditemukan
        driver.findElement(By.id("edit-record-4")).click();

        // Menghapus isi text field dan memperbarui data
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Budi");

        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Dodo");

        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("Budidodo@gmail.com");

        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("30");

        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("salary")).sendKeys("3000000");

        driver.findElement(By.id("department")).clear();
        driver.findElement(By.id("department")).sendKeys("IT");

        // Delay setelah memperbarui form
        utils.delay(2);

        // Mengirim form yang diperbarui
        driver.findElement(By.id("submit")).click();

        // Delay setelah mengirim pembaruan
        utils.delay(2);

        // Menghapus pencarian dan mencari record dengan nama "Budi"
        driver.findElement(By.id("searchBox")).clear();
        driver.findElement(By.id("searchBox")).sendKeys("Budi");

        // Delay setelah pencarian record yang diperbarui
        utils.delay(4);

        // Menghapus record tersebut
        driver.findElement(By.id("delete-record-4")).click();

        // Delay setelah menghapus record
        utils.delay(3);

        // Menutup browser
        driver.quit();
    }
}
