Feature: Delete book
  @Delete_book_successfully @smoke_test
  Scenario Outline: Add book to your collection
    Given there is a book named Git Pocket Guide <isbn>
    And the user logs into the application
    And the user is on the Profile page
    When the user search book <bookName>
    And the user clicks on Delete icon
    And the user clicks on OK button
    And the user clicks on OK button of alert Book deleted.
    And the book <bookName> is not shown
    Examples:
      |bookName                |      isbn      |
      |   Git Pocket Guide     |  9781449325862 |