package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class C07_DriverMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.Chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


       // Soru - 1
       // 1.Yeni bir class olusturalim (Homework)
       // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://facebook.com");
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Facebook title test PASSED");
        } else {
            System.out.println("Facebook title test FAILED");
            System.out.println("Actual title : " + actualTitle);
        } // Facebook title test FAILED Actual title : Facebook - Giriş Yap veya Kaydol

       // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.

        String expectedUrlIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Facebook Url test PASSED"); // Facebook Url test PASSED
        }else {
            System.out.println("Facebook Url test FAILED" + "\nActual Url : " + actualUrl);
        }
       // 4.https://www.walmart.com/ sayfasina gidin.

        driver.navigate().to("https://www.walmart.com/");

       // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.

        actualTitle = driver.getTitle();
        String expectedTitleIcerik = "Walmart.com";

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Walmart title test PASSED"); // Walmart title test PASSED
        }else {
            System.out.println("Walmart title test FAILED" + "\nActual title : " + actualTitle);
        }

       // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
       // 7. Sayfayi yenileyin
        driver.navigate().refresh();
       // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
       // 9.Browser’i kapatin
        Thread.sleep(3000);
        driver.close();

    }
}
