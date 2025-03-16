package com.assessment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AddNewRequestPage extends BasePage {
    @FindBy(id = "requestTypeId")
    WebElement requestTypeIdTextBox;

    @FindBy(id = "requestTitle")
    WebElement requestTitleTextBox;

    @FindBy(id = "requestChannel")
    WebElement requestChannelTextBox;

    @FindBy(id = "initialRequestDate")
    WebElement initialRequestDateTextBox;

    @FindBy(id = "requestState")
    WebElement requestStateTextBox;

    @FindBy(id = "requestLead")
    WebElement requestLeadTextBox;
    @FindBy(tagName = "mat-error")
    List<WebElement> matErrorMsg;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    public void selectRequestType(String requestType) {
        selectFromDropdown(requestTypeIdTextBox, requestType);
    }

    public void enterRequestTitle(String requestTitle) {
        highlightAndFillText(requestTitleTextBox, requestTitle);
    }

    public void selectRequestChannel(String requestChannel) {
        selectFromDropdown(requestChannelTextBox, requestChannel);
    }

    public void enterInitialRequestDate(String requestTypeId) {
        highlightAndFillText(initialRequestDateTextBox, requestTypeId);
    }

    public void selectRequestStateTextBox(String requestState) {
        selectFromDropdown(requestStateTextBox, requestState);
    }

    public void enterRequestLead(String requestLead) {
        selectFromDropdown(requestLeadTextBox, requestLead);
    }

    public void saveForm() {
        wait.until(elementToBeClickable(saveBtn));
        saveBtn.click();
    }

    public List<String> getErrorMsgs() {
        return matErrorMsg.stream().filter(WebElement::isDisplayed).map(WebElement::getText).toList();
    }


}
