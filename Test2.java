package Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 {
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

 
//  Create website
  @Test
  public void Test2() throws Exception {
	    driver.get(baseUrl + "/#/host/magehostmanager.magemojo.com/configuration/vhost");
	    driver.findElement(By.id("sitename")).clear();
	    driver.findElement(By.id("sitename")).sendKeys("w");
	    assertTrue(isElementPresent(By.id("ValidDomains")));
	    driver.findElement(By.id("sitename")).sendKeys("ww.testing.com");
	    new Select(driver.findElement(By.id("enabled"))).selectByVisibleText("Yes");
	    new Select(driver.findElement(By.id("ip"))).selectByVisibleText("192.190.223.29");
	    new Select(driver.findElement(By.id("owner"))).selectByVisibleText("Testing_user_1");
	    new Select(driver.findElement(By.id("isdev"))).selectByVisibleText("Yes");
	    driver.findElement(By.id("ShowAdvancedOptions")).click();
	    new Select(driver.findElement(By.id("hhvm"))).selectByVisibleText("Yes");
	    driver.findElement(By.id("vhostincludenginx")).clear();
	    driver.findElement(By.id("vhostincludenginx")).sendKeys("Testing _1");
	    driver.findElement(By.id("HideAdvancedOptions")).click();
	    driver.findElement(By.id("ShowAdvancedOptions")).click();
	    try {
	      assertEquals("Testing _1", driver.findElement(By.id("vhostincludenginx")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    driver.findElement(By.id("HideAdvancedOptions")).click();
	    driver.findElement(By.id("ShowMultistores")).click();
	    driver.findElement(By.id("multistoredomain")).clear();
	    driver.findElement(By.id("multistoredomain")).sendKeys("Domain_testing");
	    driver.findElement(By.id("multistorekey")).clear();
	    driver.findElement(By.id("multistorekey")).sendKeys("er1234-=");
	    new Select(driver.findElement(By.id("multistoretype"))).selectByVisibleText("store");
	    driver.findElement(By.id("AddMultistore")).click();
	    driver.findElement(By.id("multistoredomain")).clear();
	    driver.findElement(By.id("multistoredomain")).sendKeys("Domain_testing2");
	    driver.findElement(By.id("multistorekey")).clear();
	    driver.findElement(By.id("multistorekey")).sendKeys("1234");
	    new Select(driver.findElement(By.id("multistoretype"))).selectByVisibleText("website");
	    driver.findElement(By.id("AddMultistore")).click();
	    driver.findElement(By.id("multistoredomain")).clear();
	    driver.findElement(By.id("multistoredomain")).sendKeys("Domain_test3");
	    driver.findElement(By.id("multistorekey")).clear();
	    driver.findElement(By.id("multistorekey")).sendKeys("12345");
	    new Select(driver.findElement(By.id("multistoretype"))).selectByVisibleText("store");
	    driver.findElement(By.id("AddMultistore")).click();
	    driver.findElement(By.id("multistoredomain")).clear();
	    driver.findElement(By.id("multistoredomain")).sendKeys("Domain_test4");
	    driver.findElement(By.id("multistorekey")).clear();
	    driver.findElement(By.id("multistorekey")).sendKeys("12345");
	    new Select(driver.findElement(By.id("multistoretype"))).selectByVisibleText("website");
	    driver.findElement(By.id("AddMultistore")).click();
	    driver.findElement(By.id("HideMultistores")).click();
	    driver.findElement(By.id("ShowMultistores")).click();
	    assertTrue(isElementPresent(By.xpath("//div[5]/div/div[3]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[4]/div/div[3]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[2]/div/div[2]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    assertTrue(isElementPresent(By.xpath("//div/div[3]/label")));
	    driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
	    assertTrue(isElementPresent(By.xpath("//div/div[2]/label")));
	    driver.findElement(By.id("HideMultistores")).click();
	    driver.findElement(By.id("ShowPHPOptions")).click();
	    driver.findElement(By.id("newoptionname")).clear();
	    driver.findElement(By.id("newoptionname")).sendKeys("Test");
	    driver.findElement(By.id("newoptionvalue")).clear();
	    driver.findElement(By.id("newoptionvalue")).sendKeys("123test");
	    driver.findElement(By.id("AddOption")).click();
	    driver.findElement(By.id("newoptionname")).clear();
	    driver.findElement(By.id("newoptionname")).sendKeys("Test2");
	    driver.findElement(By.id("newoptionvalue")).clear();
	    driver.findElement(By.id("newoptionvalue")).sendKeys("12345");
	    driver.findElement(By.id("AddOption")).click();
	    driver.findElement(By.id("newoptionname")).clear();
	    driver.findElement(By.id("newoptionname")).sendKeys("Test3");
	    driver.findElement(By.id("newoptionvalue")).clear();
	    driver.findElement(By.id("newoptionvalue")).sendKeys("12345");
	    driver.findElement(By.id("AddOption")).click();
	    driver.findElement(By.id("newoptionname")).clear();
	    driver.findElement(By.id("newoptionname")).sendKeys("Test4");
	    driver.findElement(By.id("newoptionvalue")).clear();
	    driver.findElement(By.id("newoptionvalue")).sendKeys("12345");
	    driver.findElement(By.id("AddOption")).click();
	    driver.findElement(By.id("HidePHPOptions")).click();
	    driver.findElement(By.id("ShowPHPOptions")).click();
	    assertTrue(isElementPresent(By.xpath("//div[5]/div/div[3]")));
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[4]/div/div[2]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[3]/div/div[2]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[9]/div/div/div[2]/label")));
	    driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
	    assertTrue(isElementPresent(By.xpath("//div[9]/div/div/div[2]/label")));
	    driver.findElement(By.id("HidePHPOptions")).click();
	    driver.findElement(By.id("ShowRedirects")).click();
	    driver.findElement(By.id("newredirectname")).clear();
	    driver.findElement(By.id("newredirectname")).sendKeys("Test");
	    driver.findElement(By.id("newredirectvalue")).clear();
	    driver.findElement(By.id("newredirectvalue")).sendKeys("Test");
	    driver.findElement(By.id("AddRedirect")).click();
	    driver.findElement(By.id("newredirectname")).clear();
	    driver.findElement(By.id("newredirectname")).sendKeys("Test2");
	    driver.findElement(By.id("newredirectvalue")).clear();
	    driver.findElement(By.id("newredirectvalue")).sendKeys("Test2");
	    driver.findElement(By.id("AddRedirect")).click();
	    driver.findElement(By.id("newredirectname")).clear();
	    driver.findElement(By.id("newredirectname")).sendKeys("Test3");
	    driver.findElement(By.id("newredirectvalue")).clear();
	    driver.findElement(By.id("newredirectvalue")).sendKeys("Test3");
	    driver.findElement(By.id("AddRedirect")).click();
	    driver.findElement(By.id("newredirectname")).clear();
	    driver.findElement(By.id("newredirectname")).sendKeys("Test4");
	    driver.findElement(By.id("newredirectvalue")).clear();
	    driver.findElement(By.id("newredirectvalue")).sendKeys("Test4");
	    driver.findElement(By.id("AddRedirect")).click();
	    driver.findElement(By.id("HideRedirects")).click();
	    driver.findElement(By.id("ShowRedirects")).click();
	    assertTrue(isElementPresent(By.xpath("//div[4]/div/div[2]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[3]/div/div[2]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[2]/div/div[2]/label")));
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
	    assertTrue(isElementPresent(By.xpath("//div[10]/div/div/div[2]/label")));
	    driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
	    assertTrue(isElementPresent(By.xpath("//div[10]/div/div/div[2]/label")));
	    driver.findElement(By.id("HideRedirects")).click();
	    driver.findElement(By.id("ShowAccessConfiguration")).click();
	    driver.findElement(By.name("ipaccessrestricted")).click();
	    driver.findElement(By.name("pwdaccessrestricted")).click();
	    driver.findElement(By.name("redirectenabled")).click();
	    driver.findElement(By.name("redirecturl")).clear();
	    driver.findElement(By.name("redirecturl")).sendKeys("Domain/urlo");
	    driver.findElement(By.name("placeholderenabled")).click();
	    driver.findElement(By.name("redirecturl")).clear();
	    driver.findElement(By.name("redirecturl")).sendKeys("test");
	    driver.findElement(By.name("redirecturl")).clear();
	    driver.findElement(By.name("redirecturl")).sendKeys("test.com");
	    driver.findElement(By.name("redirectenabled")).click();
	    driver.findElement(By.name("redirectenabled")).click();
	    driver.findElement(By.name("redirecturl")).clear();
	    driver.findElement(By.name("redirecturl")).sendKeys("");
	    driver.findElement(By.name("placeholderenabled")).click();
	    driver.findElement(By.name("placeholderenabled")).click();
	    driver.findElement(By.id("newipaccessrulename")).clear();
	    driver.findElement(By.id("newipaccessrulename")).sendKeys("Ts");
	    driver.findElement(By.id("newdirectorylabel")).clear();
	    driver.findElement(By.id("newdirectorylabel")).sendKeys("Ts");
	    driver.findElement(By.id("newipaccessrulemask")).clear();
	    driver.findElement(By.id("newipaccessrulemask")).sendKeys("123.48.76.67");
	    new Select(driver.findElement(By.id("rule"))).selectByVisibleText("Deny");
	    driver.findElement(By.cssSelector("#folder > i.glyphicon.glyphicon-folder-open")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();
	    assertTrue(isElementPresent(By.xpath("(//button[@type='button'])[11]")));
	    driver.findElement(By.xpath("(//button[@type='button'])[14]")).click();
	    driver.findElement(By.id("HideAccessConfiguration")).click();
	    driver.findElement(By.id("Add")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'www.testing.com')]")).click();
	    assertTrue(isElementPresent(By.id("Delete")));
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
