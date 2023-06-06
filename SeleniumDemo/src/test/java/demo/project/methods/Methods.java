package demo.project.methods;

import demo.project.driver.SeleniumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class Methods {

    WebDriver webDriver;

    FluentWait<WebDriver> fluentWait;
    JavascriptExecutor jsDriver;
    Actions action;

    public Methods(){

        webDriver = SeleniumDriver.webDriver;
        jsDriver = (JavascriptExecutor) webDriver;
        action = new Actions(webDriver);
        fluentWait = setFluentWait(250,30);
    }

    public FluentWait<WebDriver> setFluentWait(long pollingEvery, long timeout){

        return new FluentWait<WebDriver>(webDriver)
                .pollingEvery(Duration.ofMillis(pollingEvery))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElementWithWait(By by){

        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void navigateToUrl(String url){

        webDriver.navigate().to(url);
    }

    public void navigateToRefresh(){

        webDriver.navigate().refresh();
    }

    public WebElement findElement(By by){

        return webDriver.findElement(by);
    }

    public void click(By by){

        findElementWithWait(by).click();
    }

    public void sendKeys(By by, String text){

        findElementWithWait(by).sendKeys(text);
    }

    public void clear(By by){

        findElementWithWait(by).clear();
    }

    public String getText(By by){

        return findElementWithWait(by).getText();
    }

    public String getAttribute(By by, String attribute){

        return findElementWithWait(by).getAttribute(attribute);
    }

    public boolean isElementVisible(By by, long timeout){

        try {
            setFluentWait(250, timeout)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementInvisible(By by, long timeout){

        try {
            setFluentWait(250, timeout)
                    .until(ExpectedConditions.invisibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementClickable(By by, long timeout){

        try {
            setFluentWait(250, timeout)
                    .until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void hoverElement(WebElement webElement) {

        action.moveToElement(webElement).build().perform();
    }

    public void scrollElement(WebElement webElement){

        jsDriver.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void scrollElementCenter(WebElement webElement){

        jsDriver.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
    }

    public void getCurrentUrl(){

        webDriver.getCurrentUrl();
    }

}
