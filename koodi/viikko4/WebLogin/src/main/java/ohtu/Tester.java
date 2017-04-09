package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();
    }
    public static void failedLogin() {
        
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep123456789101112131415");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();       
        
    }
    public static void newAccount() {
        
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep2");        
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        driver.quit();           
        
    }
    public void newAccountandLogout() {
                WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep2");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep2");        
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
        
        WebElement element2 = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();        
        sleep(2);
   
        element2 = driver.findElement(By.name("logout"));
        sleep(2);
        element2.submit();        
    }

    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
