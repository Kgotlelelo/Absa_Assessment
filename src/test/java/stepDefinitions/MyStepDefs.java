package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.UserPageObjects;
import utilities.BaseClass;


import java.io.IOException;



public class MyStepDefs extends BaseClass {
    UserPageObjects userPageObjects;
    @Given("^User launches a browser and navigates to the webpage$")
    public void userLaunchesABrowserAndNavigatesToTheWebpage() throws Exception {

        System.out.println("Launching the browser");
    }

    @Given("^user is on the homepage$")
    public void userIsOnTheHomepage() throws Exception {
        System.out.println("Launching the browser");
        launchbrowser();
         userPageObjects = new UserPageObjects(driver);
        userPageObjects.addBtn(node);
    }

    @When("^user add \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void userAddAnd(String firstName, String lastName, String userName, String password, String customer, String role, String email, String cell) throws IOException, InterruptedException {
        userPageObjects.captureCustomerDetails(firstName,lastName,userName,password,customer,role,email,cell, node);
    }

    @And("^user validate user details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and validate that username is unique$")
    public void userValidateUserDetailsAnd(String firstName, String lastName, String userName) throws InterruptedException, IOException {

        userPageObjects.validateCustomer(firstName,lastName,userName,node);
        System.out.println("Validated");
    }

    @Given("^user validate the users on the User list Table$")
    public void userValidateTheUsersOnTheUserListTable() throws IOException {

        userPageObjects.validateUserOnListTable(node);
        System.out.println("Verified");
    }

    @After
    public void tearDown(){
        driver.close();
        repo.flush();
        System.out.println("Closing the browser and report");
    }


}
