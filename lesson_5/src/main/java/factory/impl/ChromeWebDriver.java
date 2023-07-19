package factory.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

//аргументы браузера
public class ChromeWebDriver implements IDriver {

    @Override
    public WebDriver newDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        //поддержка расширений
        chromeOptions.addArguments("-enable-extensions");
        //пустая страница (откроеться не стартовая страница а именно пустая)
        chromeOptions.addArguments("--homepage=about:blank");
        //игнорирование ошибок сертификатов
        chromeOptions.addArguments("--ignore-certificate-errors");
        //принемаем все accept sert если они есть
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //версия браузера (береться из контексата)
        chromeOptions.setCapability(CapabilityType.VERSION, System.getProperty("browser.version", "112.0"));
        //установка имени браузера (для гридов)
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, System.getProperty("browser", "chrome"));
        //для грида (например чтобы видеть что происходит внутри контейнера)
        chromeOptions.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC", "false")));

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        return new ChromeDriver(chromeOptions);
    }
}
