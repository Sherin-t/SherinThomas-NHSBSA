Feature: NHS Jobs Search

@SmokeTest
  Scenario: Search for jobs matching preferences and verify sorting by newest Date Posted
    Given I am a job seeker on the NHS Jobs website
    When I input my preferences into the Search functionality
    Then I should see a list of jobs matching my preferences
    And the search results should be sorted by the newest Date Posted