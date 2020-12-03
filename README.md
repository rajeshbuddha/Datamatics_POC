==================================================================================
Data Matrix Selenium Webdriver Rest-Assured Java Test Automation Framework
==================================================================================
This project is an test automation framework, which provides structured and standard way of 
creating automated test scripts for GUI, and API level tests(Extra Capabilaties). 

This framework supports automation of the following: - 
*Web Browsers (Firefox, Chrome, Internet Explorer)  
 
Tools & libraries
=================
The test automation framework is comprised of following tools and libraries  
*Cucumber-JVM:- BDD Framework  
*Custom Page Object Pattern and utility functions  
*Selenium WebDriver: - Browser automation framework
*JAVA: - Programming language  
*TestNg: - TestNg Java testing framework  
*Maven: - Build tool  
*Reporting: - Testng , Cucumber Pretty , Cucumber Advanced & Eclipse Reporting 
*Eclipse: - Integrated Development Environment  
*AssertJ: - Matcher's  
*Log4j: - Simple Logging Facade for Java  

Features
=================
Following are the features of this Automation Framework
*Creating Objects & Methods in Page Model which can be "reused"
*CCL  (common code library) - CCL – Helper Methods - Waits , Document upload , Random Data Generator, Elements Finder etc.,​
*Externalizing the Test data either via .xml or Excel or json files - Easy of Maintenance
*Cross Browser Testing – Running scripts in multiple browsers
*Parallel Execution – Executing scripts parallel​
*Jenkins Integration – Running scripts Manually , Schedule or Automatic mode(Simple steps to configure)
*GIT  Repository – For Check-in and Check-out of Code​(Simple steps to configure)
*Flexible Framework and easy adaptability for any project in no time
*Improvised results view with Screenshots for failures​
*Random/Dynamic Test Data Generation – reduced 90% data storage​
*Smart Synchronization Faster Execution

Machine Configuration
====================
Configure Windows and setup: -   
*Java 8  
*Git  / SVN  
*Maven  
*TestNG

IDE Configuration
==================
Eclipse plugins  
----------------
Configure and Install Following Plugins  
File >> Setting >> Plugins >> Browser Repositories>

*Git Integration/ SVN Integration  
*Maven Integration
*TestNg  
*Git Integration

Import Project and Run Tests
==========================

Eclipse >> File >> Import >> Maven >> Existing Maven Project >> Click Next >> Browser the Project Root Directory >> Finish

Right Click on Project >> Maven >> Update Project >> Select Force Update Of Snapshots/Releases >> OK

Expand TestSuites >> Web_SingleBrowser.xml >> Right Click >> Run As >> TestNG Suite

Compile Build or Run Tests
==========================

Command Line

cd to root ot automationFramework project directory

To clean and compile the build
-----------------------------
mvn clean install -DskipTests

To run all tests on dev environment
--------------------------------------
mvn clean install  

OR

mvn clean install -P dev  

*Note -P dev is default profile hence doesn't need to be specified for every run


Report
======

Local reports
-------------
CSV Report  
A report will be generated project level

Date wise Extent-emailable Html Report  
A report will be generated at /Reports/WebReports

Failed testcase video
A report will be generated at /Reports/FailedVideos


