package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.BrowserDriver;
import utility.XPathConstants;

import static pages.Amazon.*;

public class AmazonSteps extends BrowserDriver {

    @Given("I open Google website in browser <{string}>")
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
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        System.out.println("Title of the page:" + driver.getTitle());
    }

    @When("I enter text <{string}> and navigate to amazonwebsite")
    public void Amazon_Search(String Keyword) throws Throwable  {
        Google_Search_Box_Entry_And_Search(Keyword);
    }

    @And("I enter {string} in search and click on search")
    public void Search_Box_Search(String Keyword) throws Throwable  {
        Search_Box_Entry_And_Search(Keyword);
    }

    @And("I look for the text {string}")
    public void LookForText(String InputText) throws Throwable  {
        Search_in_Pagesource(InputText);
    }

    @Then("The text {string} is verified in the page")
    public void theTextIsVerifiedInThePage(String InputText) throws Throwable {
        Pagesource_Validation(InputText);

    }


}
