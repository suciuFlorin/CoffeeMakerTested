# CoffeeMakerTested
Testing and improving the CoffeeMaker app

# Project/Vscode setup

If you see any errors or squigly lines please correctly set up your project, vscode or add a jdk if you are missing one.

https://code.visualstudio.com/docs/java/java-tutorial

# Adding `ant` plus Tutorial (for Windows)

Ant binary dist 
    https://ant.apache.org/bindownload.cgi

Tutorial
    https://mkyong.com/ant/how-to-install-apache-ant-on-windows/

# Debugging

If you encounter:
* the error lambda expressions are not supported in -source 7

Install a new jdk version -> `jdk1.8.0_271`

# Running tests

The `build.xml` file contains a number of ant targets to run various testing
tools:
* `ant test` runs the manually-written test suite.
* `ant coverage` determines the coverage of the manually-written tests
using Cobertura.
* `ant randoop` generates test cases for the `Inventory` class using Randoop.
* `ant test.randoop` runs the Randoop-generated test cases.
* `ant coverage.randoop` uses Cobertura to collect coverage information
for the Randoop-generated test cases.
* `ant evosuite` generates tests for the `Inventory` class using EvoSuite.
* `ant test.evosuite` runs the EvoSuite-generated tests.
* `ant coverage.evosuite` generates a Cobertura report for the EvoSuite tests.

Personal note: Windows is an inferior platform for development
