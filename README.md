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
* ....
* ....
* ....

### Frontend

The front end is handled by FreeMarker, a Java templating engine.

FreeMarker allows us to insert code in a similar way to Nunjucks. The HTML page is generated in the backend then sent to the front end to be rendered. This removes dependencies on JavaScript being enabled front end.

## WebService

### How to start the WebService application

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/JavaWebService-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

### Health Check

To see your applications health enter url `http://localhost:8081/healthcheck`
