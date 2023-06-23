package tests.practice.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");
        //2 ) Nurse 3 farkli relative locator ile locate edin
        WebElement fireman = driver.findElement(By.id("frmn_thumb"));
        WebElement doctor = driver.findElement(By.id("dr_thumb"));
        WebElement seller = driver.findElement(By.id("sll_thumb"));
        WebElement policeMan = driver.findElement(By.id("pol_thumb"));

        WebElement nurse = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(fireman));
        WebElement nurse2 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(seller));
        WebElement nurse3 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(doctor).toLeftOf(policeMan));


        //3 ) Relative locator’larin dogru calistigini test edin
        if (nurse.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Ilk locator Test PASSED");
        }else {
            System.out.println("Ilk locator Test FAILED");
        }
        System.out.println("-----------------------------");
        if (nurse2.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Ikinci locator Test PASSED");
        }else {
            System.out.println("Ikinci locator Test FAILED");
        }
        System.out.println("-------------------------------");
        if (nurse3.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Ucuncu locator Test PASSED");
        }else {
            System.out.println("Ucuncu locator Test FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
