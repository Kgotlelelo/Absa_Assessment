package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import extentReport.Reporting;
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

        /*
        webActions.SendKeysObject(userObj.customer, driver, customer);
        webActions.SendKeysObject(userObj.role, driver, role);
       */

        Thread.sleep(2000);
        if (customer.contains("AAA")){

            driver.findElement(By.xpath("//*[@value='15']")).click();
        } else if (customer.contains("BBB")) {

            driver.findElement(By.xpath("//*[@value='16']")).click();
        }

        Thread.sleep(2000);
        if (role.contains("Admin")){

            WebElement dropdownElementAdmin = driver.findElement(By.xpath("//*[@name='RoleId']"));

            Select select = new Select(dropdownElementAdmin);
            select.selectByVisibleText("Admin");
           /* Select admin = new Select(dropdownElementAdmin);
            admin.selectByIndex(0);;*/

        } else if (role.contains("Customer")) {

            WebElement dropdownElementCustomer = driver.findElement(By.xpath("//*[@name='RoleId']"));
            Select customers = new Select(dropdownElementCustomer);
           // customers.selectByIndex(0);
            customers.selectByVisibleText("Customer");

        }

        Thread.sleep(2000);
        webActions.SendKeysObject(userObj.email, driver, email);

        Thread.sleep(2000);
        webActions.SendKeysObject(userObj.cell, driver, cell);



        Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@ng-click='save(user)']")).click();
        webActions.ClickObject(userObj.saveBtn, driver);


        node.pass("Details captured successfully",Reporting.CaptureScreenShot(driver));

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



        node.pass("Before validating ",Reporting.CaptureScreenShot(driver));
        Thread.sleep(2000);
        //Validate that user is added
        driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys(userName);

        Thread.sleep(2000);
        List<WebElement> getValue=  driver.findElements(By.xpath("//td[@ng-repeat='column in columns'][1]"));

        if (getValue.size() >=1){
            System.out.println("User found");

            List<WebElement> userNameElements = driver.findElements(By.xpath("//td[@ng-repeat='column in columns'][1]"));
            Set<String> userNames = new HashSet<>();
            boolean allUnique = true;

            for (WebElement userNameElement : userNameElements) {
                String userNameValue = userNameElement.getText();
                if (!userNames.add(userNameValue)) {
                    allUnique = false;
                    System.out.println("Duplicate User Name found: " + userNameValue);
                    node.pass("BDuplicate User Name found ",Reporting.CaptureScreenShot(driver));
                }
            }

            if (allUnique) {
                node.pass("All User Names are unique ",Reporting.CaptureScreenShot(driver));
                System.out.println("All User Names are unique.");
            } else {
                System.out.println("There are duplicate User Names in the table.");
                node.fail("There are duplicate User Names in the table. ",Reporting.CaptureScreenShot(driver));
            }



        }else{
            System.out.println("User not found");
            node.fail("User not found ",Reporting.CaptureScreenShot(driver));

        }
    }
}
