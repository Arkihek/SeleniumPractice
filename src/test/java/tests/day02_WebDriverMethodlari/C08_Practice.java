package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Practice {
    public static void main(String[] args) throws InterruptedException {


        // 1. Yeni bir class olusturun (TekrarTesti)
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //    doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        String exceptedTitle = "youtube";
        if (actualTitle.equals(exceptedTitle)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED" + "\nActual title : " + actualTitle);
        }
        // 3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //    doğru URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        String exceptedUrl = "youtube";
        if (actualUrl.contains(exceptedUrl)){
            System.out.println("Url test PASSED");
        }else {
            System.out.println("Url test FAILED" + "\nActual Url : " + actualUrl);
        }

        // 4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        // 5. Youtube sayfasina geri donun
        driver.navigate().back();

        // 6. Sayfayi yenileyin
        driver.navigate().refresh();

        // 7. Amazon sayfasina donun
        driver.navigate().forward();

        // 8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        // 9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //    Yoksa doğru başlığı(Actual Title) yazdırın.
        String actualTitleForAmazon = driver.getTitle();
        String exceptedTitleForAmazon = "Amazon";
        if (actualTitleForAmazon.contains(exceptedTitleForAmazon)){
            System.out.println("Title test PASSED for AMAZON");
        }else {
            System.out.println("Title test FAILED for AMAZON" + "\nActual title : " + actualTitleForAmazon);
        }
        // 10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //    doğru URL'yi yazdırın
        String actualUrlForAmazon = driver.getCurrentUrl();
        String exceptedUrlForAmazon = "https://www.amazon.com/";
        if (actualUrlForAmazon.equals(exceptedUrlForAmazon)){
            System.out.println("Url test PASSED for AMAZON");
        }else {
            System.out.println("Url test FAILED for AMAZON" + "\nActual Url : " + actualUrlForAmazon);
        }

        // 11.Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }

}
