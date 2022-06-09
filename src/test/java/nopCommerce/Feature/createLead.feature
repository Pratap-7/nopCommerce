Feature: Testing the login Functionlaity
Scenario: Testing with valid credentials
Given Enter username as 'Demosalesmanager'
And Enter password as 'crmsfa'
And click on login button
Given click on CRMSFA link
And Click on contacts Button
And Click on Create Contact
And Enter FirstName Field as 'Baraniprakash'
And Enter LastName Field as 'prakashBarani'
And Enter FirstLocal Field as 'Barani local'
And Enter LastLocal Field as 'prakash local'
And Enter Department Field as 'mechanical'
And Enter Description Field as 'Engineer'
And Enter your email in the E-mail address Field as 'demo@gmail.com'
And Select StateProvince as 'New Mexico'
And Click on Add Contact
And Click on edit button 
And Clear the Description Field
And Fill ImportantNote Field as 'important Notes'
And Click on update button
And Get the Title of Resulting Page