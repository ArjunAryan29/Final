
package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.BrowserDriver;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static pages.ValidDetails.*;
import static utility.BrowserDriver.driver;

public class UspsSteps extends BrowserDriver {
    @Given("I look up a zip code using <{string}>")
    public void openBrowser(String browser)  throws Throwable  {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
        driver.get("https://tools.usps.com/zip-code-lookup.htm?byaddress");
        driver.manage().window().maximize();
        System.out.println("Title of the page:" + driver.getTitle());
    }


    @When("I enter a street address")
    public void iEnterAstreetAddress() throws Throwable  {
        driver.findElement(By.xpath("//input[@id='tAddress']")).sendKeys("4970 El Camino Real");
    }

    @When("I click on LOGO to go to home page")
    public void iClickLogo() throws Throwable  {
        driver.findElement(By.xpath("//*[@id='g-navigation']/div/a[1]/img")).click();
    }

    @And("I enter the city")
    public void iEnterTheCity() throws Throwable  {
        driver.findElement(By.xpath("//input[@id='tCity']")).sendKeys("Los Altos");
    }

    @And("I navigate to bottom of the page")
    public void ScrollFunction() throws Throwable  {
        // Locate the element to scroll to
        WebElement element = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[3]/h3"));
        // Create an instance of JavaScriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Scroll the element into view
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        // You can add a wait here if necessary to observe the scrolling
        Thread.sleep(5000);
        WebElement initialElement = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[3]/h3"));
        Actions actions = new Actions(driver);
        // Perform the sequence of actions
        actions.click(initialElement)
                .sendKeys("\t")  // Press Tab
                .sendKeys("\n")  // Press Enter
                .perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

    }

    @And("I click the Find Out more")
    public void FindMore() throws Throwable  {
        Thread.sleep(9000);
        driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[3]/p[2]/a")).click();
    }

    @And("I navigate to new tab")
    public void Newtab() throws Throwable  {

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        // Switch to the newly opened tab
        driver.switchTo().window(tabs.get(1));
    }

    @And("I select the state")
    public void iSelectTheState() throws Throwable  {

        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='tState']"));

        // Create a Select object

        Select dropdown = new Select(dropdownElement);

        // Select the option by value

        dropdown.selectByValue("CA");
    }

    @And("I click the Find button")
    public void iClickTheFindButton() throws Throwable  {
        driver.findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I can see that the correct zip code displays in the result")
    public void iCanSeeThatTheCorrectZipCodeDisplaysInTheResult() throws Throwable  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        String result_message = driver.findElement(By.xpath("//*[@id='zipByAddressDiv']/ul/li[1]/div[1]/p[3]/strong")).getText();

//        String result_message = getText(By.xpath(Final_Msg));

        assertEquals("94022-1460", result_message);
    }

    @Then("I verify Now hiring message on the page")
    public void MsgValidation() throws Throwable  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        String result_message = driver.findElement(By.xpath("//*[@id='contentstart']/div[2]/div/div/div[2]/h2")).getText();

//        String result_message = getText(By.xpath(Final_Msg));

        assertEquals("Now hiring", result_message);
    }
}