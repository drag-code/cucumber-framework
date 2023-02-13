Feature: Green Kart Top Deals Page Scenarios

  Scenario Outline: Pagination works properly
    Given User is on Top Deals Page
    When User changes page size to '<pageSize>'
    Then Each page should contain the same '<pageSize>'

    Examples: 
      | pageSize |
      |        5 |
      |       10 |
      |       20 |
