# Metric to Imperial Converter
Metric to Imperial Converter

Requirements:

JDK 11
Maven
MySQL

The application relies on a MySQL database for persistence.

The application runs on port 8090.

There are 2 ways to run the application:
1. Using Docker.
2. As a standalone application.

Using Docker:
1. Run mvn clean install -DskipTests
2. Run docker-compose up --build -d

As a standalone application:
1. Configure the database configurations in application.properties
2. Build the application with mvn clean install -DskipTests
3. Run java -jar /target/metric-to-imperial-converter-0.0.1-SNAPSHOT.jar

No Maven Installation:
To run the build in the absence of a Maven installation, run the build with the Maven Wrapper as follows:
./mvnw clean install

Running tests:
mvn clean install

Endpoints:
List Conversions: GET http://localhost:8090/conversion/

Add Conversion: POST http://localhost:8090/conversion/add
                Example Body: {
                              "name": "f to c",
                              "sourceUnit": "f",
                              "destinationUnit": "c",
                              "toRate": null,
                              "fromRate": null,
                              "converter": "FareinheitCelciusConverter",
                              "conversionType": "FORMULA"
                              }

Convert: POST http://localhost:8090/conversion/
         Example Body: {
                        "sourceUnit": "c",
                        "destinationUnit": "f",
                        "amount": 56
                       }

Known Issues:
1. No validation
2. Little exception handling
