Feature: Search book
  @search_book_successfully @smoke_test
  Scenario Outline: Search book with multiple results
    Given there are books named “Learning JavaScript Design Patterns” and “Designing Evolvable Web APIs with ASP.NET”
    And the user is on the Book Store page
    When the user inputs book name <keys>
    Then all books match with input criteria will be displayed

    Examples:
    |keys      |
    | design   |
    | Design   |
