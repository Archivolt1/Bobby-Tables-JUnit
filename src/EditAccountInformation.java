import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditAccountInformation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\itgfr\\eclipse-workspace");
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEditAccountInformation() throws Exception {
    driver.get("http://localhost:3000/account");
    driver.findElement(By.linkText("Account")).click();
    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div/div/div/div/a/b")).click();
    driver.findElement(By.id("usernamechange")).click();
    driver.findElement(By.id("usernamechange")).clear();
    driver.findElement(By.id("usernamechange")).sendKeys("Archivolt");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='']")).clear();
    driver.findElement(By.xpath("//input[@id='']")).sendKeys("hello");
    driver.findElement(By.xpath("(//input[@id=''])[2]")).clear();
    driver.findElement(By.xpath("(//input[@id=''])[2]")).sendKeys("hello");
    driver.findElement(By.xpath("(//input[@id=''])[3]")).clear();
    driver.findElement(By.xpath("(//input[@id=''])[3]")).sendKeys("matthew@digitalnoema.com");
    driver.findElement(By.xpath("(//input[@id=''])[4]")).clear();
    driver.findElement(By.xpath("(//input[@id=''])[4]")).sendKeys("matthew@digitalnoema.com");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    assertEquals("Password is being changed to: _hello_", closeAlertAndGetItsText());
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
