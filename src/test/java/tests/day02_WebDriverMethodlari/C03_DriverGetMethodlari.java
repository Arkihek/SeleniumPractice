package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wisequarter.com");

        Thread.sleep(13000);
        System.out.println(driver.getTitle());

        // Sayfa title`nin Wise icerdigini test edin

        String expectedIcerik = "Wise";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title wise icermiyor. Test FAILED");
        }

        // Url`in https://wisequarter.com oldugunu test edin

        String expectedUrl = "https://wisequarter.com";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url testi FAILED");
            System.out.println("ActualUrl : " + actualUrl);
        } // ActualUrl : https://wisequarter.com/ test failed

         System.out.println(driver.getPageSource());
        // Sayfa kaynagi tum kodlari getirir
        // Sayfa kaynagi testlerde cok kullanilmaz

        System.out.println(driver.getWindowHandle()); // 764E1BD3939202F9F185CDCD168CE861
        // Sistemde her olusturulan browser icin unique bir window handle degeri atanir
        // bu handle degeri sayfalar arasinda gecis yapmak icin kullanilir
        // Bu window acik iken biz baska bir window`da calisiyorsak ve
        // bu window`a gecmek istiyorsak
        // driver`a "window handle degeri 764E1BD3939202F9F185CDCD168CE861 olan window`a git" dersek
        // driver bu window`a gecis yapar

        System.out.println(driver.getWindowHandles()); // [7FF188FDF6AAB13E86403369FBD0E226]
        // bulundugumuz class`daki driver tarafindan
        // kac tane window actiysak ve acik olan tum windowlarin
        // window handle degerlerini bir Set olarak bize dondurur

        driver.close();

    }
}
