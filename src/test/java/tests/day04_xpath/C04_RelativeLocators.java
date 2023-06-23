package tests.day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C04_RelativeLocators {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Berlin’i  3 farkli relative locator ile locate edin
        /*
              Berlin Webelementi'nin HTML kodlari
              <img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">

              Normalde locate edip kullanabildigimiz bir webelement icin buna ihtiyac yoktur

              Relative locators, HTML ozelliklerini gordugumuz halde locate EDEMEDIGIMIZ
              bir webelement varsa kullanilir.

              Bu soruda ornek olmasi amaciyla BERLIN elemanini LOCATE EDEMEDIGIMIZI varsayiyoruz

              Bu durumda Berlin webelementininetrafindaki web elementleri locate edip
              Berlin'i onlar uzerinden tarif edecegiz
           */
        //3 ) Relative locator’larin dogru calistigini test edin
        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement sailer = driver.findElement(By.id("pid11_thumb"));
        WebElement bayArea = driver.findElement(By.id("pid8_thumb"));
        WebElement nYC = driver.findElement(By.id("pid3_thumb"));

        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailer));

        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.id("pid7_thumb")).below(nYC).toRightOf(boston));

        WebElement berlin3 = driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).toLeftOf(bayArea));

        // 1. Locator testi icin
        String expectedIdValue = "pid7_thumb";
        String actualIdValue1 = berlin1.getAttribute("id");
        if (actualIdValue1.equals(expectedIdValue)){
            System.out.println("1. Relativ Locator test PASSED");
        }else {
            System.out.println("1. Relativ Locator test FAILED");
        }
        // 2. Locator testi icin
        String actualIdValue2 = berlin2.getAttribute("id");
        if (actualIdValue1.equals(expectedIdValue)){
            System.out.println("2. Relativ Locator test PASSED");
        }else {
            System.out.println("2. Relativ Locator test FAILED");
        }

        // 3. Locator testi icin
        String actualIdValue3 = berlin3.getAttribute("id");
        if (actualIdValue1.equals(expectedIdValue)){
            System.out.println("3. Relativ Locator test PASSED");
        }else {
            System.out.println("3. Relativ Locator test FAILED");
        }
        driver.close();
    }
}
