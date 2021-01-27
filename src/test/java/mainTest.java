import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class mainTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.saucedemo.com/";
        String title = "Swag Labs";
        driver.get(url);
        String actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(title)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        driver.close();
    }
}
