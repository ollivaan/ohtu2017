Feature: User can log in with valid username/password-combination

Scenario: nonexistent user can not login 
Given login is selected
When incorrent username "" and incorrent password "" are given
Then user is not logged in and error message is given2.