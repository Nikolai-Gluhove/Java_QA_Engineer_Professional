package exceptions;

//исключение не поддерживаеться браузер
public class BrowserNotSupportedException extends Exception{

    public BrowserNotSupportedException(String browserName){
        super(String.format("Browser %s not supported", browserName));
    }
}
