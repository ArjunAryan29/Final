package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import utility.BrowserDriver;
import utility.XPathConstants;

import static utility.XPathConstants.*;


public class Calculator extends BrowserDriver {

    public static void goToInflation() throws Throwable {
        // Scroll to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        BrowserDriver.clickByXpath(driver,XPathConstants.Inflation_Calc_link);
    }

    // 3 ways to do it
    // JavascriptExecutor js = (JavascriptExecutor) driver;
    // js.executeScript("window.scrollBy(0,250)", "”);
    // Actions action = new Actions(driver); action.moveToElement(element).perform();
    // WebElement element = driver.findElement(By.<locator>)); element.sendKeys(Keys.DOWN);
    public static void clear() throws Throwable {
        BrowserDriver.clickByXpath(driver,XPathConstants.Clear_Button);
    }

    public static void calculate() throws Throwable {
        BrowserDriver.clickByXpath(driver,XPathConstants.Inflation_Calc_Button);
    }

public static void Enter_Values(String amount, String monthF, String yearF, String monthL, String yearL)throws Throwable{

        BrowserDriver.clearText(driver, Calc_Amount );
        BrowserDriver.sendKeysByXPath(driver, Calc_Amount,amount);

    BrowserDriver.SelectByVText(driver, DDValueFromMonth,monthF);
    BrowserDriver.SelectByVText(driver, DDValueFromYear,yearF);
    BrowserDriver.SelectByVText(driver, DDValueToMonth,monthL);
    BrowserDriver.SelectByVText(driver, DDValueToYear,yearL);

}

//    public static void verify() throws Throwable {
//        BrowserDriver.getTextMethod(Result_Amount);
//        // can I use the AmountF variable on the feature page?
//        if () {
//            System.out.println("This is the correct amount");
//        } else {
//            System.out.println("This is not correct");
//        }
//    }
}