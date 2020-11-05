Feature: search books

  Background: login to libraryCT
    When user is on login page
    And  user logs in as librarian


  Scenario: search books by Name
    When user clicks on books tab
    And  user enters book "The little Prince"
    Then user verifies search result by name "The little Prince"