package tests.practice.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String ht = "https://www.";
        driver.get(ht+"google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to(ht+"amazon.com");
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle()); // 16291993AD3FB7DA4E54039D63D90439
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(ht+"wisequarter.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandles()); // [16291993AD3FB7DA4E54039D63D90439, C0F4C64CB32E876E3148BA4569198609]
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(ht+"facebook.com");
        // driver.close(); // Acilan son pencereyi kapatir
        driver.quit(); // Acilmis olan butun pencereleri kapatir


    }
}
