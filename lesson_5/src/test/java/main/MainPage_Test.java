package main;

import annotations.Driver;
import exceptions.BrowserNotSupportedException;
import extensions.UIExtensions;
import factory.FactoeyDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(UIExtensions.class)
public class MainPage_Test {

    @Driver
    private WebDriver driver;

    //насколько я понял создаем драйвер
    @BeforeEach
    public void beforeEach() throws BrowserNotSupportedException {
        this.driver = new FactoeyDriver().gerDrivet();
    }
}
