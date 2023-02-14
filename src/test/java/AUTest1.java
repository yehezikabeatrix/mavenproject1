/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author yehezikha.beatrix
 */
public class AUTest1 {
    WebDriver driver = null;
    
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options); 
    }
    @Test
    public void firstTry() {
        driver.get("https://localhost/index.html");
        driver.findElement(By.id("no")).click();
        driver.findElement(By.id("buttoncheck")).click();
        String expectedResult = "Radio button is checked and it's value is No";
        String actualResult = driver.findElement(By.className("radiobutton")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }
    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
