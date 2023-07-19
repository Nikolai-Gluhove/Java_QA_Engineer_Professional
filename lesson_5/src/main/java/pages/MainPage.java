package pages;

import annotations.Path;
import annotations.Template;
import annotations.UrlTemplates;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@UrlTemplates(
//        templates = {
//                @Template(name = "news", template = "/{1}/new/{2}"),
//                @Template(name = "aeticles", template = "/{1}")
//        }
//)
@Path("/")
public class MainPage extends AbsBasePage<MainPage>{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-qa='Wrapper'] div > div >[data-qa='ArticleThumb']")
    private List<WebElement> articleThumb;

    public MainPage pageArticleThumbsShouldBeVisible(){
        long actualarticleThumb = articleThumb.stream().filter((WebElement articleThumb) -> waiters.waitForElementVisible(articleThumb)).count();
        assertThat(actualarticleThumb)
                .as("")
                .isEqualTo(articleThumb.size());

        return this;
    }
}
