# Swagger Petstore API Automation

## Table of contents
* [General Information](#general-information)
* [Technologies Used](#technologies)
* [Decision Approach](#decision-approach)
* [Setup](#setup)
* [Execution](#execution)
* [Test Output](#test-output)

## General info
This project is to Automate Pet Store API Rest services. Using these services a user can perform many actions like a user can create user, login, update, delete, Fetch user information and logout.

## Technologies Used
Project is created with:
* REST-Assured: v4.3.0
* TestNG: v6.8
* maven

## Decision Approach
* As we need to automate the Rest APIs, so I have used REST Assured APIs to automate them.
* TestNG runner provides lot of annotations using which a tester can handle the execution so that I have used TestNG as a test runner for this project.
* I have made a hybrid framework where I have created three different packages under src/test/java. In package com.PetStroeAPI.Base is have created a class which have a common code which will be used by all the test cases. In package com.PetStroeAPI.TestCases, I am created all the test cases. And in package com.PetStroeAPI.Utilities, I have defined a class in which i have written methods to create random date for Username, passwords,etc.

## Setup
To run this project, Please make sure following points are covered:
* Please make sure that the JAVA is installed.
* Please make sure that the JAVA HOME is Set.
* Please make sure that the MAVEN HOME is set.
* Please make sure that you have copied all the dependencies like testng, selenium, etc is copied in pom.xml file. though it will be already there when the project is cloned, but please make sure that they are present.


## Execution
To Execute this project:
* Please create a local repository on your Local system.
* Run Testng.xml file to execuet all the test cases in one shot.

## Test Output
* Test output of the execution will be generated in test-output folder.
* This folder will provide results in many formats.
