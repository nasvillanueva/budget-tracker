# Budget Tracker
Personal Budget Tracker for my daily expenses. 

## Quick Start Guide
### Things you need to install

* JDK 1.8 or above
* Maven
* IDE
* PostgreSQL

### Building the Application

* Create budget_tracker database with user/password set to postgres/password
* Run `mvn clean install -U [-Pdiff]` on root directory
* Run `diff` profile to update liquibase change log mapping with most recent entity changes

### Running the web app

* Run `mvn jetty:run [-o] [-Pupdate-db] [-Ppurge]` on project root dir
* Run `update-db` profile to sync local entities with the latest database definitions
* Run `purge` profile with `update-db` profile to drop schema before recreation of tables in liquibase

## Troubleshooting

* If you're getting a build error caused by [`CreateProcess error=193, %1 is not a valid Win32 application`]. Please download `node.exe` and `node.lib` manually from http://nodejs.org/dist/v4.2.3/win-x64/ and put it inside /src/main/webapp/node/