package tests.day03_Webelements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AmazonAramaTesti {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // Arama cubuguna nutella yazdirip aratin

        /*
            Bir webelement`i kullanabilmek icin
            Oncelikle o webelementi driver`in bulabilmesi icin Locate etmeliyiz
            Yani yerini tarif edecek bilgiye ulasmaliyiz.

            Amazon arama cubugu icin bu bilginin id = twotabsearchtextbox oldugunu
            amazon sayfasinda arastirma yaparak bulduk

            Sonra bu locate bilgisini kullanarak,
            web sayfasinda o elemti bulup, bu class`da o webelementi kullabilmek icin kaydedecek
            bir hazir method` ihtiyacimiz var

         */

        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));

        /*
            Bu satirda 3 islem yapiliyor
            1- Locate islemi : id = twotabsearchtextbox oldugunu bulduk
            2- Bu locate`i kullanarak istedigimiz arama kutusunu bize getirecek method
               driver.findElement(Locate stratejisi)
            3- Locate edip, findElement ile buldugumuz web elementi
               icinde bulundugumuz class`da kullanabilmek icin
               bir WebElement objesine ATAMAK
         */

        aramaKutusuElementi.sendKeys("Nutella");
        aramaKutusuElementi.submit();
        // Arama sonuclarinin Nutella icerdigini test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("sg-col-inner"));
        /*
        System.out.println(aramaSonucElementi);
        aramaSonucElementi objesini bir WebElementi olarak olusturduk
        WebElement bir primitive data turu olmadigindan
        direk yazdirmak istersek referansini yazdirir
         */
        System.out.println(aramaSonucElementi.getText());

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = aramaSonucElementi.getText();

        if (actualSonucYazisi.contains(expectedIcerik)){
            System.out.println("Nutella arama testi PASSED");
        }else {
            System.out.println("Nutella arama testi FAILED");
        }


        Thread.sleep(5000);
        driver.close();


    }
}
