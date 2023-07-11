package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    private WebDriverWait webDriverWait = null;
    private WebDriver driver = null;

    public Waiters(WebDriver driver){
        webDriverWait = new WebDriverWait(driver, 10);
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition){
        try {
            webDriverWait.until(condition);
            return true;
        }catch (TimeoutException ignoring){
            return false;
        }
    }

    public boolean waitForElementVisible(WebElement element){
        return waitForCondition(ExpectedConditions.visibilityOf(element));
    }
}
