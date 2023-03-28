Feature: Website Feature
  Background:
    Given Go to Techcrunch website

  Scenario: Verify Articles
    Then Each news has an author
    And Each news has an image

  Scenario: Verify Random Articles Content
    When Click Random Article
    Then The browser title is the same with the news title
    And Links within the news content