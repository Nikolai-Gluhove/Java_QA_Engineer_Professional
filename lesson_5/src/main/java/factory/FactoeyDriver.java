package factory;

import exceptions.BrowserNotSupportedException;
import factory.impl.ChromeWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FactoeyDriver {

    private final static String BROWSER_NAME = System.getProperty("browser", "chrome");

                                //если браузер не поддерживаеться
    public WebDriver gerDrivet() throws BrowserNotSupportedException{

        switch (BROWSER_NAME){
            case "chrome":{
                ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
                chromeWebDriver.downloadLocalWebDriver(BROWSER_NAME);

                return new  ChromeWebDriver().newDriver();
            }
            //если браузер не поддерживаеться
            default:
                throw new BrowserNotSupportedException(BROWSER_NAME);
        }
    }



}
