import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class testInventoryPage {
    protected static WebDriver driver;
    protected static String url = "https://www.saucedemo.com/";

    String[][] inventory = {
            {"Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "$29.99"},
            {"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "$9.99"},
            {"Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "$15.99"},
            {"Sauce Labs Fleece Jacket","It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "$49.99"},
            {"Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "$7.99"},
            {"Test.allTheThings() T-Shirt (Red)", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.", "$15.99"}
    };

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void testItemsCount(){
        int itemsSize = driver.findElements(By.className("inventory_item")).size();
        assert itemsSize == 6;
    }

    @Test
    public void testItemsNames(){
        assert driver.findElements(By.className("inventory_item_name")).get(0).getText().equals(inventory[0][0]);
        assert driver.findElements(By.className("inventory_item_name")).get(1).getText().equals(inventory[1][0]);
        assert driver.findElements(By.className("inventory_item_name")).get(2).getText().equals(inventory[2][0]);
        assert driver.findElements(By.className("inventory_item_name")).get(3).getText().equals(inventory[3][0]);
        assert driver.findElements(By.className("inventory_item_name")).get(4).getText().equals(inventory[4][0]);
        assert driver.findElements(By.className("inventory_item_name")).get(5).getText().equals(inventory[5][0]);
    }

    @Test
    public void testItemsDescriptions(){
        assert driver.findElements(By.className("inventory_item_desc")).get(0).getText().equals(inventory[0][1]);
        assert driver.findElements(By.className("inventory_item_desc")).get(1).getText().equals(inventory[1][1]);
        assert driver.findElements(By.className("inventory_item_desc")).get(2).getText().equals(inventory[2][1]);
        assert driver.findElements(By.className("inventory_item_desc")).get(3).getText().equals(inventory[3][1]);
        assert driver.findElements(By.className("inventory_item_desc")).get(4).getText().equals(inventory[4][1]);
        assert driver.findElements(By.className("inventory_item_desc")).get(5).getText().equals(inventory[5][1]);
    }

    @Test
    public void testItemsPrices(){
        assert driver.findElements(By.className("inventory_item_price")).get(0).getText().equals(inventory[0][2]);
        assert driver.findElements(By.className("inventory_item_price")).get(1).getText().equals(inventory[1][2]);
        assert driver.findElements(By.className("inventory_item_price")).get(2).getText().equals(inventory[2][2]);
        assert driver.findElements(By.className("inventory_item_price")).get(3).getText().equals(inventory[3][2]);
        assert driver.findElements(By.className("inventory_item_price")).get(4).getText().equals(inventory[4][2]);
        assert driver.findElements(By.className("inventory_item_price")).get(5).getText().equals(inventory[5][2]);
    }

    @Test
    public void testSortedItemsNamesAToZ(){
        Select drpSort = new Select(driver.findElement(By.className("product_sort_container")));
        drpSort.selectByValue("az");
        assert driver.findElements(By.className("inventory_item_name")).get(0).getText().equals(inventory[0][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(0).getText().equals(inventory[0][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(0).getText().equals(inventory[0][2]);
        assert driver.findElements(By.className("inventory_item_name")).get(5).getText().equals(inventory[5][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(5).getText().equals(inventory[5][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(5).getText().equals(inventory[5][2]);
    }

    @Test
    public void testSortedItemsNamesZToA(){
        Select drpSort = new Select(driver.findElement(By.className("product_sort_container")));
        drpSort.selectByValue("za");
        assert driver.findElements(By.className("inventory_item_name")).get(5).getText().equals(inventory[0][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(5).getText().equals(inventory[0][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(5).getText().equals(inventory[0][2]);
        assert driver.findElements(By.className("inventory_item_name")).get(0).getText().equals(inventory[5][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(0).getText().equals(inventory[5][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(0).getText().equals(inventory[5][2]);
    }

    @Test
    public void testSortedItemsPriceLowToHigh(){
        Select drpSort = new Select(driver.findElement(By.className("product_sort_container")));
        drpSort.selectByValue("lohi");
        assert driver.findElements(By.className("inventory_item_name")).get(0).getText().equals(inventory[4][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(0).getText().equals(inventory[4][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(0).getText().equals(inventory[4][2]);
        assert driver.findElements(By.className("inventory_item_name")).get(5).getText().equals(inventory[3][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(5).getText().equals(inventory[3][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(5).getText().equals(inventory[3][2]);
    }
    @Test
    public void testSortedItemsPriceHighToLow(){
        Select drpSort = new Select(driver.findElement(By.className("product_sort_container")));
        drpSort.selectByValue("hilo");
        assert driver.findElements(By.className("inventory_item_name")).get(5).getText().equals(inventory[4][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(5).getText().equals(inventory[4][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(5).getText().equals(inventory[4][2]);
        assert driver.findElements(By.className("inventory_item_name")).get(0).getText().equals(inventory[3][0]);
        assert driver.findElements(By.className("inventory_item_desc")).get(0).getText().equals(inventory[3][1]);
        assert driver.findElements(By.className("inventory_item_price")).get(0).getText().equals(inventory[3][2]);
    }
    
    @Test
    public void testNumbersOfItemsInCart(){
        driver.findElements(By.className("btn_inventory")).get(0).click();
        assert driver.findElements(By.className("shopping_cart_badge")).get(0).getText() == "1";
    }

    @AfterEach
    public void sortBack(){
        Select drpSort = new Select(driver.findElement(By.className("product_sort_container")));
        drpSort.selectByValue("az");
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }

}
