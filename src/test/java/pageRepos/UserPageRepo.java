package pageRepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class UserPageRepo {
    protected WebDriver driver;

    public UserPageRepo(WebDriver _driver){
        this.driver= _driver;
        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    @FindBy(xpath="//*[@name='FirstName']")
    public WebElement fistName;


    @FindBy(xpath="//*[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath="//*[@name='UserName']")
    public WebElement userName;


    @FindBy(xpath="//*[@name='Password']")
    public WebElement password;

    @FindBy(xpath="//*[@value='15']")
    public WebElement customer;

    @FindBy(xpath="//*[@value='15']")
    public WebElement customerAAA;

    @FindBy(xpath="//*[@value='15']")
    public WebElement customerBBB;


    @FindBy(xpath="//*[@name='RoleId']")
    public WebElement role;

    @FindBy(xpath="//*[@name='Email']")
    public WebElement email;

    @FindBy(xpath="//*[@name='Mobilephone']")
    public WebElement cell;

    /*@FindBy(xpath = "//button[@type='add']")
    public WebElement addBtn;*/
    @FindBy(xpath = "//button[normalize-space()='Add User']")
    public WebElement addBtn;



    //search
    @FindBy(xpath="//*[@placeholder='Search']")
    public WebElement searchBtn;

    //search
    @FindBy(xpath="//td[@ng-repeat='column in columns'][1]")
    public WebElement valueInSearch;


    //Validation
    @FindBy(xpath="//*[@ng-click='save(user)']")
    public WebElement saveBtn;



    @FindBy(xpath = "//td[@ng-repeat='column in columns'][1]")
    public List<WebElement> listUserName;

}
