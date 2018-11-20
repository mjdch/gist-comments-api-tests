# GitHub Gists API Tests
## Overview
Implementation of tests for CRUD operation on Gists via REST API (https://developer.github.com/v3/gists/comments).
Authentication via oath2 token previously created in GitHub settings. Token authenticated only for Gists API.

## Technology
Technology stack:
* Java
* TestNG 6.14.3
* RestAssured 3.2.0
* Hamcrest 1.3
* Allure TestNG Report 2.8.1
* Maven

## Test
### Preconditions
Due to impossibility to feed data before tests without using API functionality itself. We need to setup it manually before each run.
This concern checking simple CRUD operations. Additional two simple scenario for deleting and updating created comment covering all of functionalities:
* Fetch list of comments
* Fetch single comment
* Create comment
* Update comment
* Delete comment

We need create three comments (https://gist.github.com/mjdch/7fc3ec4ad51852cded686f8c2d1a3cc6) and pass theirs ID as system parameters to JVM:

* **GET_COMMENT** - comment with text "FirstTest" 
* **EDIT_COMMENT** - comment which will be used in update operation
* **DELETE_COMMENT** - comment which will be used in delete operation


### Execution
Setup proper comments and pass it as in example above:
`mvn clean test -DGET_COMMENT=2764349 -DEDIT_COMMENT=2764351 -DDELETE_COMMENT=2764350`

:information_source: Provided IDs above should work for first run (the recent one while commiting README.md) so ust copy and paste command.

### Reports

Reports with two options:
* TestNG HTML Report in output folder `/target/surefire-reports`
* Allure Report: `/target/allure-results` 

Allure report generation:
1. Download allure CLI https://docs.qameta.io/allure/
2. cd `target`
3. `allure generate`
4. `cd allure-report`
5. `allure open .`

Or use CI plugin i.e https://wiki.jenkins.io/display/JENKINS/Allure+Plugin



