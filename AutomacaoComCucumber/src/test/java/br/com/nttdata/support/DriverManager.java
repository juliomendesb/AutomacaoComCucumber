package br.com.nttdata.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    public static WebDriver driver;
    public static ChromeOptions options;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void initDriver(){
        WebDriverManager.chromedriver().setup();
        options.addArguments("--force-device-scale-factor=0.85");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}
