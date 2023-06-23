package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // wisequarter.com`a gidelim
        driver.navigate().to("https://www.wisequarter.com");
        Thread.sleep(2000);

        // Ayni browser`da amazon anasayfasina gidelim
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);

        // Tekrar wise anasayfasina donelim
        driver.navigate().back();
        Thread.sleep(2000);

        // Tekrar amazon anasayfasina donelim
        driver.navigate().forward();
        Thread.sleep(2000);

        driver.close();
    }
}
