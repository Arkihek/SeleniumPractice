package tests.day03_Webelements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_Locators {
    public static void main(String[] args) throws InterruptedException {

        /*
            Locator : Verdigimiz locate bilgisini kullanarak
                      driver`in locate etmesini saglayan hazir method`lardir

            Selenium`da 8 adet Locator vardir
                - ilk 6 tanesi webelementi olusturan HTML kodun icerigine baglidir
                    1- By.id
                    2- By.name
                    3- By.classname
                    4- By.linkText
                    5- By.partialLinkText
                    6- By.tagName
                - son 2 tanesi ise her turlu webelement icin kullanilabilir
                    7- By.xPath (Yuzde 80 bunu kullaniriz)
                    8- By.cssSelector
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // arama kutusuna nutella yazip aratalim
        WebElement aramaKutusuElementi = driver.findElement(By.name("field-keywords"));
        aramaKutusuElementi.sendKeys("Nutella");
        aramaKutusuElementi.submit();

        // gosterilen urun resimlerinin 10`dan fazla oldugunu test edin
        // Locator stratejisi olarak By.className secildiginde
        // class attribute`unun degeri space iceriyorsa
        // Locate islemi basarisiz olabilir
        // List<WebElement> urunIsimElementleriList = driver.findElements(By.className("a-size-base-plus a-color-base a-text-normal"));

        List<WebElement> urunIsimElementleriList = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));

        if (urunIsimElementleriList.size() > 10) {
            System.out.println("Listelenen urun sayisi testi PASSED");
        } else {
            System.out.println("Listelenen urun sayisi testi FAILED");
        }
        // System.out.println(urunIsimElementleriList.size());

        // 5. urun ismini yazdirin ve ismin nutella icerdigini test edin
        String besinciUrunIsmi = urunIsimElementleriList.get(4).getText();
        String expectedIcerik = "Nutella";
        System.out.println("5. urun ismi : " + besinciUrunIsmi);
        if (besinciUrunIsmi.contains(expectedIcerik)) {
            System.out.println("5. urun ismi 'Nutella' testi PASSED");
        } else {
            System.out.println("5. urun ismi 'Nutella' testi FAILED");
        }


        Thread.sleep(3000);
        driver.close();

    }
}
