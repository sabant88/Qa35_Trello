package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    HelperBoard helperBoard;

    @BeforeTest
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com/");
        wd.navigate().refresh();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        helperUser=new HelperUser(wd);
        helperBoard=new HelperBoard(wd);
    }

    public void stop(){
        wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperBoard getHelperBoard() {
        return helperBoard;
    }
}
