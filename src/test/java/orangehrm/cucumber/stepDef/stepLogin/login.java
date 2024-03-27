package orangehrm.cucumber.stepDef.stepLogin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseURL = "https://opensource-demo.orangehrmlive.com";

    @Given("User in login form")
    public void user_in_login_form(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);
        driver.manage().window().maximize();

        //assertion
        String loginPage = driver.findElement(By.tagName("h5")).getText();
        //String loginPage = driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']")).getText();
        Assert.assertEquals(loginPage, "Login");
    }

    @When("User input UserID textfield")
    public void userInputUserIDTextfield() {
        driver.findElement(By.name("username")).sendKeys("Admin");
    }

    @And("User input Password textfield")
    public void userInputPasswordTextfield() {
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @And("User click button Login")
    public void userClickButtonLogin() {
        driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']")).click();
    }

    @Then("User on dashboard page")
    public void userOnDashboardPage() {
        String inDashboard = driver.findElement(By.tagName("h6")).getText();
        Assert.assertEquals(inDashboard, "Dashboard");
        driver.close();
    }

    @When("User input invalid UserID textfield")
    public void userInputInvalidUserIDTextfield() {
        driver.findElement(By.name("username")).sendKeys("invalidAdmin");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errMsg = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']")).getText();
        Assert.assertEquals(errMsg, "Invalid credentials");
        driver.close();
    }

    @And("User input invalid Password textfield")
    public void userInputInvalidPasswordTextfield() {
        driver.findElement(By.name("password")).sendKeys("admin123$");
    }

    @Then("User get required message")
    public void userGetRequiredMessage() {
        String requiredMsg = driver.findElement(By.xpath("//span[@class ='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).getText();
        Assert.assertEquals(requiredMsg, "Required");
        driver.close();
    }
}
