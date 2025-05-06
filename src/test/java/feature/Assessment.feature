Feature: My feature

@run
  Scenario Outline: Adding user and verify user is added
    Given user is on the homepage
    And user validate the users on the User list Table
    When user add "<First Name>", "<Last Name>","<User Name>","<Password>","<Customer>","<Role>","<Email Address>","<Cellphone>"
    Then  user validate user details "<First Name>","<Last Name>","<User Name>" and validate that username is unique
  Examples:
    | First Name | Last Name | User Name | Password | Customer    | Role     | Email Address     | Cellphone |
    | FName1     | LName1    | User1     | Pass1    | Company AAA | Admin    | admin@mail.com    | 082 555   |
    | FName2     | LName2    | User2     | Pass2    | Company BBB | Customer | customer@mail.com | 083 444     |



