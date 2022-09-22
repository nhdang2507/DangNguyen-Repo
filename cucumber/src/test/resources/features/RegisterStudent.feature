Feature: Register student
  @register_student_successfully
  Scenario Outline: Register student form with all fields successfully
    Given the user is on Student Registration Form
    When the user input valid data into all fields
      |First Name |Last Name  |Email     |Gender  |Mobile    |Date of Birth|Subjects  |Hobbies  |Picture  |Current Address|State  |City  |
      |<firstName>|<lastName> |<email>   |<gender>|<mobile>  |<dateOfBirth>|<subjects>|<hobbies>|<picture>|<address>      |<state>|<city>|
    And the user clicks on Submit button
    Then a successful message 'Thanks for submitting the form' is shown
    And all information of the student form is shown correctly

    Examples:
      | firstName | lastName    | email           |gender|mobile    |dateOfBirth      |subjects       |hobbies    |             picture                  |address  |state  |city   |
      |    dang   |   nguyen    | nhdang@gmail.com|Male  |0923423433| 25 October 2000 |  Hindi, Maths | Reading   |  /src/test/resources/testdata/ava.jpg|SAI GON  |  NCR  | Delhi |
      |    dang   |   nguyen    |                 |Male  |0923423433|                 |               |           |                                      |         |       |       |
