
package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import utility.BrowserDriver;

import static org.junit.Assert.assertEquals;
import static pages.Calculator.*;
import static pages.ValidDetails.*;
import static utility.BrowserDriver.driver;
import static utility.XPathConstants.Calc_Amount;

public class CalculatorSteps {

    @Given("I open Calculator website in browser <{string}>")

    public void Browser_Choice(String browser) throws Throwable {
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

        driver.get("https://www.calculator.net/");
        driver.manage().window().maximize();
        System.out.println("Title of the page:" + driver.getTitle());
    }

    @When("I navigate to Inflation Calculator")
    public void navigateInflationCalculator() throws Throwable {
        goToInflation();
    }

    @And("I clear Inflation Calculator")
    public void clearInflationCalculator() throws Throwable {
        clear();
    }


    @And("I enter {string} and select {string},{string} and {string},{string}")

    public void i_enter_and_select_and(String amount, String monthF, String yearF, String monthL, String yearL) {
     
        BrowserDriver.clearText(driver, Calc_Amount );
        BrowserDriver.sendKeysByXPath(driver, Calc_Amount,amount);

        Select fromMonth = new Select(driver.findElement(By.name("cinmonth1")));
        fromMonth.selectByVisibleText(monthF);
        Select fromYear = new Select(driver.findElement(By.name("cinyear1")));
        fromYear.selectByVisibleText(yearF);

        Select toYear = new Select(driver.findElement(By.name("coutyear1")));
        toYear.selectByVisibleText(yearL);

        Select toMonth = new Select(driver.findElement(By.name("coutmonth1")));
        toMonth.selectByVisibleText(monthL);

    }

    @And("I calculate")
    public void iCalculate() throws Throwable {
        calculate();
    }

    @Then("I verify {string} is the buying power for every amount")
    public void i_verify_is_the_buying_power_for_every_amount(String expectedAmountF) {
        WebElement resultElement = driver.findElement(By.xpath("//*[@id='content']/p[2]/b/font"));
        String resultText = resultElement.getText().replace("$", "").replace(",", "").trim();
        double actualResult = Double.parseDouble(resultText);
        double expectedResult = Double.parseDouble(expectedAmountF);
        assertEquals(expectedResult, actualResult, 0.01);
    }
}