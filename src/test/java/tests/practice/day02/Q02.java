package tests.practice.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {
    public static void main(String[] args) throws InterruptedException {


        // 1-Driver oluşturalim
        // 2-Java class'imiza chnomedriver. exetyi tanitalim
        // 3-Driver'in tum ekranı kaplamasini sagu ayalim
        // 4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
        //  Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10809));


        // 5-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.navigate().to("http://www.babayigit.net/murat/testpage.html");

        // 6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        // alanlarına gerekli bilgileri yazsın
        driver.findElement(By.xpath("//input[@id='ad']")).sendKeys("Ihsan");
        driver.findElement(By.xpath("//input[@id='soyad']")).sendKeys("Yilmaz");
        driver.findElement(By.xpath("//input[@id='yas']")).sendKeys("28");
        driver.findElement(By.xpath("//input[@id='meslek']")).sendKeys("SDET");
        driver.findElement(By.xpath("//input[@id='dogum_yeri']")).sendKeys("Ordu");
        driver.findElement(By.xpath("//input[@id='mezun_okul']")).sendKeys("Anadolu Unv");
        driver.findElement(By.xpath("//input[@id='cocuk_sayisi']")).sendKeys("0");

        // 7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        // 8- All information was entered correctly.. yazısının göründüğünü test etsin ve test sonucunu yazdirsin
        WebElement textElementi = driver.findElement(By.id("uyari"));
        if (textElementi.isDisplayed()) {
            System.out.println(textElementi.getText() + " goruntulendi. Test PASSED");
        } else {
            System.out.println("Yazi goruntulenemedi test FAILED");
        }
        // 9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//input[@type='reset']")).click();
        // 10- Manuel olarak temizlendiğini görecek kadar beklesin
        Thread.sleep(3000);
        // 11- Sayfayı kapatsın
        driver.close();
    }

}
