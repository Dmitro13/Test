package Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test4 {
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

  
// Create SSL
   @Test
  public void Test4() throws Exception {
	    driver.get(baseUrl + "/#/host/magehostmanager.magemojo.com/configuration/ssl");
	    driver.findElement(By.xpath("//a[contains(text(),'www.testing.com')]")).click();
	    driver.findElement(By.id("FindPrivateKey")).click();
	    assertTrue(isElementPresent(By.id("certificate")));
	    assertTrue(isElementPresent(By.id("sshkeypublic")));
	    driver.findElement(By.id("sshkeypublic")).clear();
	    driver.findElement(By.id("sshkeypublic")).sendKeys("Testing");
	    assertTrue(isElementPresent(By.id("Cancel")));
	    assertTrue(isElementPresent(By.id("Delete")));
	    driver.findElement(By.id("Save")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Successfully updated the certificate.".equals(driver.findElement(By.cssSelector("div.ng-scope.ng-binding")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    driver.findElement(By.xpath("//a[contains(text(),'www.testing.com')]")).click();
	    try {
	      assertEquals("Testing", driver.findElement(By.id("sshkeypublic")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    
	    driver.findElement(By.id("InstallSSL")).click();
	    new Select(driver.findElement(By.id("sitenames2"))).selectByVisibleText("www.testing.com");
	    driver.findElement(By.id("Install")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Install SSL www.testing.com".equals(driver.findElement(By.xpath("//form/legend[2]")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    driver.findElement(By.id("CreateCSR")).click();
	    for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Create CSR".equals(driver.findElement(By.xpath("//legend[3]")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    	
	    driver.findElement(By.id("sitenames")).clear();
	    driver.findElement(By.id("sitenames")).sendKeys("w");
	    driver.findElement(By.id("sitenames")).sendKeys("ww.Testing5.com");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("Testing@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("1234");
	    driver.findElement(By.id("confirmpassword")).clear();
	    driver.findElement(By.id("confirmpassword")).sendKeys("123");
	    assertTrue(isElementPresent(By.cssSelector("div.form-group.has-error > div.input-group > div.input-group-addon > span.ng-isolate-scope")));
	    driver.findElement(By.id("confirmpassword")).clear();
	    driver.findElement(By.id("confirmpassword")).sendKeys("");
	    driver.findElement(By.id("confirmpassword")).clear();
	    driver.findElement(By.id("confirmpassword")).sendKeys("1234");
	    assertFalse(isElementPresent(By.cssSelector("div.form-group.has-error > div.input-group > div.input-group-addon > span.ng-isolate-scope")));
	    driver.findElement(By.id("GeneratePassword")).click();
	    assertFalse(isElementPresent(By.cssSelector("div.form-group.has-error > div.input-group > div.input-group-addon > span.ng-isolate-scope")));
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("Test");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("");
	    assertEquals("You must enter a city for the certificate signing request.", driver.findElement(By.cssSelector("div.form-group.has-error > div.help-block.ng-binding")).getText());
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("New York");
	    driver.findElement(By.id("state")).clear();
	    driver.findElement(By.id("state")).sendKeys("Test");
	    driver.findElement(By.id("state")).clear();
	    driver.findElement(By.id("state")).sendKeys("");
	    assertEquals("You must enter a state for the certificate signing request.", driver.findElement(By.cssSelector("div.form-group.has-error > div.help-block.ng-binding")).getText());
	    driver.findElement(By.id("state")).clear();
	    driver.findElement(By.id("state")).sendKeys("\\");
	    driver.findElement(By.id("country")).clear();
	    driver.findElement(By.id("country")).sendKeys("u");
	    driver.findElement(By.id("country")).clear();
	    driver.findElement(By.id("country")).sendKeys("");
	    assertEquals("You must enter a two letter country code for the certificate signing request.", driver.findElement(By.cssSelector("div.form-group.has-error > div.help-block.ng-binding")).getText());
	    driver.findElement(By.id("country")).clear();
	    driver.findElement(By.id("country")).sendKeys("US");
	    driver.findElement(By.id("company")).clear();
	    driver.findElement(By.id("company")).sendKeys("Tes");
	    driver.findElement(By.id("company")).clear();
	    driver.findElement(By.id("company")).sendKeys("");
	    assertEquals("You must enter a company name for the certificate signing request.", driver.findElement(By.cssSelector("div.form-group.has-error > div.help-block.ng-binding")).getText());
	    driver.findElement(By.id("company")).clear();
	    driver.findElement(By.id("company")).sendKeys("MageMojo");
	    driver.findElement(By.id("division")).clear();
	    driver.findElement(By.id("division")).sendKeys("Tes");
	    driver.findElement(By.id("division")).clear();
	    driver.findElement(By.id("division")).sendKeys("");
	    assertEquals("You must enter a division for the certificate signing request.", driver.findElement(By.cssSelector("div.form-group.has-error > div.help-block.ng-binding")).getText());
	    driver.findElement(By.id("division")).clear();
	    driver.findElement(By.id("division")).sendKeys("\\");
	    assertTrue(isElementPresent(By.id("CreateCSRCancel")));
	    driver.findElement(By.id("Add")).click();
	    
	    for (int second1 = 0;; second1++) {
	    	if (second1 >= 60) fail("timeout");
	    	try { if ("Successfully updated the CSR.".equals(driver.findElement(By.cssSelector("div.ng-scope.ng-binding")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	    
	    assertTrue(isElementPresent(By.xpath("//a[contains(text(),'www.Testing5.com')]")));
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
