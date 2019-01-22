import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",  MainClass.class.getResource("chromedriver").getPath());

        WebDriver driver = new ChromeDriver(new ChromeOptions().setHeadless(true));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://google.com");

        driver.findElement(By.name("q")).sendKeys("ala bala");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("scrFile1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get("https://www.veloteca.ro/");
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
