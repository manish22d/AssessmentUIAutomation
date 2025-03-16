package com.assessment.listeners;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;
import java.util.Arrays;

@Slf4j
public class WebEventListener implements WebDriverListener {

    @Override
    public void beforeGet(WebDriver driver, String url) {
        log.info("Navigating to : {}", url);
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        log.info("Navigated to : " + url);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        log.info("Element found : {}", locator.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        log.info("clicked on: " + element);
    }

    @Override
    public void beforePageLoadTimeout(WebDriver.Timeouts timeouts, Duration duration) {
        log.info("Page Load timeout countdown begins!");
    }


    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        log.info("Keys to send : {}, on element :{}", Arrays.toString(keysToSend), element);
    }

}
