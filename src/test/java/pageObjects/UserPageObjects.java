package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import extentReport.Reporting;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageRepos.UserPageRepo;
import utilities.BaseClass;

import utilities.WebActions;
import utilities.WebUtilities;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserPageObjects extends BaseClass {

   WebActions webActions = new WebActions();

    UserPageRepo userObj;

    public UserPageObjects(WebDriver _driver){
        super();
       this.driver= _driver;
        userObj = new UserPageRepo(driver);
    }


    public void  addBtn( ExtentTest node) throws IOException {

        // validation
        if(userObj.addBtn.isDisplayed()){

            node.pass("Add Button exist",Reporting.CaptureScreenShot(driver));
            webActions.ClickObject(userObj.addBtn,driver);

        }else{
            node.fail("Add Button does not exist ",Reporting.CaptureScreenShot(driver));
        }


      //  driver.findElement(By.xpath("//button[normalize-space()='Add User']")).click();


    }



    public void captureCustomerDetails(String firstName, String lastName, String userName, String password, String customer, String role,String email, String cell, ExtentTest node) throws IOException, InterruptedException {


        Thread.sleep(2000);
        webActions.SendKeysObject(userObj.fistName, driver, firstName);

        Thread.sleep(2000);
        webActions.SendKeysObject(userObj.lastName, driver, lastName);

        Thread.sleep(2000);
        webActions.SendKeysObject(userObj.userName, driver, userName);

        Thread.sleep(2000);
        webActions.SendKeysObject(userObj.password, driver, password);

        if (customer.contains("AAA")){
            webActions.ClickObject(userObj.customerAAA, driver);

        } else if (customer.contains("BBB")) {
            webActions.ClickObject(userObj.customerBBB, driver);
        }

        if (role.contains("Admin")){

            webActions.SelectObject(userObj.role,driver,"Value","2");

        } else if (role.contains("Customer")) {


            webActions.SelectObject(userObj.role,driver,"Value","1");

          /*  WebElement dropdownElementCustomer = driver.findElement(By.xpath("//*[@name='RoleId']"));
            Select customers = new Select(dropdownElementCustomer);
            customers.selectByVisibleText("Customer");*/

        }


        webActions.SendKeysObject(userObj.email, driver, email);


        webActions.SendKeysObject(userObj.cell, driver, cell);

        node.pass("Details captured successfully",Reporting.CaptureScreenShot(driver));
        webActions.ClickObject(userObj.saveBtn, driver);


    }

    public void validateUserOnListTable(ExtentTest node) throws IOException {

       // Validate that you are on the User List Table
        node.pass("Before validation ",Reporting.CaptureScreenShot(driver));
        // validation
        if(userObj.valueInSearch.isDisplayed()){

            node.pass("User List Table is displayed",Reporting.CaptureScreenShot(driver));
            System.out.println("User List Table is displayed.");

        }else{
            node.fail("User List Table is not displayed.",Reporting.CaptureScreenShot(driver));
            System.out.println("User List Table is not displayed.");
        }

    }

    public void validateCustomer(String firstName, String lastName, String userName, ExtentTest node) throws InterruptedException, IOException {

        node.pass("Tbale details Before validating ",Reporting.CaptureScreenShot(driver));

        //Verify user on the correct Page

        //Search using the UserName
        webActions.SendKeysObject(userObj.searchBtn,driver,userName);


        if (userObj.listUserName.size() >=1){

            for (int i = 1; i < userObj.listUserName.size(); i++) {
                 String userNameValue =  userObj.listUserName.get(i).getText();
                //String userNameValue =  userObj.listUserName.get(i).getAttribute("value");

                System.out.println(userNameValue);
                if(userNameValue.equalsIgnoreCase(userName)){
                    node.pass("Correct Username was found ", Reporting.CaptureScreenShot(driver));
                }else {
                    node.fail("unexpected name was found", Reporting.CaptureScreenShot(driver));
                    Assert.fail("No location was found failed");
                }

            }


        }else{
            System.out.println("UserName not found");
            node.fail("User not found ",Reporting.CaptureScreenShot(driver));
            Assert.fail("No username was found failed");
        }
    }
}
