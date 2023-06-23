package tests.day03_Webelements_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) throws InterruptedException {

        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElementleriList = driver.findElements(By.className("panel-heading"));

        // 4- Category bolumunde 3 element oldugunu test edin
        int expectedCategoryCount = 3;
        int actualCategoryCount = categoryElementleriList.size();

        if (actualCategoryCount == expectedCategoryCount) {
            System.out.println("Category count test is PASSED");
        } else {
            System.out.println("Category count test is FAILED");
        }

        // 5- Category isimlerini yazdirin
        /*
            System.out.println(categoryElementleriList.);

            Biz bir listeyi direkt olarak yazdirabiliriz
            ANCAK
            bu liste webelementler icerdigi icin direkt olarak yazdirmak istersek
            bize 3 tane referans degeri yazdirir

            WebElementleri direkt yazdiramayacagimiz icin bir for-each loop
            kullanarak her bir WebElement`i alip onun uzerindeki text`i yazdirmaliyiz
         */

        for (WebElement eachElement : categoryElementleriList
        ) {
            System.out.println(eachElement.getText());
        }

        // 6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();

    }
}
