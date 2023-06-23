package tests.day02_WebDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://google.com");

        System.out.println("Ilk sayfa size degeri : "+driver.manage().window().getSize()); // Ilk sayfa size degeri : (945, 1020)
        System.out.println("ilk sayfa position degeri : "+driver.manage().window().getPosition()); // ilk sayfa position degeri : (10, 10)

        driver.manage().window().maximize();
        System.out.println("Maximize size degeri : "+driver.manage().window().getSize()); // Maximize size degeri : (1936, 1056)
        System.out.println("Maximize position degeri : "+driver.manage().window().getPosition()); // Maximize position degeri : (-8, -8)

        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        System.out.println("Fullscreen size degeri : "+driver.manage().window().getSize()); // Fullscreen size degeri : (1920, 1080)
        System.out.println("Fullscreen position degeri : "+driver.manage().window().getPosition()); // Fullscreen position degeri : (0, 0)



        Thread.sleep(3000);
        driver.close();
    }
}
