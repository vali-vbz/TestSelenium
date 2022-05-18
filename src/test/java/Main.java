import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) {
        System.out.println("Proiect Maven::::");

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.google.com");

        driver.get("http://testfasttrackit.info/selenium-test/");

       driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();

        System.out.println("opa Maven:::: " +driver.getCurrentUrl());

        LoginTest t1 = new LoginTest();
        t1.loginWithValidCredentialsTest();


        boolean toClose= false;
        if (toClose) {
            driver.close();
        }
    }

}
