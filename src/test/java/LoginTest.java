import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;


public class LoginTest {

    WebDriver driver;


@Before

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

@After
    public void closeDriver(){
    //driver.quit();
    driver.close();  // using .close causes more tests to Fail due to loading time***
        System.out.println("Thats all the tests we had! ");
    }

    //  tests -----------------

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
        driver.findElement(By.cssSelector("button#send2")).click();
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
        driver.findElement(By.cssSelector("#header-account a[title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("button#send2")).click();
//        driver.close();
    }

    @Test
    public void loginWithInvalidEmail(){

//        driver.manage().window().maximize();
//        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account a[title=\"Log In\"]")).click();
        driver.findElement(By.id("email")).sendKeys("cosminfasttrackit.org");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("button#send2")).click();

    }

    @Test
    public void loginWithoutCredentialsTest(){

        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account a[title=\"Log In\"]")).click();
        driver.findElement(By.cssSelector("button#send2")).click();

    }

    @Test
    public void loginWithoutEmailTest(){

        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account a[title=\"Log In\"]")).click();
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.cssSelector("button#send2")).click();


        WebElement warningElem = driver.findElement(By.id("advice-required-entry-pass"));
        String warningTxt = warningElem.getText();
        Assert.assertEquals( "This is a required field.", warningTxt);
        Assert.assertTrue(warningElem.isDisplayed());


    }

    @Test
    public void loginWithoutPassTest(){

        driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("#header-account a[title=\"Log In\"]")).click();



        driver.findElement(By.id("email")).sendKeys("cosmin@fasttrackit.org");
        driver.findElement(By.cssSelector("button#send2")).click();

        WebElement invalidElem;
        invalidElem = driver.findElement(By.cssSelector(".error-msg span"));
        String invalidTxt = invalidElem.getText();
        Assert.assertEquals( "Invalid login or password.", invalidTxt);
        Assert.assertTrue(invalidElem.isDisplayed());

        WebElement warningElem = driver.findElement(By.id("advice-required-entry-pass"));
        String warningTxt = warningElem.getText();
        Assert.assertEquals( "This is a required field.", warningTxt);
        Assert.assertTrue(warningElem.isDisplayed());

        //fail:
        //Assert.assertEquals( "This %^#&@.", warningTxt);
    }

@Test
    public void loginForgotPassword(){

    driver.findElement(By.cssSelector(".account-cart-wrapper .skip-account")).click();
    driver.findElement(By.cssSelector("#header-account a[title=\"Log In\"]")).click();

    driver.findElement(By.cssSelector("a.f-left")).click();
//    #email_address
    WebElement emailInput = driver.findElement(By.id("email_address"));
    Assert.assertTrue(emailInput.isDisplayed());

}

}
