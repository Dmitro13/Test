package Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
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

  @Test
//  User create
  public void Test1() throws Exception {
    driver.get(baseUrl + "/#/host/magehostmanager.magemojo.com/configuration/user");
    assertTrue(isElementPresent(By.id("generatorPassword")));
    assertTrue(isElementPresent(By.id("ShowAdvancedOptions")));
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Testing user 1");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("");
    assertEquals("Your must enter a user name.", driver.findElement(By.cssSelector("div.help-block.ng-binding")).getText());
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Testing_user_1");
    new Select(driver.findElement(By.id("enabled"))).selectByVisibleText("No");
    driver.findElement(By.id("generatorPassword")).click();
    assertFalse(isElementPresent(By.cssSelector("div.form-group.has-error > div.input-group > div.input-group-addon > span.ng-isolate-scope")));
    new Select(driver.findElement(By.id("sshenabled"))).selectByVisibleText("No");
    driver.findElement(By.id("ShowAdvancedOptions")).click();
    driver.findElement(By.id("keypairGenerate")).click();
    driver.findElement(By.id("authkeys")).clear();
    driver.findElement(By.id("authkeys")).sendKeys("Test_user_1");
    driver.findElement(By.id("HideAdvancedOptions")).click();
    assertTrue(isElementPresent(By.id("btnRemove")));
    driver.findElement(By.id("add")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if ("Successfully created the user.".equals(driver.findElement(By.cssSelector("div.ng-scope.ng-binding")).getText())) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    driver.findElement(By.xpath("//a[contains(text(),'Testing_user_1')]")).click();
    assertTrue(isElementPresent(By.id("delete")));
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
