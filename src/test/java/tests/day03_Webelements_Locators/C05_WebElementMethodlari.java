package tests.day03_Webelements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementListi = driver.findElements(By.tagName("a"));
        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementListi.size();

        if (actualLinkSayisi == expectedLinkSayisi) {
            System.out.println("147 adet link var testi PASSED");
        } else {
            System.out.println("147 adet link var testi FAILED");
        }

        // 4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();

        // 5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special offer testi PASSED");
        }else {
            System.out.println("Special offer testi FAILED");
        }

        // 6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
