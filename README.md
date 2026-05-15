# Selenium E-Commerce UI Automation Framework

> **Note:** This project targets the Amazon website for automation practice purposes. Since Amazon frequently updates and changes its DOM structure, some locators or test flows may stop working over time and require maintenance updates.

## Overview

This project is a scalable UI automation testing framework built using Java, Selenium WebDriver, TestNG, and Maven.

The framework follows the Page Object Model (POM) design pattern to provide clean separation between test logic and page interactions, improving maintainability, readability, and scalability.

The project focuses on automating common e-commerce user workflows such as authentication validation, cart management, and navigation behavior.

---

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager
- Allure Reports

---

## Features

- Page Object Model architecture
- Reusable page components
- Centralized WebDriver setup
- Structured test organization
- Screenshot capture on failure
- Allure reporting integration
- Maven dependency management
- Scalable and maintainable framework structure
- Cross-test utility reuse

---

## Project Structure

```text
src
 └── main
      └── src
           ├── pages
           └── Tests
````

---

## Framework Architecture

The framework follows the Page Object Model (POM) design pattern:

* Page classes contain locators and page actions
* Test classes contain assertions and business scenarios
* Base classes centralize setup and teardown operations
* Listener handle reporting and failure screenshots

This structure improves maintainability and reduces code duplication.

---

## Test Coverage

The framework currently automates several e-commerce workflows including:

* Login validation scenarios
* Shopping cart operations
* Product interaction flows
* Navigation validation
* Negative authentication scenarios
* UI behavior verification

---

## Reporting

The project includes Allure reporting support for detailed test execution reporting.

### Generate Allure Report

```bash
allure serve allure-results
```

---

## Getting Started

### Prerequisites

Make sure the following are installed:

* Java JDK 17+ (or your project version)
* Maven
* Google Chrome
* Allure CLI (optional for reports)

---

## Installation

Clone the repository:

```bash
git clone https://github.com/MahmoudEhabMorsy/selenium_ecommerce_automation_framework.git
```

Navigate to the project directory:

```bash
cd selenium_ecommerce_automation_framework
```

Install dependencies:

```bash
mvn clean install
```

---

## Running Tests

Run all tests:

```bash
mvn test
```

Run a specific TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## Future Improvements

* Cross-browser execution support
* Parallel test execution
* Docker integration
* CI/CD pipeline integration
* Data-driven testing support
* API testing integration
* Environment-based configuration management

---

## Learning Objectives

This project was built to strengthen practical experience in:

* UI automation testing
* Selenium WebDriver
* Automation framework design
* Test architecture organization
* Maintainable test development
* Reporting and debugging workflows

---

## Disclaimer

This project is intended for educational and automation practice purposes only.

The target website structure may change over time, which can affect locator stability and test execution reliability.

---

## Author

Mahmoud Ehab
