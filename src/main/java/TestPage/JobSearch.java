package TestPage;

import org.testng.Assert;

import BasePage.BaseApp;

public class JobSearch extends BaseApp{

    String what = "(//input[@class='nhsuk-input nhsuk-u--width-full'])[1]";
    String where ="(//input[@class='nhsuk-input nhsuk-u--width-full'])[2]";
    String whereOption = "//ul[@role='listbox']//li[1]";
    String distance = "(//select[contains(@class,'nhsuk-select nhsuk-grid-column-full')])[1]";
    String distance5miles = "//option[text()='+5 Miles']";
    String SearchButton = "//input[@class='nhsuk-button']";
    String ClearSearch = "//a[contains(text(),'Clear filters')]";
    String allLocation ="//option[text()[normalize-space()='All locations']]";
    String MoreOption = "//a[contains(text(),'More search options')]";
    String fewerOption = "//a[contains(text(),'Fewer search options')]";
    String JobReference = "(//input[@class='nhsuk-input nhsuk-u--width-full'])[2]";
    String Employer = "//input[@data-test='search-employer-input']";
    String PayRange = "(//select[contains(@class,'nhsuk-select nhsuk-grid-column-full')])[2]";
    String PayRange0to10 = "//option[text()='£0 to £10,000']";
    String SortByDate = "(//select[@name='sort'])[1]";
    String SortByNewDate = "//option[text()='Date Posted (newest)']";
    String ResultTittle = "//a[contains(text(),'Principal Data Scientist')]";
    String closingDate = "(//strong[@class='nhsuk-u-font-weight-bold'])[2]";
    String acceptCookie = "//button[@id='accept-cookies']";
   
        public void NavigateToJobSite(){
            Elementappear(acceptCookie);
                MoveToElement(acceptCookie);
                click(acceptCookie);
    
        }
        public void JobFilters(String Title, String Location,String jobref, String employer)throws InterruptedException{
            Thread.sleep(5000);
            Elementappear(what);
            MoveToElement(what);
            typeIn(what, "Principal Data Scientist");
            MoveToElement(where);
            typeIn(where, "Newcastle Business Park, Newcastle Upon Tyne");
            MoveToElement(whereOption);
            click(whereOption);
            Thread.sleep(3000);
            MoveToElement(ClearSearch);
            click(ClearSearch);
    
            Assert.assertEquals(isDisplayed(allLocation), true);
            Thread.sleep(5000);
            MoveToElement(what);
            typeIn(what, "Principal Data Scientist");
            Thread.sleep(5000);
            MoveToElement(where);
            typeIn(where, "Newcastle Business Park, Newcastle Upon Tyne");
            MoveToElement(whereOption);
            click(whereOption);
            MoveToElement(ClearSearch);
            MoveToElement(distance);
            click(distance);
            Thread.sleep(5000);
            MoveToElement(distance5miles);
            click(distance5miles);
            MoveToElement(distance5miles);
            click(distance5miles);
            MoveToElement(MoreOption);
            click(MoreOption);
            Assert.assertEquals(isDisplayed(fewerOption), true);
            Thread.sleep(5000);
            MoveToElement(JobReference);
            typeIn(JobReference, "076-ATH-CFA008-B");
            MoveToElement(Employer);
            typeIn(Employer, "NHS Counter Fraud Authority");
            MoveToElement(distance);
            click(PayRange);
            MoveToElement(distance5miles);
            click(PayRange0to10);
            MoveToElement(SearchButton);
            click(SearchButton);
    
        }
        public void JobSearchList()throws InterruptedException{
        Thread.sleep(5000);
        Assert.assertEquals(isDisplayed(ResultTittle), true);

        String actualText = getText(ResultTittle);

        // Expected string to verify
        String expectedText = what;

        // Verify the text
        if (actualText.equals(expectedText)) {
            System.out.println("Sorting for job search is successfull!");
        } else {
            System.out.println("Sorting for job search is failed!");
        }

    }
       public void SortByLatestDate() throws InterruptedException{
        Thread.sleep(5000);
        MoveToElement(SortByDate);
        click(SortByDate);
        MoveToElement(SortByNewDate);
        click(SortByNewDate);
        Assert.assertEquals(isDisplayed(closingDate), true);

        String actualText = getText(closingDate);

        // Expected string to verify
        String expectedText = what;

        // Verify the text
        if (actualText.equals(expectedText)) {
            System.out.println("Sorting for job search is successfull!");
        } else {
            System.out.println("Sorting for job search is failed!");
        }

       }
    }
    
