Feature: Testing the EditFunctionlaity
Scenario: Testing with Edit Lead
Given Enter username as 'Demosalesmanager'
And Enter password as 'crmsfa'
And click on login button
Given click on CRMSFA link
And Click Leads link
And Click Find leads
And Enter first name as 'swetha'
And Click on Find leads button
And Click on first resulting lead
And Verify title of the page
And Click Edit
And Change the company name as 'TCS'
And Click Update
And Confirm the changed name appears
