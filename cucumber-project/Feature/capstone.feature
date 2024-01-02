Feature: Verify title, text, dropdown selection, hyperlink presence on the page

Scenario: Verification of title of the page
Given launch url
Then verify title

Scenario: Verification of text on the page
Given launch url
When click on A/B Testing link
Then verify main headline text "A/B Test Control"

Scenario: Verification of dropdown selection on the page
Given launch url
When click on A/B Testing link
And go back to home page
And click on Dropdown link
And select "Option 1" value from dropdown
Then confirm "Option 1" is selected or not

Scenario: Verification of hyperlink presented on the page
Given launch url
When click on Dropdown link
And go back to home page
And click on Frames link
Then verify "Nested Frames" & "iFrame" links are presented on page

Scenario: Verification of checkbox selection & file upload on the page
Given launch url
When click on Checkboxes link
Then verify text "Checkboxes"
Then verify "checkbox 1" is not checked
And verify "checkbox 2" is checked
And go back to home page
When click on File Upload link
Then verify text "File Uploader"
And click on Choose File button
And click on upload button