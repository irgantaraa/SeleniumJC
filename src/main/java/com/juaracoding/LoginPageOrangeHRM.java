package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageOrangeHRM {
    public static void main(String[] args) {
        Utils utils = new Utils();

        System.setProperty("webdriver.gecko.driver","C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //negative
        loginUser(driver, "invalid", "invalid");

        //positive
        loginUser(driver, "Admin", "admin123");
        String txtDashboard = driver.findElement(By.xpath("//h6[contains(@class,'topbar-header-breadcrumb')]")).getText();
        System.out.println(txtDashboard);

        // customAssertEquals(txtDashboard, "Dashboard") = jika true Passed, false Failed
        customAssertEquals(txtDashboard, "Dashboard");


        // delay 5 detik
        utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");

    }

    public static void customAssertEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

    public static void loginUser(WebDriver driver, String username, String password){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        btnLogin.click();
    }

}

