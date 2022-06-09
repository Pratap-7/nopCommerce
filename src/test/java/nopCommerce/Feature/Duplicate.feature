Feature: Testing the EditFunctionlaity
Scenario: Testing with Edit Lead
Given Enter username as 'Demosalesmanager'
And Enter password as 'crmsfa'
And click on login button
Given click on CRMSFA link
And Click Leads link
And Click Find leads
And Click on Email
And Enter Email as 'Abc@gmail.com'
And Click find leads button
And Capture name of First Resulting lead
And Click First Resulting lead
And Click Duplicate Lead
And Verify the title as 'Duplicate Lead'
And Click Create Lead
And Confirm the duplicated lead name is same as captured name
