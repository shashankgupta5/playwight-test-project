# playwright-test-project

## Description

A sample starter to begin with playwright with java bindings. Using maven as the build tool and TestNG as testing framework.
Using Java 19, feel free to update as per availability.

## Project Structure

The project follows the standard Maven structure, all test related configuration are read from default_config.properties placed under root directory. All modification goes there.

All tests go in the src\test\java\ui folder. Tests should be placed under test package and inherit from the BaseTest class.

TBA - For every test there should be a corresponding PageObject class under pageobejects package, hence each page is an object. These objects are instantiated under corresponding tests, making tests and UiObjects reside under different packages.

## Geting Started
````
1. Clone repository
2. Launch command prompt and type 'mvn clean test' and hit Enter
3. Test execution starts
4. Run logs created under ./logs/test-log.txt
5. Run command mvn allure:report to generate the allure reports at ./target/site/allure-maven-plugin/index.html
````

## What's New
v0.1 - Pilot