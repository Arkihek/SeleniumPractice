package tests.day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        // 3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButtonElementi =  driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButtonElementi.isDisplayed()){
            System.out.println("Delete butonu gorunme testi PASSED");
        } else {
            System.out.println("Delete butonu gorunme testi FAILED");
        }
        // 4- Delete tusuna basin
        deleteButtonElementi.click();
        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        // WebElement addRemoveVeYaziElementi = driver.findElement(By.xpath("//h3")); -- Bu sekilde de olur
        WebElement addRemoveVeYaziElementi = driver.findElement(By.tagName("h3"));
        if (addRemoveVeYaziElementi.isDisplayed()){
            System.out.println("Add Remove gorunme testi PASSED");
        }else {
            System.out.println("Add Remove gorunme testi FAILED");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
