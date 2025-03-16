package com.assessment.stepdef;

import com.assessment.pages.AddNewRequestPage;
import com.assessment.pages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ControlAssessmentStepDef {
    LandingPage landingPage;
    AddNewRequestPage addNewRequestPage;

    @Given("user is logged into the control assessment portal")
    public void userIsLoggedIntoTheControlAssessmentPortal() {
        landingPage = new LandingPage();
        landingPage.launchControlPortal();
    }

    @When("user navigates to {string} page")
    public void userNavigatesToPage(String tabName) {
        landingPage.navigateToPage(tabName);
    }

    @When("user selects request type as {string}")
    public void userSelectsRequestTypeAs(String requestType) {
        addNewRequestPage = new AddNewRequestPage();
        addNewRequestPage.selectRequestType(requestType);
    }

    @And("enter request title as {string}")
    public void enterRequestTitleAs(String requestTitle) {
        addNewRequestPage.enterRequestTitle(requestTitle);
    }

    @And("select request channel as {string}")
    public void selectRequestChannelAs(String requestChannel) {
        addNewRequestPage.selectRequestChannel(requestChannel);
    }

    @And("enter initial request date as {string}")
    public void enterInitialRequestDateAs(String initialRequestDate) {
        addNewRequestPage.enterInitialRequestDate(initialRequestDate);
    }

    @And("select request state as {string}")
    public void selectRequestStateAs(String requestState) {
        addNewRequestPage.selectRequestStateTextBox(requestState);
    }

    @And("select request lead as {string}")
    public void selectRequestLeadAs(String requestLead) {
        addNewRequestPage.enterRequestLead(requestLead);
    }

    @Then("user saves new request")
    public void userSavesNewRequest() {
        addNewRequestPage.saveForm();
    }

    @And("verify below error message displayed")
    public void verifyBelowErrorMessageDisplayed() {
        System.out.println(addNewRequestPage.getErrorMsgs());
    }
}