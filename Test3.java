package Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test3 {
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

 
  
// Delete user from vhost
   @Test
  public void Test3() throws Exception {
	    driver.get(baseUrl + "/#/host/magehostmanager.magemojo.com/configuration/user");
	    driver.findElement(By.xpath("//a[contains(text(),'Testing_user_1')]")).click();
	    driver.findElement(By.id("delete")).click();
	    assertTrue(isElementPresent(By.xpath("//div[3]/button[2]")));
	    assertTrue(isElementPresent(By.xpath("//div[3]/button")));
	    driver.findElement(By.xpath("//div[3]/button")).click();
	    assertEquals("To delete user you need to delete vhost configuration.", driver.findElement(By.cssSelector("p.ng-binding")).getText());
	    assertTrue(isElementPresent(By.xpath("//div[3]/button")));
	    assertTrue(isElementPresent(By.xpath("//div[3]/button[2]")));
	    driver.findElement(By.xpath("//div[3]/button[2]")).click();
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
