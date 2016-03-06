package Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test5 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/app";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

 
//  Delete CSR
  @Test
  public void Test5() throws Exception {
	    driver.get(baseUrl + "/#/host/magehostmanager.magemojo.com/configuration/ssl");
	    driver.findElement(By.xpath("//a[contains(text(),'www.Testing5.com')]")).click();
	    assertEquals("Download CSR www.Testing5.com", driver.findElement(By.xpath("//legend[4]")).getText());
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
	    assertEquals("Confirmation Window", driver.findElement(By.cssSelector("h3.modal-title.ng-binding")).getText());
	    assertTrue(isElementPresent(By.xpath("//div[3]/button[2]")));
	    driver.findElement(By.xpath("//div[3]/button")).click();
	    
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Successfully deleted the CSR.".equals(driver.findElement(By.xpath("//div[@id='toast-container']/div")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	 
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if (!isElementPresent(By.xpath("//a[contains(text(),'www.Testing5.com')]"))) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
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