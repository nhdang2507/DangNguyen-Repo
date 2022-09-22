Feature: Add book
  @Add_book_successfully @smoke_test
  Scenario Outline: Add book to your collection
    Given the user logs into application
    And the user is on Book Store page
    When the user selects a book <bookName>
    And the user clicks on Add To Your Collection
    Then an alert Book added to your collection. is shown
    And book <bookName> is shown in your profile
    Examples:
    |       bookName         |
    |   Git Pocket Guide     |