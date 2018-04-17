import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchForBookViaISBN {
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
  public void testSearchForBookViaISBN() throws Exception {
    driver.get("http://localhost:3000/home");
    Thread.sleep(3000);
    driver.findElement(By.id("databaseQuery")).click();
    driver.findElement(By.id("databaseQuery")).clear();
    driver.findElement(By.id("databaseQuery")).sendKeys("9789129558555");
    driver.findElement(By.id("searchSelect")).click();
    new Select(driver.findElement(By.id("searchSelect"))).selectByVisibleText("ISBN");
    driver.findElement(By.id("searchSelect")).click();
    driver.findElement(By.id("searchSubmit")).click();
    assertEquals("A name was submitted: 9789129558555\nA selection type was made: isbn", closeAlertAndGetItsText());
    Thread.sleep(3000);
    driver.findElement(By.linkText("Check it out!")).click();
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