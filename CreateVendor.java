package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateVendor {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://change-this-to-the-site-you-are-testing/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateVendor() throws Exception {
    driver.findElement(By.xpath("//li[4]/a/span")).click();
    driver.findElement(By.id("admin_new_vendor_link")).click();
    driver.findElement(By.id("vendor_name")).click();
    driver.findElement(By.id("vendor_name")).clear();
    driver.findElement(By.id("vendor_name")).sendKeys("Vendorname");
    driver.findElement(By.id("vendor_address")).click();
    driver.findElement(By.id("vendor_address")).clear();
    driver.findElement(By.id("vendor_address")).sendKeys("Addresstest");
    driver.findElement(By.id("vendor_email")).click();
    driver.findElement(By.id("vendor_email")).clear();
    driver.findElement(By.id("vendor_email")).sendKeys("testemail@eg.com");
    driver.findElement(By.id("vendor_phone_number")).click();
    driver.findElement(By.id("vendor_phone_number")).clear();
    driver.findElement(By.id("vendor_phone_number")).sendKeys("9876905678");
    driver.findElement(By.name("button")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
