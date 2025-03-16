package com.assessment.core;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public final class WebDriverManager {

    static WebDriver driver = null;

    public static void initializeWebDriver() {
        log.info("initialising Web driver....");
        WebDriverFactory wf = new WebDriverFactory();
        driver = wf.initializeDriver();
        driver.manage().window().maximize();
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            initializeWebDriver();
        }
        return driver;
    }

    public static void shutdownDriver() {
        log.info("shutting down Web driver....");
        if (driver != null) {
            driver.quit();
        }
    }
}
