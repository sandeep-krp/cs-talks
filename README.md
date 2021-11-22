# CS-Talks

CS-Talks is a project to manage your tech conferences. It supports adding tech talks, attendees, etc. 

## Local development

The project is a simple spring-boot application hence can be run using the following simple commands. 
Make sure you have Java and maven configured properly.

Clone the repo:
```
git@github.com:sandeep-krp/cs-talks.git
```

Go inside cs-talks-web module in the repo:
```
cd cs-talks/cs-talks/cs-talks-web
```

Run the server
```
mvn spring-boot:run
```

The application can now be opened on the browser at http://localhost:8080

## API documentation

The full API documentation of can be viewed at http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
Here is snapshot of the same:
![Api Docs](docs/api/images/api.png?raw=true "API Doc")


The internal project structure is explained [here](docs/system/ProjectStructure.md)

