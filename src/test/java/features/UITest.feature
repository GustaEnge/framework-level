#language:en
  Feature: User access Product Subscription Configurator webpage and the webserver
    # TC001-Product Subscription
    @Regression
    Scenario Outline: TC001-Product Subscription: Validate the product price for a full special support plan for 6 months simulation
      Given I open Chrome and launch the application
      And I select type <Type>
      And I select support plan <SupportPlan>
      When I write monthly duration of <Duration>
      And I write comments <Comments>
      #And I attach files : <path>
      And I click in calculate price button
      Then I validate price is <ExpectedPrice> $

      Examples:
      | Type    | SupportPlan | Duration | Comments | path | ExpectedPrice |
      | Special | Full        | 6        | Testing  |      | 2249.10       |
      | Regular | Full        | 6        | Testing  |      | 2249.10       |
