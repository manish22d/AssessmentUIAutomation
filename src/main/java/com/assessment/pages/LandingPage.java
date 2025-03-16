package com.assessment.pages;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


@Slf4j
public class LandingPage extends BasePage {
    @FindBy(css = "div.login input[id=':r0:']")
    WebElement emailTxtBox;

    @FindBy(css = "div.login input[id=':r1:']")
    WebElement pwdTxtBox;
    @FindBy(css = "button.login__submit")
    WebElement signInBtn;

    public LandingPage launchControlPortal() {
        StopWatch watch = StopWatch.createStarted();
        driver.navigate().to(property.getProperty("app.url"));
        waitForPageToLoad();
        pause(3);
        watch.stop();
        log.info("page loaded in {} sec", watch.getTime());
        try {
            driver.switchTo().alert().dismiss();
            System.out.println("alter Present. Performing login");
            performLogin();
        } catch (NoAlertPresentException e) {
            System.out.println("no alter Present");
        }
        return this;
    }

    private void performLogin() {
        String user = property.getProperty("app.id");
        String cred = property.getProperty("app.cred");
        highlightAndFillText(emailTxtBox, user);
        highlightAndFillText(pwdTxtBox, cred);
        highlightAndClick(signInBtn);
        waitForPageToLoad();
    }

    public void navigateToPage(String tabName) {
        WebElement ele = driver.findElement(By.xpath("//p[contains(.,'" + tabName + "')]/parent::a"));
        wait.until(elementToBeClickable(ele));
        highlightAndClick(ele);
        waitForPageToLoad();
    }
}
