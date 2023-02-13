Feature: Green Kart Home Page Scenarios

  @Smoke
  Scenario Outline: Search by product name
    Given User is on homepage
    When User enters '<productName>' into searchbar
    Then User should see only '<productName>' results

    Examples: 
      | productName |
      | brocolli    |
      | cauliflower |
      | apple       |

  @Smoke
  Scenario: Displaying products when Home Page loads
    Given User is on homepage
    Then User should be able to see a list of products

  @Smoke
  Scenario Outline: Adding products to the cart
    Given User is on homepage
    When User selects '<productName>' and '<quantity>' and clicks add to cart button
    And Clicks on cart section
    Then The quantity and productName displayed should match with '<productName>' and '<quantity>' selected

    Examples: 
      | productName | quantity |
      | Brocolli    |        1 |
      | Carrot      |        2 |
      | Capsicum    |        2 |

  Scenario Outline: Links inside the header section are working
    Given User is on homepage
    When User clicks '<linkName>'
    Then User should navigate to '<url>' of the page
    And '<url>' status code should be 200

    Examples: 
      | linkName                                               | url                                                          |
      | Top Deals                                              | https://rahulshettyacademy.com/seleniumPractise/&hash/offers |
      | Flight Booking                                         | https://rahulshettyacademy.com/dropdownsPractise/            |
      | Free Access to InterviewQues/ResumeAssistance/Material | https://rahulshettyacademy.com/documents-request             |
