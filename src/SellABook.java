import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SellABook {
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
  public void testSellABook() throws Exception {
    driver.get("http://localhost:3000/home");
    driver.findElement(By.linkText("List A Book")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("exampleFormControlTextarea1")).click();
    driver.findElement(By.id("exampleFormControlTextarea1")).clear();
    driver.findElement(By.id("exampleFormControlTextarea1")).sendKeys("This is a test entry for a book.");
    driver.findElement(By.id("title")).click();
    driver.findElement(By.id("title")).clear();
    driver.findElement(By.id("title")).sendKeys("Test Book");
    driver.findElement(By.id("isbn")).click();
    driver.findElement(By.id("isbn")).clear();
    driver.findElement(By.id("isbn")).sendKeys("55555555");
    Thread.sleep(3000);
    driver.findElement(By.id("author")).click();
    driver.findElement(By.id("author")).clear();
    driver.findElement(By.id("author")).sendKeys("Zucc");
    driver.findElement(By.id("edition")).click();
    driver.findElement(By.id("edition")).clear();
    driver.findElement(By.id("edition")).sendKeys("1");
    driver.findElement(By.id("subject")).click();
    driver.findElement(By.id("subject")).clear();
    driver.findElement(By.id("subject")).sendKeys("Math");
    driver.findElement(By.id("exampleFormControlSelect1")).click();
    new Select(driver.findElement(By.id("exampleFormControlSelect1"))).selectByVisibleText("New");
    driver.findElement(By.id("exampleFormControlSelect1")).click();
    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/form/div[4]/div/div/label")).click();
    driver.findElement(By.id("price")).click();
    driver.findElement(By.id("price")).clear();
    driver.findElement(By.id("price")).sendKeys("100.00");
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
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
