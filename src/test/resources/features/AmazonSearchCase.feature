@search-product
Feature: Product Searching

  Background: 
    Given I go to Amazon.com Home Page

  Scenario Outline: Searching a product from Home Page
    When I type <product> on search bar
    And I click on search button
    Then I validate the product whether results are related to <product>

    Examples: 
      | product   |
      | dove soap |

  Scenario Outline: Searching a prodcut from HomePage with enter
    When I type <product> on search bar
    And I press enter from keyboard
    Then I validate the product whether results are related to <product>

    Examples: 
      | product   |
      | dove soap |
