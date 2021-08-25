package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Author Subhradip sinha
 * @start Date: 07-01-2020
 *
 */
public class DriverManager extends ConfigarationManager {
    //public static ConfigarationManager configarationManager = new ConfigarationManager();
    public static WebDriver driver;


    public static void browser() throws Exception {

        ConfigarationManager.conficfile();
        String Url = ConfigarationManager.config.getProperty("URLUser");
        String browsername = ConfigarationManager.config.getProperty("browser");
        if (browsername.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qapitol QA\\Desktop\\excel\\excel-automation\\driver\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        driver.get(Url);
        System.out.println("URL HIT");

        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_username']")));
        System.out.println("URL Open");

    }
}