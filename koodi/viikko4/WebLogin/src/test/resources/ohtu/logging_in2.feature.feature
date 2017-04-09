Feature: User can log in with valid username/password-combination

Scenario: nonexistent user can not login 
Given login is selected
When  incorrent username "paska" and incorrent password "paska" are given
Then  user is not logged in and error message is given2.