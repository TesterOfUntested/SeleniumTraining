import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class testLoginPage {

    protected static WebDriver driver;
    protected static String url = "https://www.saucedemo.com/";

    @BeforeAll
    static void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.get(url);
    }

    @Test
    void failedLoginTestWrongUsername(){
        driver.findElement(By.id("user-name")).sendKeys("dasf");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assert driver.findElement(By.tagName("h3")).getText().contains("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    void failedLoginTestWrongPassword(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("dasda");
        driver.findElement(By.id("login-button")).click();
        assert driver.findElement(By.tagName("h3")).getText().contains("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    void loginTest(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        assert driver.getCurrentUrl().contentEquals("https://www.saucedemo.com/inventory.html");
    }



    @AfterEach
    void tearOne(){
        driver.get(url);
    }

    @AfterAll
    static void tearDown(){
        driver.close();
    }
}
