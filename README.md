# PetStore Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Packaging and running the application

If you want to build an _??ber-jar_, execute the following command:

    ./gradlew build -Dquarkus.package.type=uber-jar

To run the application:

    java -jar build/petstore-runner.jar

The application can be also packaged using simple:

    ./gradlew build

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it is not an _??ber-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

To launch the test page, open your browser at the following URL

    http://localhost:8080/index.html

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

    ./gradlew quarkusDev

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Creating a native executable

Mind having GRAALVM_HOME set to your Mandrel or GraalVM installation.

You can create a native executable using:

    ./gradlew build -Dquarkus.package.type=native

Or, if you don't have [Mandrel](https://github.com/graalvm/mandrel/releases/) or
[GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases) installed, you can run the native executable
build in a container using:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true

Or to use Mandrel distribution:

    ./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel:20.3-java11

You can then execute your native executable with:

    ./build/petstore-runner

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Deploying the Application
To deploy the demo app on a docker-compose please visit [./deploy](https://github.com/rasika/petstore/tree/master/deploy)

## How to run a CURL command to test the APIs once deployed
CURL is free command line tool. it uses URL syntax to transfer data to and from servers. simple terms it allow use to send request and get the response.
go to cmd and type curl. then type curl --help
to check curl is functioning well, type curl http://www.google.com (it shows bulk of data)
@ Let's discuss how to run the curl command using postman
1) open the postman software
2) click import and select Raw text
3) type or paste your curl command 
4) click continue button then click import button
5) change your request name if you want
6) finally click the send and you will be seen the response data

**_Example for Curl Commands_**
1) verbose => curl -v http://www.example.com/
2) output => curl -o out.json http://www.example.com/index.html
3) HTTP GET => curl -v http://localhost:8080/v1/pets
4) HTTP POST => curl -d 'id=9&name=baeldung' http://localhost:8080/v1/pets/addOne
5) HTTP DELETE => curl -X DELETE http://localhost:8080/v1/pets/2

## How to run test suite in Eclipse and alterative testing methods
Create Test Suites in Eclipse => https://www.codejava.net/testing/junit-test-suite-example-how-to-create-and-run-test-suite-in-command-line-and-eclipse
According to the petstore we can test our project within two ways. they are, using the postman testing tool and using test module inside the gradle project(building tool)
when you are using inbuilt testing module you have to create test cases inside the gradle project and check it.
I have demonstrated postman testing in my pdf document.

## Abstraction of the gradle projects that I have learnt from the assignment
There are mainly two types of Java projects using building tools. They are gradle java projects and maven java projects
Gradle projects are more popular by these days due to their performance and usabilityness 
when it comes to the gradle project they have their own file structure and most important thing is these project can be run on any platform.
there are two files called gradlew and gradlew.bat. gradlew can be used to build your project using your shell. gradlew.bat can be used to build the project by using the windows command prompt
if you want to run a gradle project you need to install gradle in your machine. but the peoject is consist with gradle wrapper you dont need to install gradle in your machine
because the project is run on the graddle version intended in the wrapper
This gradle file structure consist with testing module also. by using this you can do integration and unit testing
Build.gradle consist with repositeries and dependencies. If you want to add new dependancy you can add the new one at there.


