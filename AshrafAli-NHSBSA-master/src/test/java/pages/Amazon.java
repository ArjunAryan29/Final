package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.BrowserDriver;
import utility.XPathConstants;

import java.io.IOException;
import java.time.Duration;

public class Amazon extends BrowserDriver {

    public static void Search_Box_Entry_And_Search(String Keyword) throws IOException {

BrowserDriver.SearchBox_SearchText(driver,XPathConstants.Amazon_SearchBox,XPathConstants.Amazon_Search_Icon,Keyword);
        }

    public static void Google_Search_Box_Entry_And_Search(String Keyword) throws IOException {

        //steps for cookies accept
            Actions actions = new Actions(driver);
            actions.sendKeys("\t")  // Press Tab
                    .sendKeys("\t")  // Press Tab again
                    .sendKeys("\t")  // Press Tab again
                    .sendKeys("\n")  // Press Enter
                    .perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        BrowserDriver.Google_SearchBox_SearchText(driver,XPathConstants.Google_Searchbox,XPathConstants.Google_Logo,XPathConstants.Google_Search_BTN,Keyword);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(800));
        BrowserDriver.clickByXpath(driver,XPathConstants.Google_Search_Result);
    }

    public static void Search_in_Pagesource(String Keyword) throws IOException {
       BrowserDriver.Search_in_source(driver,Keyword);
    }

    public  static void Pagesource_Validation(String Keyword)throws IOException{
        BrowserDriver.PageSource_Assertion(driver,Keyword);
    }
}

