package StepDefinition;

import BasePage.BaseApp;
import TestPage.JobSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobSearchPage extends BaseApp {

	public JobSearch Home;

    

    @Given("^I am a job seeker on the NHS Jobs website$")
    public void validatejobsearchpage() throws InterruptedException {
    	Home= new JobSearch();
        Home.NavigateToJobSite();
    	
    	
    }

    @When("^I input my preferences into the Search functionality$")
    public void enter_usernameandpassword(String What, String Where,String jobref, String employer ) throws Exception {
    	Home= new JobSearch();
        Home.JobFilters(What, Where,jobref,employer);
    }

    @Then("^I should see a list of jobs matching my preferences$")
    public void Job_MatchingList() throws Exception {

    	Home= new JobSearch();
        Home.JobSearchList();

    }

    @And("^the search results should be sorted by the newest Date Posted$")
    public void verify_Search() throws Exception {

    	Home= new JobSearch();
        Home.SortByLatestDate();


    }
}


