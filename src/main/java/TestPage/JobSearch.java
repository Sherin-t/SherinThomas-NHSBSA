package TestPage;

import org.testng.Assert;

import BasePage.BaseApp;

public class JobSearch extends BaseApp{

    String what = "(//input[@class='nhsuk-input nhsuk-u--width-full'])[1]";
    String where ="(//input[@class='nhsuk-input nhsuk-u--width-full'])[2]";
    String whereOption = "//li[text()='Newcastle Business Park, Newcastle Upon Tyne']";
    String distance = "(//select[contains(@class,'nhsuk-select nhsuk-grid-column-full')])[1]";
    String distance5miles = "//option[text()='+5 Miles']";
    String searchButton = "//input[@class='nhsuk-button']";
    String clearSearch = "//a[contains(text(),'Clear filters')]";
    String allLocation ="//option[text()[normalize-space()='All locations']]";
    String moreOption = "//a[contains(text(),'More search options')]";
    String fewerOption = "//a[contains(text(),'Fewer search options')]";
    String jobReference = "(//input[@class='nhsuk-input nhsuk-u--width-full'])[2]";
    String employer = "//input[@data-test='search-employer-input']";
    String payRange = "(//select[contains(@class,'nhsuk-select nhsuk-grid-column-full')])[2]";
    String payRange0to10 = "//option[text()='£0 to £10,000']";
    String sortByDate = "(//select[@name='sort'])[1]";
    String sortByNewDate = "//option[text()='Date Posted (newest)']";
    String resultTittle = "//a[contains(text(),'Principal Data Scientist')]";
    String closingDate = "(//strong[@class='nhsuk-u-font-weight-bold'])[2]";
    String acceptCookie = "//button[@id='accept-cookies']";
   
        public void NavigateToJobSite(){
            Elementappear(acceptCookie);
                MoveToElement(acceptCookie);
                click(acceptCookie);
    
        }
        public void JobFilters()throws InterruptedException{
            Thread.sleep(5000);
            Elementappear(what);
            MoveToElement(what);
            typeIn(what, "Principal Data Scientist");
            MoveToElement(where);
            Thread.sleep(3000);
            typeIn(where, "Newcastle Business Park, Newcastle Upon Tyne");
            Thread.sleep(3000);
            MoveToElement(whereOption);
            click(whereOption);
            Thread.sleep(3000);
            MoveToElement(clearSearch);
            click(clearSearch);
    
            Assert.assertEquals(isDisplayed(allLocation), true);
            Thread.sleep(5000);
            MoveToElement(what);
            typeIn(what, "Principal Data Scientist");
            Thread.sleep(5000);
            MoveToElement(where);
            typeIn(where, "Newcastle Business Park, Newcastle Upon Tyne");
            MoveToElement(whereOption);
            click(whereOption);
            MoveToElement(clearSearch);
            MoveToElement(distance);
            click(distance);
            Thread.sleep(5000);
            MoveToElement(distance5miles);
            click(distance5miles);
            MoveToElement(distance5miles);
            click(distance5miles);
            MoveToElement(moreOption);
            click(moreOption);
            Assert.assertEquals(isDisplayed(fewerOption), true);
            Thread.sleep(5000);
            MoveToElement(jobReference);
            typeIn(jobReference, "076-ATH-CFA008-B");
            MoveToElement(employer);
            typeIn(employer, "NHS Counter Fraud Authority");
            MoveToElement(distance);
            click(payRange);
            MoveToElement(distance5miles);
            click(payRange0to10);
            MoveToElement(searchButton);
            click(searchButton);
    
        }
        public void JobSearchList()throws InterruptedException{
        Thread.sleep(5000);
        Assert.assertEquals(isDisplayed(resultTittle), true);

        String actualText = getText(resultTittle);

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
        MoveToElement(sortByDate);
        click(sortByDate);
        MoveToElement(sortByNewDate);
        click(sortByNewDate);
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
    
