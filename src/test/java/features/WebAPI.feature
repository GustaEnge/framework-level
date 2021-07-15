#language:en
Feature: User access Product Subscription Configurator webserver (API)

    Background:
      Given I access the API


    # TC002-Add user with job
    @Regression
    Scenario Outline: TC002-Add user with job : Validate that it is possible to add a new user with a job
      Given I use user creation service
      And I set name <User>
      And I set job <Job>
      And I create a new register
      Then I validate my response is correct : <Message> with status <Code>
      Examples:
        | User | Job    | Message | Code |
        | Toy  | singer | Created | 201  |

    # TC003-Delete user
    @Regression
    Scenario: TC003-Delete user : Validate that it is possible to delete a user
      Given I use user creation service
      And I delete an user with id = 2
      Then the user has been deleted

    # TC004-Register new user without password
    @Regression
    Scenario Outline: TC004 – Register new user without password : Validate that is not possible to submit a register without password
      Given I use user creation service
      And I set email <Email>
      And I create a new register using email
      Then I validate my response is correct : <Message> with status <Code>
      Examples:
        |  Email                    | Code | Message                   |
        | challenge@automation.com  | 400  | Missing email or username |