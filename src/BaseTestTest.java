import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//****NOTE: Element Locators Can be moved to the Common location i.e Page Factory as a Best Practice. For time being in this Project all the locators are hardcoded.

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class BaseTestTest {
    public WebDriver driver = null;
    private WebDriverWait wait;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        //Assigning the Chromedriver as the Webdriver
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
        //Navigating to the Homepage
        driver.get("https://the-internet.herokuapp.com/");
        //Maximizing the Window
        driver.manage().window().maximize();
        //Initializing the wait method for wait time of 30 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @org.junit.jupiter.api.Test
    public void ABTesting() {
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("A/B Testing")));
        //Clicking the A/B Testing Link
        driver.findElement(By.linkText("A/B Testing")).click();
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/h3")));
        boolean isElementExist = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).isDisplayed();
        //Verifying whether the desired element is existing or not
        Assertions.assertTrue(isElementExist);
    }

    @org.junit.jupiter.api.Test
    public void AddRemoveElements() {
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add/Remove Elements")));
        //Clicking the Add/Remove Elements Link
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/button")));
        boolean isElementExist = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).isDisplayed();
        //Verifying whether the desired element is existing or not
        Assertions.assertTrue(isElementExist);
    }

    @org.junit.jupiter.api.Test
    public void Checkboxes() {
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkboxes")));
        //Clicking the Checkboxes Link
        driver.findElement(By.linkText("Checkboxes")).click();
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkboxes")));
        boolean isElementExist = driver.findElement(By.id("checkboxes")).isDisplayed();
        //Verifying whether the desired element is existing or not
        Assertions.assertTrue(isElementExist);
    }

    @org.junit.jupiter.api.Test
    public void BasicAuth() {
        String username = "admin";
        String password = "admin";

        // Adding username, password with URL
        String URL = "https://" +username +":" +password +"@"+ "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/h3")));

        boolean isElementExist = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).isDisplayed();
        //Verifying whether the desired element is existing or not
        Assertions.assertTrue(isElementExist);
    }

    @org.junit.jupiter.api.Test
    public void DropDownList() {
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dropdown")));
        //Clicking the Dropdown Link
        driver.findElement(By.linkText("Dropdown")).click();
        //Wait for the expected element to be visible/loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        //Selecting Option 1 from the dropdown
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
        //Verifying whether the correct element is selected or not
        WebElement selectedElement = dropdown.getFirstSelectedOption();
        Assertions.assertEquals("Option 1", selectedElement.getText());
    }

    //Below Method will Close the webdriver after every test.
    @org.junit.jupiter.api.AfterEach
    public void cleanup(){
        //Closing the webdriver
        driver.close();
    }

}