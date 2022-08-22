package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class imdbPage {

    public imdbPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//label[@id='imdbHeader-navDrawerOpen--desktop']")
    public WebElement menuDropDownButton;

    @FindBy(xpath = "//span[text()='Oscars']")
    public WebElement oscarsSection;

    @FindBy(xpath = "//a[text()='1929']")
    public WebElement yearSection;

    @FindBy(xpath = "//a[text()='Şarlo Sirkte']")
    public WebElement movie;

    @FindBy(xpath = "//div[text()='Honorary Award']")
    public WebElement honoryAwardSection;

    @FindBy(xpath = "//li[@data-testid='title-pc-principal-credit']")
    public WebElement director;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[2]")
    public WebElement writer;

    @FindBy(xpath = "(//li[@data-testid='title-pc-principal-credit'])[3]")
    public WebElement stars;

    @FindBy(xpath = "//a[@id='home_img_holder']")
    public WebElement imbdButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBar;

    @FindBy(xpath = "(//a[@class='sc-d2740ffb-0 kqjPkC searchResult searchResult--const'])[1]")
    public WebElement searchBarFirstResult;

    @FindBy(xpath = "//h3[text()='Photos']")
    public WebElement photosButton;

    @FindBy(xpath = "//div[text()='Best Writing, Adaptation']")
    public WebElement bestWritingAdaptationSection;

    @FindBy(xpath = "(//a[text()='The Jazz Singer'])[1]")
    public WebElement theJazzSinger;




}
