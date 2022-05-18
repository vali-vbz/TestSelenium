import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    WebDriver driver;


@Before

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }


@Test
    public void loginWithValidCredentialsTest(){
//        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account a[title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
//        driver.close();
    }

    @Test
    public void loginWithInvalidPasswordTest(){
//        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
//        driver.close();
    }

    @Test
    public void loginWithInvalidEmail(){

//        driver.manage().window().maximize();
//        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("cosminfasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.close();
    }

    @Test
    public void loginWithoutCredentialsTest(){

        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.close();
    }




    @After
    public void closeDriver(){
        driver.close();
        System.out.println("Thats all the tests we had! ");
    }

}
