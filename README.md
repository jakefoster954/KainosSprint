# Kainos Sprint
This is our code for our week 5 Kainos sprint.

## Project Structure

### Backend

MySQL is used as our database management system to handle the backend of the project.

The database is hosted on `academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com`

In order to connect to the database, you will need to add a `DbConnection.properties` file
 to the project's home directory with the following structure:

```
user=******
password=******
host=academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com
```

### Middle Layer

For our middle layer we are using dropwizard.io to handle the get and post requests.

The following routes are available for the application:
* /api/employee/job-roles
* /api/employee/helloWorld
* /api/employee/job-roles/{jobName}
* /api/employee/capabilities
* /api/employee/capabilities/{leadName}
* /api/employee/getCapabilities
* /api/employee/getBandLevels
* /api/employee/getJobNames
* /api/employee/getJobData/{jobName}
* /api/employee/getCapabilityLeads
* /api/employee/getCapabilityLeadData/{leadName}
* /api/admin/delete-job/{jobRoleName}
* /api/admin/add-job
* /api/admin/edit-job
* /api/admin/add-capability
* /api/admin/delete-capability/{capabilityName}
* /api/login

#### Logging
To change the logging level of the program, you can change the log4j2 yaml file located at `src/main/resources/log4j2.yml`.

### Frontend

The front end has been created using React in a separate repository.

This repository can be found at: https://github.com/jakefoster954/KainosSprintFrontend

## WebService

### How to start the WebService application

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/JavaWebService-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

### Health Check

To see your applications health enter url `http://localhost:8081/healthcheck`
