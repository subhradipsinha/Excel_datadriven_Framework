package com.PageObject.CreatCustomer;

import com.demo.Xls_Reader;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDrivenTest {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        Xls_Reader reader = new Xls_Reader("E:\\Bakkappa_folder\\src\\main\\java\\excel\\Data.xlsx");

        String userName = reader.getCellData("Arteria", "userName", 2);
        System.out.println(userName);

        String password = reader.getCellData("Arteria", "password", 2);
        System.out.println(password);

        String cpName = reader.getCellData("Arteria", "cpName", 2);
        System.out.println(cpName);

        String OwnerName = reader.getCellData("Arteria", "OwnerName", 2);
        System.out.println(OwnerName);

        String sapCode = reader.getCellData("Arteria", "sapCode", 2);
        System.out.println(sapCode);

        String Address = reader.getCellData("Arteria", "Address", 2);
        System.out.println(Address);

        String subDistrict = reader.getCellData("Arteria", "subDistrict", 2);
        System.out.println(subDistrict);

        String town = reader.getCellData("Arteria", "town", 2);
        System.out.println(town);

        String phone = reader.getCellData("Arteria", "phone", 2);
        System.out.println(phone);

        String postalCode = reader.getCellData("Arteria", "postalCode", 2);
        System.out.println(postalCode);

        String pan = reader.getCellData("Arteria", "pan", 2);
        System.out.println(pan);

        String gst = reader.getCellData("Arteria", "gst", 2);
        System.out.println(gst);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qapitol QA\\Desktop\\excel\\excel-automation\\driver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://flpnwc-a37nhdlgke.dispatcher.hana.ondemand.com/sites/bilmarketinglaunchpad#Home-show");
        Thread.sleep(10000);


        driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='logOnFormSubmit']")).click();
        Thread.sleep(15000);

        try {
            System.out.println("MasterTabClick");
            // explicit wait - to wait for the compose button to be click-able
            WebDriverWait wait = new WebDriverWait(driver, 3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='__item10']")));
            Thread.sleep(2000);
            WebElement element1 = driver.findElement(By.xpath("//li[@id='__item10']"));
            if (element1.isDisplayed()) {
                element1.click();
                Thread.sleep(5000);
                Actions action = new Actions(driver);
                action.moveToElement(element1);

                WebElement Customer_creat = driver.findElement(By.xpath("//div[contains(text(),'Customer Create')]"));
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
                action.moveToElement(Customer_creat);
                action.click().build().perform();
                driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
                Thread.sleep(10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Customer Create";
        if (actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println(" Title Matched: " + expectedTitle + " == " + actualTitle);
        else
            System.out.println(" Title didn't match: " + expectedTitle + "==" + actualTitle);
        Thread.sleep(15000);
        try {
            WebElement element = driver.findElement(By.xpath
                    ("//label[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fCPTypeEdit-label']"));
            element.click();
            Actions actions = new Actions(driver);
            WebElement element1 = driver.findElement(By.xpath
                    ("//div[@class='sapUiSimpleFixFlexFlexContent']//ul//li[contains(text(),'01  -  Distributor')]"));
            actions.doubleClick(element1).perform();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath
                ("//input[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fNameEdit-inner']"))
                .sendKeys(cpName);
        System.out.println("Enter the CP Name details: "+cpName);
        Thread.sleep(2000);
        driver.findElement(By.xpath
                ("//div[@class='sapMInputBaseContentWrapper']//input[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fOwnerNameEdit-inner']"))
                .sendKeys(OwnerName);
        System.out.println("Enter the Owner Name details: "+OwnerName);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='sapMInputBaseContentWrapper']//input[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fCPUID-inner']"))
                .sendKeys(sapCode);
        System.out.println("Enter the Sap code details: "+sapCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='sapMInputBaseContentWrapper']//input[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fAddress1Edit-inner']"))
                .sendKeys(Address);
        System.out.println("Enter the Address details: "+Address);
        Thread.sleep(2000);
        try{
            driver.findElement(By.xpath("//div[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--DistrictID']")).click();
            Thread.sleep(2000);
            WebElement nameInputField = driver.findElement(By.xpath("//div[@class='sapUiSimpleFixFlexFlexContent']//ul//li[contains(text(),'342 - Kolkata')]"));
            Thread.sleep(2000);
            nameInputField.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(5000);
        }
        try {
            Thread.sleep(5000);
            WebElement District = driver
                    .findElement(By.xpath("//span[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--idSubDistrict-vhi']"));
            District.click();
        }catch (Exception e){
            e.printStackTrace();
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='sapUiRespGridSpanXL8 sapUiRespGridSpanL8 sapUiRespGridSpanM8 sapUiRespGridSpanS12']//input[@id='__input8-inner']"))
                .sendKeys(subDistrict);
        System.out.println("Enter The Sub Distric: "+subDistrict);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='__bar8-btnGo']")).click();
        Thread.sleep(4000);
        WebElement value = driver.findElement(By.xpath("//*[@id='__dialog11-table-rows-row0-col1']"));
        if (value.isDisplayed()){
        value.click(); System.out.println("Value showing: "+value);}else {
            System.out.println("Value Not showing: "+value);
        }
        Thread.sleep(5000);
        try {
            WebElement District = driver
                    .findElement(By.xpath("//span[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fTownIDEdit-vhi']"));
            District.click();
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@class='sapUiRespGridSpanXL8 sapUiRespGridSpanL8 sapUiRespGridSpanM8 sapUiRespGridSpanS12']//*[@id='__input10-inner']"))
                .sendKeys(town);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='__bar9-btnGo-inner']")).click();
        Thread.sleep(3000);
        WebElement value1 = driver.findElement(By.xpath("//*[@id='__dialog13-table-rows-row0-col1']"));
        if (value1.isDisplayed()){
        value1.click();System.out.println("Enter Value1 showing: "+value1);}else {
            System.out.println("Enter Value1 not showing: "+value1);
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fMobile1Edit-inner']"))
                .sendKeys(phone);
        System.out.println("Enter The Phone Number: "+phone);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//input[@id='application-sscpcreate1-Display-component---CPCreate--BasicDataBlock--fPostalCodeEdit-inner']"))
                .sendKeys(postalCode);
        System.out.println("Enter the Postal Code : "+postalCode);
        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='__xmlview2--fInPAN-inner']")).sendKeys(pan);
        System.out.println("Enter The Pan Number : "+pan);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='__xmlview2--fTax1Edit-inner']")).sendKeys(gst);
        System.out.println("Enter The GST number: "+gst);
        Thread.sleep(2000);
    }
    }
