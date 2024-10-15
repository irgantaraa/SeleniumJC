Web Table Automation using Selenium
This repository demonstrates how to use Selenium to automate interaction with the web table component available at demoqa.com/webtables. The objective is to perform operations like adding, editing, deleting, and searching records from the web table.

Features
Add New Record: Automates the process of adding a new entry into the web table.
Edit Record: Script to locate and update an existing record based on user-defined conditions.
Delete Record: Automates record deletion functionality.
Search Record: Implements searching capabilities to locate specific records based on criteria.
Validate Table Data: Verifies if the correct data is present or updated in the web table.
Tools and Technologies
Selenium WebDriver: Automates browser interaction.
Java: Programming language used for automation scripts.
Firefox (GeckoDriver) or Chrome (ChromeDriver): WebDrivers for running tests on Firefox or Chrome.
JUnit/TestNG: Testing frameworks for running and verifying the tests (optional).
Getting Started
Prerequisites
Java installed on your machine. You can download it from here.
Selenium WebDriver installed. Follow instructions from the official website.
GeckoDriver (for Firefox) or ChromeDriver (for Chrome) installed:
Download GeckoDriver from here.
Download ChromeDriver from here.
Add GeckoDriver or ChromeDriver to your system’s PATH.
Installation
Clone the repository:

```bash
git clone https://github.com/<your-username>/web-table-automation.git
cd web-table-automation
```
Add Selenium libraries to your project:

Download the Selenium Java bindings from here.
Include the .jar files in your project's build path.
Set up the appropriate WebDriver:

Download and extract GeckoDriver or ChromeDriver.
Place it in a directory that is in your system’s PATH.
Running the Automation Scripts
You can run the test scripts by following these steps:

Add Record:

To add a record into the table, the automation script interacts with the Add button, fills in the form fields (first name, last name, age, salary, department), and submits the form.

Edit Record:

To edit an existing record, the script locates a record by a specific field (like name or email), clicks on the Edit button, modifies the data, and saves the changes.

Delete Record:

The script finds the desired record based on certain criteria and clicks the Delete button to remove it from the table.

Search Record:

The search feature is automated by inputting search queries in the search box and verifying the filtered results.

java
```bash
// Example code to add a new record in the web table
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;  // or ChromeDriver


public class WebTableAutomation {
    public static void main(String[] args) {
        // For Firefox
        System.setProperty("webdriver.gecko.driver", "path_to_geckodriver");
        WebDriver driver = new FirefoxDriver();
        
        // For Chrome
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        // WebDriver driver = new ChromeDriver();
        
        driver.get("https://demoqa.com/webtables");

        // Click Add button
        driver.findElement(By.id("addNewRecordButton")).click();

        // Fill form
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("johndoe@example.com");
        driver.findElement(By.id("age")).sendKeys("30");
        driver.findElement(By.id("salary")).sendKeys("5000");
        driver.findElement(By.id("department")).sendKeys("Engineering");

        // Submit the form
        driver.findElement(By.id("submit")).click();
    }
}
``` 
Using ChromeDriver
To use ChromeDriver instead of GeckoDriver, follow these steps:

Download ChromeDriver from the official site.

Set up ChromeDriver by adding its path to your system environment variables or by specifying its location in the code:

java
```bash
System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
WebDriver driver = new ChromeDriver();
Comment out or remove the GeckoDriver setup and use the ChromeDriver lines to execute the automation scripts in Google Chrome.

Running Tests
You can integrate JUnit or TestNG to automate and verify the test cases. To run the tests:

If using JUnit:
```bash
mvn test
```
License
This project is licensed under the MIT License.
