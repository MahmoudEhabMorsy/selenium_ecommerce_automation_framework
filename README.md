# Asset Technical Task – UI Automation Framework

## Project Overview
This project is a UI automation testing framework built using Java, Selenium WebDriver, TestNG, and Maven. It follows the Page Object Model (POM) design pattern to ensure clean code structure, reusability, and maintainability.

The framework automates multiple end-to-end scenarios on the target web application, including product navigation, cart validation, deals interaction, and user sign-in functionality. It also includes TestNG listeners for enhanced test handling and automatic screenshot capture on test failure.

---

## Technology Stack
* Language: Java
* Browser Automation: Selenium WebDriver
* Test Framework: TestNG
* Build Tool: Maven
* Driver Management: WebDriverManager

---

## Project Structure
```text
src
├── Pages
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── ProductPage.java
│   ├── CartPage.java
│   ├── DealsPage.java
│   └── SignInPage.java
│
├── Tests
│   ├── BaseTest.java
│   ├── Scenario1Tests.java
│   ├── Scenario2Tests.java
│   ├── Scenario3Tests.java
│   ├── TestListener.java
│   └── utils
│       └── ScreenshotUtils.java
│
pom.xml
testng.xml

```

---

## Design Pattern

The Page Object Model (POM) is used to separate test logic from UI interactions. Each page of the application is represented by a dedicated Java class containing web element locators and page actions. Test classes focus strictly on test scenarios and validations.

---

## Prerequisites

Before running the project, ensure that the following are installed:

* Java JDK 24 or higher
* Maven
* Google Chrome browser
* IntelliJ IDEA or Eclipse (Optional)
* Allure (Optional)

---

## Execution Steps

### 1. Clone the Repository

```bash
git clone https://github.com/MahmoudEhabMorsy/AssetTechnicalTask.git

```

### 2. Import the Project into an IDE

Import the project into an IDE, preferably IntelliJ IDEA, as this was the primary environment used during development.

If the project is imported into another IDE (such as Eclipse), ensure the following:

* The build path is correctly configured.
* All required dependencies (Selenium, TestNG, etc.) are properly imported via Maven.
* Note: The project runs without additional configuration on IntelliJ IDEA. When tested on Eclipse, some reconfiguration was required, but the core logic remains functional.

### 3. Run the Tests

Execute the test suite using the testng.xml file. This can be performed by:

* Right-clicking testng.xml and selecting Run in the IDE.

---

## Test Reports

### TestNG Reports

TestNG reports are generated automatically after execution:

1. Navigate to the `test-output` folder.
2. Open the generated HTML or XML files (e.g., `index.html`) in a web browser to view detailed results.

### Allure Reports

Allure reports can be viewed using one of the following methods:

**Option 1: IntelliJ IDEA Plugin**

1. Install the Allure plugin in IntelliJ IDEA.
2. Right-click on the `allure-results` folder.
3. Select Allure -> Serve.

**Option 2: Command Line**

1. Install Allure (Refer to the official Allure Installation Guide).
2. Open a command prompt in the project root directory.
3. Execute the following command:
```bash
allure serve allure-results

```



---

## Test Scenarios

* Scenario 1: Product search and cart validation.
* Scenario 2: Deals page interaction and validation.
* Scenario 3: User sign-in functionality.

---

## Screenshots on Failure
The framework captures screenshots automatically upon test case failure. This is implemented via a TestNG listener and a reusable screenshot utility class located in `utils/ScreenshotUtils.java`. 

All captured images are stored in a dedicated folder named `Failure screenshots` within the project root directory for easy review and debugging.

---

## Author

Mahmoud Ehab Morsy

---

## License

This project is created for technical assessment and demonstration purposes.

