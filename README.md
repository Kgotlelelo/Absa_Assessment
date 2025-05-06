# Absa_Assessment


Tools


# Selenium User List Table Automation

This project automates the process of adding users to a user list table on the Way2Automation website using Java Selenium. It also validates that the User Name values are unique in the table.

used cucmber bbd approach
created a feature file


Feature: My feature
  Background:
    #Given User launches a browser and navigates to the webpage

@run1
  Scenario Outline: Adding user and verify user is added
    Given user is on the homepage
    And user validate the users on the User list Table
    When user add "<First Name>", "<Last Name>","<User Name>","<Password>","<Customer>","<Role>","<Email Address>","<Cellphone>"
    Then  user validate user details "<First Name>","<Last Name>","<User Name>" and validate that username is unique
  Examples:
    | First Name | Last Name | User Name | Password | Customer    | Role     | Email Address     | Cellphone |
    | FName1     | LName1    | User1     | Pass1    | Company AAA | Admin    | admin@mail.com    | 082 555   |
    | FName2     | LName2    | User2     | Pass2    | Company BBB | Customer | customer@mail.com | 083 444     |



This class performs the following actions:

Navigates to the specified URL.
Validates the presence of the User List Table.
Clicks the "Add User" button.
Adds users with unique User Names.
Ensures that the users are added to the list.

## Prerequisites

- Java Development Kit (JDK) installed
- Selenium WebDriver library
- ChromeDriver/Edge executable
- Maven (for dependency management)

## Setup

1. **Clone the repository**:
==
Install dependencies: If you are using Maven, add the following dependencies to your pom.xml:

<dependencies>
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>4.0.0</version>
 </dependency>
</dependencies>

******************************Web*****************************************

Validate unique User Names: Execute the ValidateUniqueUserNames class to ensure that User Names are unique



Code Overview
AddUser.java
This class performs the following actions:

Navigates to the specified URL.
Validates the presence of the User List Table.
Clicks the "Add User" button.
Adds users with unique User Names.
Ensures that the users are added to the list.
ValidateUniqueUserNames.java
This class performs the following actions:

Navigates to the specified URL.
Validates the presence of the User List Table.
Extracts User Name values from the table.
Checks for duplicates using a HashSet.
Prints a message indicating whether all User Names are unique or if there are duplicates.
Contributing
Feel free to submit issues or pull requests if you have any improvements or bug fixes.


******************************api*****************************************


# Java API Project

This project uses API to perform the following calls                ******* jave claesses namett that to perfom the following*******


o Perform an API request to produce a list of all dog breeds. (Diagram 1)         ******* DogBreedsAPI.java*******
o Using code, verify “retriever” breed is within the list. (Diagram 2)                  ******* CheckRetreiver.java*******
o Perform an API request to produce a list of sub-breeds for “retriever”. (Diagram 3)     ******* RetreiverSubBreed.java*******
o Perform an API request to produce a random image / link for the sub-breed “golden” (Diagram 4)    ******* GoldenRetrieverImage.java*******

diagram 1
![image](https://github.com/user-attachments/assets/a7396e11-6ae5-4086-8113-db66b6db9620)

diagram 2
![image](https://github.com/user-attachments/assets/3f707740-e3b2-40e3-b21b-8c0da991bca6)

diagram 3
![image](https://github.com/user-attachments/assets/9e22f581-0651-4ef9-8137-dd074926d474)

diagram 4
![image](https://github.com/user-attachments/assets/d0b3f87a-20d6-4973-9fdb-dad54c43aa13)


## Installation


**Clone the repository**:
```


API Endpoints
GET /api/items
Retrieve a list of dogs.

Request:


Both Web and API

Extent reporting
path  for web report
.\Absa_Assessment\reporting\webReporting\web_automation2025_04_23_16_09_07.html
path for api report
e.g
.\Absa_Assessment\reporting\apiReporting\api_automation2025_04_23_16_09_07.html

Contributing
Feel free to submit issues or pull requests if you have any improvements or bug fixes.

Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes.
Commit your changes (git commit -m 'Add some feature').
Push to the branch (git push origin feature-branch).
Open a pull request.

License
This project is licensed under the MIT License. See the LICENSE file for details. 
