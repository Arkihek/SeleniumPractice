package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
            ImplicitlyWait Selenium`dan gelen dinamik bir beklemedir. Gerektigi kadar bekletir.
            Sayfanin yuklenmesi veya islem yapilacak web elementlerin bulunmasi icin
            beklenecek MAXIMUM sureyi belirler

            Driver bu sure dolana kadar verilen gorevin yapilip yapilmadigini kontrol eder
            bu sure icerisinde gorev yapilamazsa
            Exception firlatip calismayi durdurur
         */

        driver.get("https://wisequarter.com");

        System.out.println("Baslangic konumu : "+driver.manage().window().getPosition()); // Baslangic konumu : (-8, -8)
        System.out.println("Baslangic size : " + driver.manage().window().getSize()); // Baslangic size : (1936, 1056)

        driver.manage().window().setSize(new Dimension(1400,1000));
        driver.manage().window().setPosition(new Point(520,0));

        System.out.println("Degisen yeni konumu : "+driver.manage().window().getPosition()); // Degisen yeni konumu : (110, 220)
        System.out.println("Degisen yeni size : " + driver.manage().window().getSize()); // Degisen yeni size : (1400, 1000)

        Thread.sleep(3000);
        // Java`dan gelir seleniumdan degil (Thread) ve yazdigimiz sure miktarinca kodlari bekletir
        driver.close();
    }
}
