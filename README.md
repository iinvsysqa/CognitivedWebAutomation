# Selenium Java POM Framework

## Overview

This project is a **Selenium WebDriver** automation framework using **Java** and **Page Object Model (POM)** design pattern. The framework is designed to provide a structured and scalable approach to UI test automation.

## Features

- **Page Object Model (POM)** for maintainable test scripts.
- **TestNG** for test execution and reporting.
- **Selenium WebDriver** for browser automation.
- **Maven** for dependency management.
- **Extent Reports** for enhanced test reporting.
- **Data-driven testing** with Excel (Apache POI).
- **CI/CD Integration** (Jenkins/GitHub Actions support).

## Project Structure

```
selenium-java-pom-framework/

│-- src/test/java/
│   │-- tests/         # Test classes
│   │-- pages/          # Page files
│-- test-output/       # TestNG reports
│-- pom.xml            # Maven dependencies and configurations
│-- config.properties  # Configuration file
```

## Prerequisites

- **Java JDK 11+**
- **Maven** (for dependency management)
- **TestNG Plugin** (for running tests)
- **Google Chrome/Firefox** (for running tests on browsers)

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/selenium-java-pom.git
   ```
2. Navigate to the project folder:
   ```sh
   cd selenium-java-pom
   ```
3. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```

## Running Tests

- To run all tests:
  ```sh
  mvn test
  ```
- To run a specific test class:
  ```sh
  mvn -Dtest=TestClassName test
  ```
- To run tests with TestNG XML suite:
  ```sh
  mvn test -DsuiteXmlFile=testng.xml
  ```

## Configuration

Modify the `config.properties` file to set the browser type, base URL, and other configurations:

```properties
baseURL=https://example.com
```

## Reporting

- Test execution results will be available in the Reports/` folder.
- Extent Reports can be generated for better visualization.

## CI/CD Integration

- Use Jenkins or GitHub Actions to trigger automated test runs.
- Sample command for Jenkins pipeline:
  ```sh
  mvn clean test
  ```
