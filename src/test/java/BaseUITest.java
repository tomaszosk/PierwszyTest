import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUITest {

    String projectLocation = System.getProperty("user.dir");
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", projectLocation+"/resources/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

    }

    @AfterEach
    public void teardown() {
        driver.close();
    }

}
