# Budget Tracker
Personal Budget Tracker for my daily expenses. 

## Quick Start Guide
### Things you need to install

* JDK 1.8 or above
* Maven
* IDE
* Postgresql

### Building the Application

* Create budget_tracker database with user/password set to postgres/password
* Run `mvn clean install -U [-Pdiff]` on root directory
* Run `diff` profile to update liquibase change log mapping with most recent entity changes

### Running the web app

* Run `mvn jetty:run [-o] [-Pupdate-db] [-Ppurge]` on project root dir
* Run `update-db` profile to sync local entities with the latest database definitions
* Run `purge` profile with `update-db` profile to drop schema before recreation of tables in liquibase
