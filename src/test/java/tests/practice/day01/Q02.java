package tests.practice.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {
    public static void main(String[] args) {
//      . .Exercise2...
// 1-Driver oluşturalim
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
// 2-Java class'imiza chnomedriver.exet i tanitalim
        WebDriver driver = new ChromeDriver();
// 3-Driver'in tum ekranı kaplamasini saglayalim
        driver.manage().window().maximize();
// 4-"https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");
// 5-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@class='p_btn100--1st cookieBanner__button js_cookieBannerPermissionButton']")).click();
// 6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String ottoTitle = driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);
        String ottoUrl = driver.getCurrentUrl();
        System.out.println("ottoUrl = " + ottoUrl);
// 7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        String searchWord = "OTTO";
        if (ottoTitle.contains(searchWord) && ottoUrl.contains(searchWord)) {
            System.out.println("Title and Url have got the word otto. test PASSED");
        } else {
            System.out.println("Title or URL hasn't got the word otto. test FAILED");
        }
// 8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.navigate().to("https://wisequarter.com/");
// 9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        String actualTitleByWise = driver.getTitle();
        System.out.println("actualTitleByWise = " + actualTitleByWise);
        String exceptedTitle = "Quarter";
        if (actualTitleByWise.contains(exceptedTitle)) {
            System.out.println("Title contains Quarter test PASSED");
        } else {
            System.out.println("Title not contains Quarter test FAILED");
        }
// 10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
// 11-Sayfayı yenileyelim
        driver.navigate().refresh();
// 12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
// 13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.close();
    }

}
