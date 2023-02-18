@search-tables
Feature: Title of your feature

  Scenario Outline: Title of your scenario
    Given Go to home page
    When search for <search>
    And check the result ensuring every product has the word <keyword> in its title
    And add the last of found items to cart
    Then Empty cart

    Examples: 
      | search                | keyword |
      | stainless steel table | table   |
