package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    

    @Given("^command new user is selected$")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("nonexistent username {string} and password {string} are given")
    public void nonexistentUserAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void validUserNameAndPasswordAndConfirmationAreGiven(String username, String password) throws Throwable {
        createUser(username, password, password);
    }

    @Then("a new user is created")
    public void newUserIsCreated() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
        pageHasContent("continue to application mainpage");
    }

    @When("an invalid username {string} and valid password {string} and matching password confirmation are entered")
    public void invalidUserNameAndPasswordAndConfirmationAreGiven(String username, String password) throws Throwable {
        createUser(username, password, password);
    }

    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorThrown(String error) throws Throwable {
        pageHasContent(error);
    }

    @Then("a valid username {string} and invalid password {string} are entered")
    public void validUsernameAndInvalidPasswordAreGiven(String username, String password) throws Throwable {
        createUser(username, password, password);
    }

    @Then("a valid username {string} and valid password {string} and mismatch password {string} are entered")
    public void mismatchingPasswordsAreGiven(String username, String password, String passwordConfirmation) throws Throwable {
        createUser(username, password, passwordConfirmation);
    }

    @Given("user with username {string} with password {string} is successfully created")
    public void userWithValidUserAndPasswordIsCreated(String username, String password) throws Throwable {
        newUserIsSelected();
        createUser(username, password, password);
        WebElement signout = driver.findElement(By.linkText("continue to application mainpage"));
        signout.click();
        signout = driver.findElement(By.linkText("logout"));
        signout.click();
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) throws Throwable {
        newUserIsSelected();
        createUser(username, password, password);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void createUser(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
