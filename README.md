<br/>
<p align="center">
  <h3 align="center">Web Automation</h3>

  <p align="center">
    Web Automation Cases with Java | Cucumber | Gherkin
    <br/>
    <br/>
  </p>
</p>



## About The Project

Amazon Test Case
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

Webstaurantstore Test Case
Feature: Webstaurantstore

  Scenario Outline: Webstaurantstore Search Case
    Given Go to home page
    When search for <search>
    And check the result ensuring every product has the word <keyword> in its title
    And add the last of found items to cart
    Then Empty cart

    Examples: 
      | search                | keyword |
      | stainless steel table | table   |



## Built With

Java, Selenium, Cucumber, TestNG, JUnit

## Authors

* **ozkansaricam** -
*Computer Engineer | Java Developer  | Software Development Engineer in Test* -
[ozkansaricam](https://github.com/ozkansaricam) 


