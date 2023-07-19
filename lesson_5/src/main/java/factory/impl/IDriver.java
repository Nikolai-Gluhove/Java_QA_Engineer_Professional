package factory.impl;

import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Config;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

//для полиморфизма на разных браузерах
public interface IDriver {
    public WebDriver newDriver();


    //судя по всему скачивает менеджер под определенной праузер конкретной версии
    default void downloadLocalWebDriver(String browser) throws BrowserNotSupportedException{
        Config wbmConfig = WebDriverManager.getInstance().config();
        wbmConfig.setAvoidBrowserDetection(true);

        String browserVersion =System.getProperty("broweser.version", "");

        if (!browserVersion.isEmpty()){
            switch (browser){
                case "chrome":
                    wbmConfig.setChromeDriverVersion(browserVersion);
                    break;
                default:
                    throw new BrowserNotSupportedException(browser);
            }

            WebDriverManager.getInstance(browser).setup();
        }
    }
}
